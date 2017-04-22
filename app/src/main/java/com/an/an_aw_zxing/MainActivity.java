package com.an.an_aw_zxing;


import android.app.Activity;
import android.content.ContentResolver;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.design.widget.Snackbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.an.zxing.utils.CodeUtils;
import com.an.zxing.utils.encoding.EncodingHandler;
import com.an.zxing.view.activity.CaptureActivity;
import com.an.zxing.view.activity.MipcaCaptureActivity;

import static android.view.View.VISIBLE;

/*
* 作者：qydq/shiluohua,
 * email:qyddai@gmail.com
 * 如使用标明出处。
* */
public class MainActivity extends Activity implements View.OnClickListener {

    //如果要实现连续扫描请调用handler.restartPreviewAndDecode();

    public static final int REQUEST_IMAGE = 101;//图库
    public static final int REQUEST_SELF = 102;//自定义
    public final static int REQUEST_CONTINUOUS = 104;//多次扫码
    public static final int REQUEST_DEFAULT = 103;//默认的
    /**
     * 显示扫描结果
     */
    private TextView mTextView;
    private TextView ivMoren;
    /**
     * 显示扫描拍的图片
     */
    private ImageView mImageView;
    private ImageView imageViewMoren;
    private ImageView imagePhto;

    /**
     * 显示创建的二维码
     */
    private ImageView qrImgImageView;
    /**
     * 输入需要生成的二维码信息
     */
    private EditText qrStrEditText;
    /**
     * 显示结果
     */
    private TextView resultTextView;
    private TextView ivPhoto;
    private TextView ivSelf;
    private EditText editText;

    LinearLayout rll;


    private Button mButton;
    private Button btnaddCode;
    private Button btn3;
    private Button btn4;
    private Button btnSelf;
    private Button btnZhifubao;
    private Button btnWeixin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextView = (TextView) findViewById(R.id.result);
        rll = (LinearLayout) findViewById(R.id.rll);
        mImageView = (ImageView) findViewById(R.id.qrcode_bitmap);
        qrStrEditText = (EditText) this.findViewById(R.id.et_qr_string);
        qrImgImageView = (ImageView) this.findViewById(R.id.iv_qr_image);
        imageViewMoren = (ImageView) this.findViewById(R.id.imageViewMoren);
        imagePhto = (ImageView) this.findViewById(R.id.imagePhto);
        resultTextView = (TextView) this.findViewById(R.id.tv_scan_result);
        ivPhoto = (TextView) this.findViewById(R.id.ivPhoto);
        ivMoren = (TextView) this.findViewById(R.id.ivMoren);
        ivSelf = (TextView) this.findViewById(R.id.ivSelf);
        editText = (EditText) this.findViewById(R.id.editText);

