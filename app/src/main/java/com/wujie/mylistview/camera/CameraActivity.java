package com.wujie.mylistview.camera;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.FileProvider;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.wujie.mylistview.Base.BaseActivity2;
import com.wujie.mylistview.Base.onPermissionCallbackListener;
import com.wujie.mylistview.MainActivity;
import com.wujie.mylistview.R;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class CameraActivity extends BaseActivity2 {
    private File file;
    private int REQUEST_CAMERA=1;
    private String photoPath;
    private Button btn;
    private ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);

        btn=findViewById(R.id.btn_camera);
        imageView=findViewById(R.id.image);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N){
                    applyWritePermission();
                }else{
                    jsPath();
                }
            }
        });
    }



    /**
     * 使用相机
     */
    private void useCamera() {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        file = new File(Environment.getExternalStorageDirectory().getAbsolutePath()
                + "/test/" + System.currentTimeMillis() + ".jpg");
        file.getParentFile().mkdirs();

        //改变Uri  com.xykj.customview.fileprovider注意和xml中的一致
        Uri uri = FileProvider.getUriForFile(this, "com.wujie.mylistview.fileprovider", file);
        //添加权限
        intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);

        intent.putExtra(MediaStore.EXTRA_OUTPUT, uri);
        startActivityForResult(intent, REQUEST_CAMERA);
    }
    public void applyWritePermission() {

        String[] permissions = {Manifest.permission.WRITE_EXTERNAL_STORAGE,Manifest.permission.CAMERA};

        if (Build.VERSION.SDK_INT >= 23) {
            int check = ContextCompat.checkSelfPermission(this, permissions[1]);
            // 权限是否已经 授权 GRANTED---授权  DINIED---拒绝
            if (check == PackageManager.PERMISSION_GRANTED) {
                //调用相机
                useCamera();
            } else {
                requestPermissions(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE,Manifest.permission.CAMERA}, 1);
            }
        } else {
            useCamera();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 1 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            useCamera();
        } else {
            // 没有获取 到权限，从新请求，或者关闭app
            Toast.makeText(this, "需要存储权限", Toast.LENGTH_SHORT).show();
        }
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == RESULT_OK) {
//            Log.e("TAG", "---------" + FileProvider.getUriForFile(this, "com.xykj.customview.fileprovider", file));
            //在手机相册中显示刚拍摄的图片
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                Intent mediaScanIntent = new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);
                Uri contentUri = Uri.fromFile(file);
                String path = contentUri.getPath();
                Log.e("TAGSSSSSSSSS", contentUri.toString());
                //文件的路径
                String absolutePath = file.getAbsolutePath();
                //文件的名字
                String parent = file.getName();
                Log.e("TAGQQQQQQQQQ", parent + "===" + absolutePath);
                mediaScanIntent.setData(contentUri);
                sendBroadcast(mediaScanIntent);
                //设置图片
                imageView.setImageBitmap(BitmapFactory.decodeFile(file.getAbsolutePath()));
            }else{
                File photoFile = new File(photoPath);
                if (photoFile.exists()) {
                    try {
                        //将拍摄的照片进行压缩
                        Bitmap bm =  PhotoUtils.getimage(photoFile.getAbsolutePath());
                        String saveFileUrl = PhotoUtils.saveFile(bm);
                        imageView.setImageBitmap(bm);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    Toast.makeText(CameraActivity.this, "通过", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(CameraActivity.this, "图片文件不存在", Toast.LENGTH_LONG).show();
                }
            }
        }
    }

    /**
     * 拍照的，照片路径
     */
    public void jsPath() {
        //获取SD卡安装状态
        String state = Environment.getExternalStorageState();
        if (state.equals(Environment.MEDIA_MOUNTED)) {

            //设置图片保存路径
            photoPath = Environment.getExternalStorageDirectory().getPath() +"/ascl" + "/" + System.currentTimeMillis() + ".png";
            PhotoUtils.firstfilename=photoPath;
            File imageDir = new File(photoPath);
            if (!imageDir.exists()) {
                try {
                    //根据一个 文件地址生成一个新的文件用来存照片
                    imageDir.createNewFile();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            takePhotoByMethod1();
        } else {
            Toast.makeText(CameraActivity.this, "SD卡未插入", Toast.LENGTH_SHORT).show();
        }
    }
    private void takePhotoByMethod1() {
        //实例化intent,指向摄像头
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        //根据路径实例化图片文件
        File photoFile = new File(photoPath);
        //设置拍照后图片保存到文件中
        intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(photoFile));
        //启动拍照activity并获取返回数据
        startActivityForResult(intent, REQUEST_CAMERA);
    }

}
