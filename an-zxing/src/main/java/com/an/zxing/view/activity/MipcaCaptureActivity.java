package com.an.zxing.view.activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Vibrator;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.an.an_zxing.R;
import com.an.base.view.SuperActivity;
import com.an.zxing.utils.CodeUtils;
import com.an.zxing.utils.camera.CameraManager;
import com.an.zxing.utils.decoding.CaptureActivityHandler;
import com.an.zxing.utils.decoding.InactivityTimer;
import com.an.zxing.utils.decoding.RGBLuminanceSource;
import com.an.zxing.view.widget.ViewfinderView;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.ChecksumException;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.qrcode.QRCodeReader;

import java.io.IOException;
import java.util.Collections;
import java.util.Hashtable;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.Vector;

import static android.view.View.INVISIBLE;
import static android.view.View.VISIBLE;

/*
*  作者：qydq/shiluohua,
 * email:qyddai@gmail.com
 * 如使用标明出处。连续扫描二维码的MipcaActivity
* */
public class MipcaCaptureActivity extends SuperActivity implements Callback, View.OnClickListener {

    private CaptureActivityHandler handler;
    private ViewfinderView viewfinderView;
    private boolean hasSurface;
    private Vector<BarcodeFormat> decodeFormats;
    private String characterSet;
    private InactivityTimer inactivityTimer;
    private MediaPlayer mediaPlayer;
    private boolean playBeep;
    private static final float BEEP_VOLUME = 0.10f;
    private boolean vibrate;


    private static final int REQUEST_CODE = 100;
    private static final int PARSE_BARCODE_SUC = 300;
    private static final int PARSE_BARCODE_FAIL = 303;
    private static final int PARSE_IMAGE_FAIL = 305;
    private ProgressDialog mProgress;
    private String photo_path;
    private Bitmap scanBitmap;
    private TextView tvCount;
    private TextView tvCounts;
    Set<String> mLinkedSetString = Collections.synchronizedSet(new LinkedHashSet<String>());
    private int times = 1;
    private int time = 0;
    private String listsString;

    @Override
    public void initView() {
        setContentView(R.layout.an_activity_zxing_mipcapture);
        //ViewUtil.addTopView(getApplicationContext(), this, R.string.scan_card);
        CameraManager.init(getApplication());
        viewfinderView = (ViewfinderView) findViewById(R.id.viewfinder_view);
        tvCount = (TextView) findViewById(R.id.tvCount);
        tvCounts = (TextView) findViewById(R.id.tvCounts);
        Button mButtonBack = (Button) findViewById(R.id.button_back);
        mButtonBack.setOnClickListener(this);
        hasSurface = false;
        inactivityTimer = new InactivityTimer(this);
        times = getIntent().getIntExtra("times", 1);
        tvCounts.setText("注意：您可以扫描" + times + "次");
        ImageButton mImageButton = (ImageButton) findViewById(R.id.button_function);
        int status = getIntent().getIntExtra(CodeUtils.STATUS_SHOW, INVISIBLE);
        if (status == VISIBLE) {
            mImageButton.setVisibility(View.VISIBLE);
        }
        mImageButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        //不能用switch，这个算是一个bug吧，2016.08月注释，孙顺涛！
        int id = v.getId();
        if (id == R.id.button_back) {
            this.finish();
        } else if (id == R.id.button_function) {
            //打开手机中的相册
            Intent innerIntent = new Intent(Intent.ACTION_GET_CONTENT); //"android.intent.action.GET_CONTENT"
            innerIntent.setType("image/*");
            Intent wrapperIntent = Intent.createChooser(innerIntent, "选择二维码图片");
            this.startActivityForResult(wrapperIntent, REQUEST_CODE);
        } else {
            System.out.println("MipcaActivitycapture 异常，onClick");
        }
    }


