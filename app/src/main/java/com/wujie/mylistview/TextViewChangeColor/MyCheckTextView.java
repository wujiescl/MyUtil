package com.wujie.mylistview.TextViewChangeColor;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.Toast;

public class MyCheckTextView extends ClickableSpan {
    private Context context;
    private int position;
    public MyCheckTextView(Context context,int position) {
        this.context = context;
        this.position=position;
    }

    @Override
    public void updateDrawState(TextPaint ds) {
        super.updateDrawState(ds);
        //设置文本的颜色
        ds.setColor(Color.parseColor("#1A7DC2"));
        //超链接形式的下划线，false 表示不显示下划线，true表示显示下划线,其实默认也是true，如果要下划线的话可以不设置
        ds.setUnderlineText(false);
    }

    //点击事件，自由操作
    @Override
    public void onClick(View widget) {
        if (position==0){
            Toast.makeText(context,"点了协议1",Toast.LENGTH_LONG).show();
        }else {
            Toast.makeText(context,"点了协议2",Toast.LENGTH_LONG).show();
        }

    }
}