        btn3 = (Button) findViewById(R.id.btn3);
        btnWeixin = (Button) findViewById(R.id.btnWeixin);
        btn4 = (Button) findViewById(R.id.btn4);
        btnSelf = (Button) findViewById(R.id.btnSelf);
        mButton = (Button) findViewById(R.id.button1);
        btnaddCode = (Button) this.findViewById(R.id.btn_add_qrcode);
        btnZhifubao = (Button) this.findViewById(R.id.btnZhifubao);

        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        mButton.setOnClickListener(this);
        btnSelf.setOnClickListener(this);
        btnaddCode.setOnClickListener(this);
        btnZhifubao.setOnClickListener(this);
        btnWeixin.setOnClickListener(this);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case REQUEST_CONTINUOUS://连续扫码。
                if (resultCode == RESULT_OK) {
                    Bundle bundle = data.getExtras();
                    //显示扫描到的内容
//                    mTextView.setText(bundle.getString("result"));//得到最后一次的扫描结果。
                    mTextView.setText(bundle.getString(CodeUtils.RESULT_LISTS));//得到组装后的扫描结果。
                    //显示
                    mImageView.setImageBitmap((Bitmap) data.getParcelableExtra(CodeUtils.RESULT_BITMAP));
                }
                break;
            case REQUEST_IMAGE://相册二维码。
                if (data != null) {
                    Uri uri = data.getData();
                    ContentResolver cr = getContentResolver();
                    try {
                        Bitmap mBitmap = MediaStore.Images.Media.getBitmap(cr, uri);//显得到bitmap图片

                        CodeUtils.analyzeBitmap(mBitmap, new CodeUtils.AnalyzeCallback() {
                            @Override
                            public void onAnalyzeSuccess(Bitmap mBitmap, String result) {
                                Toast.makeText(MainActivity.this, "解析结果:" + result, Toast.LENGTH_LONG).show();
                                ivPhoto.setText("相册解析结果:" + result);
                                imagePhto.setImageBitmap(mBitmap);
                            }

                            @Override
                            public void onAnalyzeFailed() {
                                Toast.makeText(MainActivity.this, "解析二维码失败", Toast.LENGTH_LONG).show();
                                ivPhoto.setText("相册解析二维码失败");
                            }
                        });

        /*                if (mBitmap != null) {
                            mBitmap.recycle();
                        }*/
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                break;
            case REQUEST_DEFAULT://默认扫码
                //处理扫描结果（在界面上显示）
                if (null != data) {
                    Bundle bundle = data.getExtras();
                    if (bundle == null) {
                        return;
                    }
                    if (bundle.getInt(CodeUtils.RESULT_TYPE) == CodeUtils.RESULT_SUCCESS) {
                        String result = bundle.getString(CodeUtils.RESULT_STRING);
                        Toast.makeText(this, "解析结果:" + result, Toast.LENGTH_LONG).show();
                        ivMoren.setText("默认解析结果:" + result);
                    } else if (bundle.getInt(CodeUtils.RESULT_TYPE) == CodeUtils.RESULT_FAILED) {
                        Toast.makeText(MainActivity.this, "解析二维码失败", Toast.LENGTH_LONG).show();
                        ivMoren.setText("默认解析结果:" + "解析二维码失败");
                    }
                    Bitmap bitmap = data.getParcelableExtra(CodeUtils.RESULT_BITMAP);
                    if (bitmap != null) {
                        imageViewMoren.setImageBitmap(bitmap);
                    }
                }
                break;
            case REQUEST_SELF:
                if (null != data) {
                    Bundle bundle = data.getExtras();
                    if (bundle == null) {
                        return;
                    }
                    if (bundle.getInt(CodeUtils.RESULT_TYPE) == CodeUtils.RESULT_SUCCESS) {
                        String result = bundle.getString(CodeUtils.RESULT_STRING);
                        Toast.makeText(this, "解析结果:" + result, Toast.LENGTH_LONG).show();
                        ivSelf.setText("自定义界面解析结果:" + result);
                    } else if (bundle.getInt(CodeUtils.RESULT_TYPE) == CodeUtils.RESULT_FAILED) {
                        Toast.makeText(MainActivity.this, "解析二维码失败", Toast.LENGTH_LONG).show();
                        ivSelf.setText("自定义界面解析结果:" + "解析二维码失败");
                    }
                }
                break;

            default:
                mTextView.setText("解析二维码失败");
                break;
        }
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        switch (v.getId()) {
            case R.id.btn4://相册二维码
                intent.setAction(Intent.ACTION_GET_CONTENT);
                intent.addCategory(Intent.CATEGORY_OPENABLE);
                intent.setType("image/*");
                startActivityForResult(intent, REQUEST_IMAGE);
                break;
            case R.id.btn3://扫描默认二维码。
                intent.setClass(MainActivity.this, CaptureActivity.class);
                intent.putExtra(CodeUtils.STATUS_SHOW, VISIBLE);//控制右边的按钮是否显示。
                startActivityForResult(intent, REQUEST_DEFAULT);
                break;
            //点击按钮跳转到二维码扫描界面，这里用的是startActivityForResult跳转
            //扫描完了之后调到该界面/连续扫描
            case R.id.button1:
                String strNumb = editText.getText().toString().trim();
                if (TextUtils.isEmpty(strNumb)) {
                    strNumb = "1";
                }
                int number = Integer.parseInt(strNumb);
                intent.putExtra("times", number);
                Toast.makeText(getApplicationContext(), "您可以扫描" + number + "次", Toast.LENGTH_SHORT).show();
                intent.setClass(MainActivity.this, MipcaCaptureActivity.class);
                intent.putExtra(CodeUtils.STATUS_SHOW, VISIBLE);//控制右边的按钮是否显示。
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivityForResult(intent, REQUEST_CONTINUOUS);
                break;
            case R.id.btn_add_qrcode://创建二维码图片
                String contentString = qrStrEditText.getText().toString();
                if (TextUtils.isEmpty(contentString)) {
                    Snackbar.make(rll, "输入的内容不能为空!", Snackbar.LENGTH_SHORT).setAction("Undo",
                            new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    Toast.makeText(getApplication(), "请输入内容后再试试", Toast.LENGTH_SHORT).show();
                                }
                            }).show();

                } else {
                    //根据字符串生成二维码图片并显示在界面上，第二个参数为图片的大小（350*350）
                    Bitmap qrCodeBitmap = null;
                    //生成不带log的二维码
//                    qrCodeBitmap = EncodingHandler.createImage(contentString, 400, 400, null);
                    //生成带log的二维码
                    qrCodeBitmap = EncodingHandler.createImage(contentString, 400, 400, BitmapFactory.decodeResource(getResources(), R.mipmap.yy));

                    qrImgImageView.setImageBitmap(qrCodeBitmap);
                }
                break;
            case R.id.btnSelf:
                /**
                 * 执行扫面Fragment的初始化操作
                 */
                intent.setClass(MainActivity.this, SecondActivity.class);
                intent.putExtra(CodeUtils.STATUS_SHOW, VISIBLE);//控制右边的按钮是否显示。
                startActivityForResult(intent, REQUEST_SELF);
                break;
            case R.id.btnWeixin:
                try {
                    //利用Intent打开微信
                    Uri uri = Uri.parse("weixin://dl/scan");
                    intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                } catch (Exception e) {
                    //若无法正常跳转，在此进行错误处理
                    Toast.makeText(MainActivity.this, "无法跳转到微信，请检查您是否安装了微信！", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.btnZhifubao:
                try {
                    //利用Intent打开支付宝
                    //支付宝跳过开启动画打开扫码和付款码的url scheme分别是alipayqr://platformapi/startapp?saId=10000007和
                    //alipayqr://platformapi/startapp?saId=20000056
                    Uri uri = Uri.parse("alipayqr://platformapi/startapp?saId=10000007");
                    intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                } catch (Exception e) {
                    //若无法正常跳转，在此进行错误处理
                    Toast.makeText(MainActivity.this, "无法跳转到支付宝，请检查您是否安装了支付宝！", Toast.LENGTH_SHORT).show();
                }

                break;
        }
    }
}