    private Handler mHandler = new Handler() {

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

            mProgress.dismiss();
            switch (msg.what) {
                case PARSE_BARCODE_FAIL:
                    Toast.makeText(MipcaCaptureActivity.this, (String) msg.obj, Toast.LENGTH_LONG).show();
                    break;
                case PARSE_IMAGE_FAIL:
                    onResultHandler((String) msg.obj, scanBitmap);//只要handler到此方法，scanBitmap肯定是有值的。
                    break;
            }
        }

    };


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            switch (requestCode) {
                case REQUEST_CODE:
                    //获取选中图片的路径
                    Cursor cursor = getContentResolver().query(data.getData(), null, null, null, null);
                    if (cursor.moveToFirst()) {
                        photo_path = cursor.getString(cursor.getColumnIndex(MediaStore.Images.Media.DATA));
                    }
                    cursor.close();

                    mProgress = new ProgressDialog(MipcaCaptureActivity.this);
                    mProgress.setMessage("正在扫描...");
                    mProgress.setCancelable(false);
                    mProgress.show();

                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            Result result = scanningImage(photo_path);
                            if (result != null) {
                                Message m = mHandler.obtainMessage();
                                m.what = PARSE_IMAGE_FAIL;
                                m.obj = result.getText();
                                mHandler.sendMessage(m);
                            } else {
                                Message m = mHandler.obtainMessage();
                                m.what = PARSE_BARCODE_FAIL;
                                m.obj = "Scan failed!";
                                mHandler.sendMessage(m);
                            }
                        }
                    }).start();

                    break;
            }
        }
    }

    /**
     * 扫描二维码图片的方法
     *
     * @param path
     * @return
     */
    public Result scanningImage(String path) {
        if (TextUtils.isEmpty(path)) {
            return null;
        }
        Hashtable<DecodeHintType, String> hints = new Hashtable<DecodeHintType, String>();
        hints.put(DecodeHintType.CHARACTER_SET, "UTF8"); //设置二维码内容的编码

        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true; // 先获取原大小
        scanBitmap = BitmapFactory.decodeFile(path, options);
        options.inJustDecodeBounds = false; // 获取新的大小
        int sampleSize = (int) (options.outHeight / (float) 200);
        if (sampleSize <= 0)
            sampleSize = 1;
        options.inSampleSize = sampleSize;
        scanBitmap = BitmapFactory.decodeFile(path, options);
        RGBLuminanceSource source = new RGBLuminanceSource(scanBitmap);
        BinaryBitmap bitmap1 = new BinaryBitmap(new HybridBinarizer(source));
        QRCodeReader reader = new QRCodeReader();
        try {
            return reader.decode(bitmap1, hints);
        } catch (NotFoundException e) {
            e.printStackTrace();
        } catch (ChecksumException e) {
            e.printStackTrace();
        } catch (FormatException e) {
            e.printStackTrace();
        }
        return null;
    }


    @Override
    protected void onResume() {
        super.onResume();
        SurfaceView surfaceView = (SurfaceView) findViewById(R.id.preview_view);
        SurfaceHolder surfaceHolder = surfaceView.getHolder();
        if (hasSurface) {
            initCamera(surfaceHolder);
        } else {
            surfaceHolder.addCallback(this);
            surfaceHolder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);
        }
        decodeFormats = null;
        characterSet = null;

        playBeep = true;
        AudioManager audioService = (AudioManager) getSystemService(AUDIO_SERVICE);
        if (audioService.getRingerMode() != AudioManager.RINGER_MODE_NORMAL) {
            playBeep = false;
        }
        initBeepSound();
        vibrate = true;

    }

    @Override
    protected void onPause() {
        super.onPause();
        if (handler != null) {
            handler.quitSynchronously();
            handler = null;
        }
        CameraManager.get().closeDriver();
    }

    @Override
    protected void onDestroy() {
        inactivityTimer.shutdown();
        super.onDestroy();
    }

    /**
     * 处理扫描结果
     * //这里修改为pulic实现连续扫面，必要时请修改为private
     * initCamera();
     * if (mHandler != null)
     * mHandler.restartPreviewAndDecode();
     * 在扫描完毕后执行这3句即可。
     * 说明：
     * 1.扫描处理方法为CaptureActivity的handleDecode方法，所以这3句加在最后即可。
     * 2.initCamera方法是有参数的，可参考onResume方法改为：
     * SurfaceView surfaceView = (SurfaceView)findViewById(R.id.preview_view);;
     * SurfaceHolder surfaceHolder = surfaceView.getHolder();
     * initCamera(surfaceHolder);
     * 3.mHandler即为当前Activity中的CaptureActivityHandler。
     * 4.restartPreviewAndDecode方法在com.zxing.decoding.CaptureActivityHandler中，要改为public。
     *
     * @param result
     * @param barcode
     */
    public void handleDecode(Result result, Bitmap barcode) {
        inactivityTimer.onActivity();
        playBeepSoundAndVibrate();
        String resultString = result.getText();
        //第一次运行该方法，把二维码添加到mLinkedSetString集合中，并把times值初始化为1。
        if (time == 0) {
            mLinkedSetString.add(resultString);
            time = 1;
            tvCount.setText("已扫描" + time + "次");
        }
        tvCount.setText("已扫描" + time + "次");
        SurfaceView surfaceView = (SurfaceView) findViewById(R.id.preview_view);
        SurfaceHolder surfaceHolder = surfaceView.getHolder();
        initCamera(surfaceHolder);
        if (time < times) {
            if (mLinkedSetString.contains(resultString)) {
                Toast.makeText(getApplicationContext(), "此码已被扫描，请勿重新扫描", Toast.LENGTH_SHORT).show();
                System.out.println("qydq已存在该结果，times次数为：" + time);
            } else {
                time++;
                System.out.println("qydq不存在该结果，添加数据！");
                tvCount.setText("已扫描" + time + "次");
                mLinkedSetString.add(resultString);
            }
            System.out.println("qydq测试集合：" + mLinkedSetString.toString());
            //放到这里了的目的是为了连续的扫描，不管集合是否包含下一次的扫描的数据都要让二维码进行扫描才能对比数据。
            if (handler != null)
                handler.restartPreviewAndDecode();
        } else {
            tvCount.setText("已扫描" + time + "次");
            listsString = mLinkedSetString.toString();
            tvCount.setText("扫描结束，正在为你上传数据，waiting...");
            System.out.println("qydq超过扫描次数！当前数据为：" + mLinkedSetString.toString());
            System.out.println("qydq超过扫描次数！listsString：" + listsString);
            //超过扫描次数则把数据返回回去在上一个activity中用onActivityResult接受result参数，延迟3秒。
            try {
                Thread.sleep(5000);//阻断5秒
                onResultHandler(resultString, listsString, barcode);//resultString当前为最后一次数据。
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        /*下面为集合类解析例子
        一行代码实现list去除重复元素
        样例运行结果： list with dup:[1, 2, 3, 1]
        list without dup:[3, 2, 1]*/

        /*List<String> listWithDup = new ArrayList<String>();
        listWithDup.add("1");
        listWithDup.add("2");
        listWithDup.add("3");
        listWithDup.add("1");
        List<String> listWithoutDup = new ArrayList<String>(new HashSet<String>(listWithDup));
        System.out.println("list with dup:" + listWithDup);
        System.out.println("list without dup:" + listWithoutDup);*/
    }

    /**
     * 跳转到上一个页面
     *
     * @param resultString
     * @param bitmap
     */
    private void onResultHandler(String resultString, String listsString, Bitmap bitmap) {
        if (TextUtils.isEmpty(resultString) || TextUtils.isEmpty(listsString)) {
            Toast.makeText(MipcaCaptureActivity.this, "Scan failed!", Toast.LENGTH_SHORT).show();
            return;
        }
        Intent resultIntent = new Intent();
        Bundle bundle = new Bundle();
        bundle.putString(CodeUtils.RESULT_STRING, resultString);
        bundle.putString(CodeUtils.RESULT_LISTS, listsString);
        bundle.putParcelable(CodeUtils.RESULT_BITMAP, bitmap);
        resultIntent.putExtras(bundle);
        this.setResult(RESULT_OK, resultIntent);
        MipcaCaptureActivity.this.finish();
    }

    /**
     * 跳转到上一个页面,主要是针对多次扫描点击图片的方法。
     *
     * @param resultString
     * @param bitmap
     */
    private void onResultHandler(String resultString, Bitmap bitmap) {
        if (TextUtils.isEmpty(resultString)) {
            Toast.makeText(MipcaCaptureActivity.this, "Scan failed!", Toast.LENGTH_SHORT).show();
            return;
        }
        Intent resultIntent = new Intent();
        Bundle bundle = new Bundle();
        bundle.putString(CodeUtils.RESULT_STRING, resultString);
        bundle.putParcelable(CodeUtils.RESULT_BITMAP, bitmap);
        resultIntent.putExtras(bundle);
        this.setResult(RESULT_OK, resultIntent);
        MipcaCaptureActivity.this.finish();
    }

    private void initCamera(SurfaceHolder surfaceHolder) {
        try {
            CameraManager.get().openDriver(surfaceHolder);
        } catch (IOException ioe) {
            return;
        } catch (RuntimeException e) {
            return;
        }
        if (handler == null) {
            handler = new CaptureActivityHandler(this, decodeFormats, characterSet);
        }
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width,
                               int height) {

    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        if (!hasSurface) {
            hasSurface = true;
            initCamera(holder);
        }

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        hasSurface = false;

    }

    public ViewfinderView getViewfinderView() {
        return viewfinderView;
    }

    public Handler getHandler() {
        return handler;
    }

    public void drawViewfinder() {
        viewfinderView.drawViewfinder();

    }

    private void initBeepSound() {
        if (playBeep && mediaPlayer == null) {
            // The volume on STREAM_SYSTEM is not adjustable, and users found it
            // too loud,
            // so we now play on the music stream.
            setVolumeControlStream(AudioManager.STREAM_MUSIC);
            mediaPlayer = new MediaPlayer();
            mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
            mediaPlayer.setOnCompletionListener(beepListener);

            AssetFileDescriptor file = getResources().openRawResourceFd(
                    R.raw.beep);
            try {
                mediaPlayer.setDataSource(file.getFileDescriptor(),
                        file.getStartOffset(), file.getLength());
                file.close();
                mediaPlayer.setVolume(BEEP_VOLUME, BEEP_VOLUME);
                mediaPlayer.prepare();
            } catch (IOException e) {
                mediaPlayer = null;
            }
        }
    }

    private static final long VIBRATE_DURATION = 200L;

    private void playBeepSoundAndVibrate() {
        if (playBeep && mediaPlayer != null) {
            mediaPlayer.start();
        }
        if (vibrate) {
            Vibrator vibrator = (Vibrator) getSystemService(VIBRATOR_SERVICE);
            vibrator.vibrate(VIBRATE_DURATION);
        }
    }

    /**
     * When the beep has finished playing, rewind to queue up another one.
     */
    private final OnCompletionListener beepListener = new OnCompletionListener() {
        public void onCompletion(MediaPlayer mediaPlayer) {
            mediaPlayer.seekTo(0);
        }
    };


}