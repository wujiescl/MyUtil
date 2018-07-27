package com.wujie.mylistview.Base;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.wujie.mylistview.R;

import java.util.ArrayList;
import java.util.List;

public class BaseActivity1 extends AppCompatActivity{
    public Context mContext;
    private onPermissionCallbackListener mListener;
    private AlertDialog dialog;

    private RelativeLayout mRootLayout;
    private TextView mTitleTv;
    private TextView mTitleRight;

    private TextView mLeftTitle;
    private TextView mLeftSubTitle;
    private LinearLayout llLeftTitle;
    /**
     * 网络类型
     */
    private int netMobile;

    @Override
    protected void onCreate(Bundle arg0) {
        // TODO Auto-generated method stub
        super.onCreate(arg0);
        super.setContentView(R.layout.base_activity);
        findView();
        mContext=this;
    }



    /**
     * 申请权限
     *
     * @param permissions
     */
    public void onRequestPermission(String[] permissions, onPermissionCallbackListener listener) {
        mListener = listener;
        List<String> permissionList = new ArrayList<>();
        //1、 哪些权限需要申请
        for (String permission : permissions) {
            if (ActivityCompat.checkSelfPermission(this, permission) != PackageManager.PERMISSION_GRANTED) {
                //权限没有申请 添加到要申请的权限列表中
                permissionList.add(permission);
            }
        }
        if (!permissionList.isEmpty()) {
            ActivityCompat.requestPermissions(this, permissionList.toArray(new String[permissionList.size()]), 1);
        } else {
            //所有权限都同意了
            mListener.onGranted();
        }
    }

    /**
     * 权限申请结果
     *
     * @param requestCode
     * @param permissions
     * @param grantResults
     */
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 1) {
            List<String> deniedPermissions = new ArrayList<>();
            if (grantResults.length > 0) {
                for (int i = 0; i < grantResults.length; i++) {
                    int grantResult = grantResults[i];
                    if (grantResult != PackageManager.PERMISSION_GRANTED) {
                        deniedPermissions.add(permissions[i]);
                    }
                }
            }
            if (!deniedPermissions.isEmpty()) {
                mListener.onDenied(deniedPermissions);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    // 判断用户是否 点击了不再提醒。(检测该权限是否还可以申请)
                    boolean b = shouldShowRequestPermissionRationale(permissions[0]);
                    if (!b) {
                        // 用户还是想用我的 APP 的
                        // 提示用户去应用设置界面手动开启权限
                        showTipsDialog();
                    }
                }
            }else {
                mListener.onGranted();
            }
        } else {
            //所有的权限都被接受了
            mListener.onGranted();
        }
    }

    private void showTipsDialog() {
        // 跳转到应用设置界面
        dialog = new AlertDialog.Builder(this)
                .setTitle("权限不可用")
                .setMessage("请在-应用设置-权限-中，允许使用权限")
                .setPositiveButton("立即开启", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Log.e("BaseActivity", "要开启进行权限设置");
                        // 跳转到应用设置界面
                        Intent intent = new Intent();
                        intent.setAction(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
                        Uri uri = Uri.fromParts("package", getPackageName(), null);
                        intent.setData(uri);
                        startActivity(intent);
                    }
                })
                .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                }).setCancelable(false).show();
    }

    /**
     * ===========================标题栏部分=======================================
     */
    private void findView(){
        mRootLayout = (RelativeLayout) findViewById(R.id.base_root_layout);
        mTitleTv = (TextView) findViewById(R.id.title_text);
        mTitleRight = (TextView) findViewById(R.id.btn_title_right);
        mTitleRight.setOnClickListener(new OnMultClickListener(){
            @Override
            public void onMultClick(View v) {
                super.onMultClick(v);
                onClickRightKey();
            }
        });
        mTitleRight.setVisibility(View.GONE);
        findViewById(R.id.rl_title_back).setOnClickListener(new OnMultClickListener(){
            @Override
            public void onMultClick(View v) {
                super.onMultClick(v);
                onBackPressed();
            }
        });

        findViewById(R.id.title_layout).setVisibility(View.GONE);
        mLeftTitle = (TextView) findViewById(R.id.tv_left_title);
        llLeftTitle = (LinearLayout) findViewById(R.id.ll_left_title);
    }

    /**
     * 调用此方法标题栏才展示
     * @param titleId
     */
    protected void initTitleBar(int titleId){
        initTitleBar(getString(titleId));
    }

    protected void initTitleBar(String title){
        initTitleBar(title, false, null, -1);
    }

    protected void initTitleBar(int titleId, boolean isRightShow, String righttext){
        initTitleBar(getString(titleId), isRightShow, righttext, -1);
    }

    protected  void setRightBtnVisible(int visible)
    {
        if(mTitleRight!=null)
            mTitleRight.setVisibility(visible);
    }

    protected void initTitleBar(String title, boolean isRightShow, String righttext, int rightimgId){
        //调用此方法标题栏展示
        findViewById(R.id.title_layout).setVisibility(View.VISIBLE);
        mTitleTv.setText(title);
        if (isRightShow) {
            mTitleRight.setVisibility(View.VISIBLE);
        }

        if (!TextUtils.isEmpty(righttext)) {
            mTitleRight.setText(righttext);
//                mTitleRight.setTextColor(ContextCompat.getColor( mContext, R.color.uni_button_white_titlebar_text_color));
        }

        if (rightimgId != -1) {
            mTitleRight.setBackgroundResource(rightimgId);
        }

    }

    protected ImageView getTitleRightImageViewVisible(){
        return (ImageView) findViewById(R.id.title_right_imageview);
    }

    protected ImageView setTitleRightImageViewVisible(){
        mTitleRight.setVisibility(View.GONE);
        ImageView imageView = (ImageView) findViewById(R.id.title_right_imageview);
        imageView.setVisibility(View.VISIBLE);
        return imageView;
    }

    protected void updateTitleText(int resId){
        updateTitleText(getString(resId));
    }

    protected void updateTitleText(String text){
        if (TextUtils.isEmpty(text)) {
            mTitleTv.setText("");
        } else {
            mTitleTv.setText(text);
        }

    }

    protected void setTitleRightVisibility(int visibility){
        mTitleRight.setVisibility(visibility);
    }

    protected TextView getTitleRight () {
        return mTitleRight;
    }


    /**
     * 标题栏右边按钮响应
     */
    protected void onClickRightKey(){

    }

    /**
     重点是重写setContentView，让继承者可以继续设置setContentView
     * 重写setContentView
     * @param resId
     */
    @Override
    public void setContentView(int resId) {
        View view = getLayoutInflater().inflate(resId, null);
        this.setContentView(view);
    }
    @Override
    public void setContentView(View view) {
        RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.MATCH_PARENT);
        lp.addRule(RelativeLayout.BELOW, R.id.title_layout);
        if (null != mRootLayout) {
            mRootLayout.addView(view, lp);
        }
    }
}
