package com.wujie.mylistview.Base;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.wujie.mylistview.R;

import java.util.List;

/**
 * Created by Hoban on 2017/11/15.
 */
public class PerActivity extends BaseActivity {

    private TextView textView;
    Button quanxian;
    ListView listView;  //声明一个ListView对象
    boolean netConnect;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);

        initTitleBar("标题",true,"帮助",-1);

        textView= (TextView) findViewById(R.id.textView);
        quanxian=(Button)this.findViewById(R.id.quanxian);
        quanxian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (netConnect){
                    onRequestPermission(new String[]{Manifest.permission.CAMERA}, new onPermissionCallbackListener() {
                        @Override
                        public void onGranted() {
                            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                            startActivity(intent);
                        }

                        @Override
                        public void onDenied(List<String> deniedPermissions) {
                            Log.e("wujie", "onDenied: ");
                        }
                    });
                }else {
                    Toast.makeText(PerActivity.this,"网络连接不可用",Toast.LENGTH_LONG).show();
                }

            }
        });
        //启动时判断网络状态
        boolean netConnect = this.isNetConnect();
        if (netConnect){
            textView.setVisibility(View.GONE);
        }else {
            textView.setVisibility(View.VISIBLE);

        }
    }

    @Override
    protected void onClickRightKey() {
        super.onClickRightKey();
        Toast.makeText(this,"更多",Toast.LENGTH_LONG).show();
    }

    @Override
    public void onNetChange(int netMobile) {
        super.onNetChange(netMobile);
        //网络状态变化时的操作
        if (netMobile==NetUtil.NETWORK_NONE){
            textView.setVisibility(View.VISIBLE);
            netConnect=false;
        }else {
            textView.setVisibility(View.GONE);
            netConnect=true;
        }
    }

}
