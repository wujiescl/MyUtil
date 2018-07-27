package com.wujie.mylistview.TextViewChangeColor;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;

import com.wujie.mylistview.R;

public class TextviewActivity extends AppCompatActivity {
    private TextView tv_textview;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text);

        tv_textview=findViewById(R.id.tv_textview);
        //底部提示语  快速咨询为超链
        SpannableString str = new SpannableString("我同意自觉遵守《中国移动协议》，《神州协议》的全部内容");
        //设置属性
        str.setSpan(new MyCheckTextView(this,0), 7, 15, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        str.setSpan(new MyCheckTextView(this,1), 16 ,22, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        tv_textview.setText(str);
        tv_textview.setMovementMethod(LinkMovementMethod.getInstance());//不设置 没有点击事件
        tv_textview.setHighlightColor(Color.TRANSPARENT); //设置点击后的颜色为透明
    }
}
