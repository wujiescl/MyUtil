package com.wujie.mylistview;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.wujie.mylistview.Bankcard.BankActivity;
import com.wujie.mylistview.Base.PerActivity;
import com.wujie.mylistview.Dialog.LodingActivity;
import com.wujie.mylistview.TextViewChangeColor.TextviewActivity;
import com.wujie.mylistview.button.InputActivity;
import com.wujie.mylistview.camera.CameraActivity;
import com.wujie.mylistview.payBord.PayKeyPwdActivity;
import com.wujie.mylistview.pop.PopActivity;
import com.wujie.mylistview.pop2.PayActivity;
import com.wujie.mylistview.sendMSG.SendMsgActivity;
import com.wujie.mylistview.tab.MainTabActivity;
import com.wujie.mylistview.toolbar.ToolbarActivity;

import java.util.ArrayList;
import java.util.List;

public class FirstActivity extends Activity implements View.OnClickListener{
    private Button one,two,three,four,five,six,seven,eight,nine,ten;
    ListView listView;
    FirstListviewAdapter firstListviewAdapter;
    private List<String> list=new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first);

        listView=findViewById(R.id.listview);

        getdata();

        firstListviewAdapter=new FirstListviewAdapter(this,list);
        listView.setAdapter(firstListviewAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
               switch (position){
                   case 0:
                       Intent intent=new Intent(FirstActivity.this,MainActivity.class);
                       startActivity(intent);
                       break;
                   case 1:
                       Intent intent1=new Intent(FirstActivity.this,BankActivity.class);
                       startActivity(intent1);
                       break;
                   case 2:
                       Intent intent2=new Intent(FirstActivity.this,PopActivity.class);
                       startActivity(intent2);
                       break;
                   case 3:
                       Intent intent3=new Intent(FirstActivity.this,PayActivity.class);
                       startActivity(intent3);
                       break;
                   case 4:
                       Intent intent4=new Intent(FirstActivity.this,MainTabActivity.class);
                       startActivity(intent4);
                       break;

                   case 5:
                       Intent intent5=new Intent(FirstActivity.this,ToolbarActivity.class);
                       startActivity(intent5);
                       break;

                   case 6:
                       Intent intent6=new Intent(FirstActivity.this,PerActivity.class);
                       startActivity(intent6);
                       break;

                   case 7:
                       Intent intent7=new Intent(FirstActivity.this,PayKeyPwdActivity.class);
                       startActivity(intent7);
                       break;

                   case 8:
                       Intent intent8=new Intent(FirstActivity.this,CameraActivity.class);
                       startActivity(intent8);
                       break;

                   case 9:
                       Intent intent9=new Intent(FirstActivity.this,InputActivity.class);
                       startActivity(intent9);
                       break;

                   case 10:
                       Intent intent10=new Intent(FirstActivity.this,TextviewActivity.class);
                       startActivity(intent10);
                       break;

                   case 11:
                       Intent intent11=new Intent(FirstActivity.this, com.wujie.mylistview.pop3.PopActivity.class);
                       startActivity(intent11);
                       break;
                   case 12:
                       Intent intent12=new Intent(FirstActivity.this,SendMsgActivity.class);
                       startActivity(intent12);
                       break;
                   case 13:
                       Intent intent13=new Intent(FirstActivity.this,LodingActivity.class);
                       startActivity(intent13);
                       break;
               }
            }
        });

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){

        }
    }

    public void getdata() {
        list.add("多种item列表");
        list.add("身份证脱敏");
        list.add("底部弹窗菜单");
        list.add("唤起支付插件");
        list.add("tab切换菜单");
        list.add("状态栏改变颜色");
        list.add("baseActivity");
        list.add("支付密码键盘");
        list.add("唤起系统相机（适配8.0）含压缩");
        list.add("变色按钮");
        list.add("协议TextView");
        list.add("弹出协议");
        list.add("调起发短信");
        list.add("数据加载对话框");
    }
}
