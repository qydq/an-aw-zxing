package com.an.zxing.view.activity;

/**********************************************************
 * @文件名称：CaptureActivity
 * @文件作者：staryumou@163.com
 * @创建时间：2016/9/2
 * @文件描述：默认的二维码扫描Activity，可以实现连续扫描。
 * @修改历史：2016/9/17
 **********************************************************/

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;

import com.an.an_zxing.R;
import com.an.base.view.SuperActivity;
import com.an.zxing.utils.CodeUtils;
import com.an.zxing.view.fragment.CaptureFragment;

import static android.view.View.INVISIBLE;


/**
 * Initial the camera
 * 作者：qydq/shiluohua,
 * email:qyddai@gmail.com
 * 如使用标明出处。
 * 默认的二维码扫描Activity
 */
public class CaptureActivity extends SuperActivity {

    @Override
    public void initView() {
        setContentView(R.layout.an_activity_zxing_capture);
        CaptureFragment captureFragment = new CaptureFragment();
        captureFragment.setAnalyzeCallback(analyzeCallback);
        captureFragment.onSetvisible(getIntent().getIntExtra(CodeUtils.STATUS_SHOW, INVISIBLE));
        getFragmentManager().beginTransaction().replace(R.id.fl_zxing_container, captureFragment).commit();
//        getSupportFragmentManager().beginTransaction().replace(R.id.fl_zxing_container, captureFragment).commit();
    }

    /**
     * 二维码解析回调函数
     */
    CodeUtils.AnalyzeCallback analyzeCallback = new CodeUtils.AnalyzeCallback() {
        @Override
        public void onAnalyzeSuccess(Bitmap mBitmap, String result) {
            Intent resultIntent = new Intent();
            Bundle bundle = new Bundle();
            bundle.putInt(CodeUtils.RESULT_TYPE, CodeUtils.RESULT_SUCCESS);
            bundle.putString(CodeUtils.RESULT_STRING, result);
            bundle.putParcelable(CodeUtils.RESULT_BITMAP, mBitmap);
            resultIntent.putExtras(bundle);
            setResult(RESULT_OK, resultIntent);
            finish();
        }

        @Override
        public void onAnalyzeFailed() {
            Intent resultIntent = new Intent();
            Bundle bundle = new Bundle();
            bundle.putInt(CodeUtils.RESULT_TYPE, CodeUtils.RESULT_FAILED);
            bundle.putString(CodeUtils.RESULT_STRING, "");
            resultIntent.putExtras(bundle);
            setResult(RESULT_OK, resultIntent);
            finish();
        }
    };
}