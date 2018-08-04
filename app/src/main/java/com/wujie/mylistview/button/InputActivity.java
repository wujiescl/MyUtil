package com.wujie.mylistview.button;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

import com.wujie.mylistview.R;

public class InputActivity extends Activity {
    private EditText editText1,editText2;
    private Button button;
    private CheckBox checkBox;
    private boolean ischoose=false;//协议是否选择
    private boolean isnull=false;//输入框是否输入
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_input);

       editText1=findViewById(R.id.et_one);
       editText2=findViewById(R.id.et_two);
       button=findViewById(R.id.btn_queding);
        checkBox=findViewById(R.id.cb);
        button.setEnabled(false);
        //1.初始化
        WorksSizeCheckUtil.textChangeListener textChangeListener = new WorksSizeCheckUtil.textChangeListener(button);
        //2.把所有要监听的edittext都添加进去
        textChangeListener.addAllEditText(editText1,editText2);
        //3.接口回调 在这里拿到boolean变量 根据isHasContent的值决定button是否可点击
        WorksSizeCheckUtil.setChangeListener(new IEditTextChangeListener() {
            @Override
            public void textChange(boolean isHasContent) {
                    isnull=isHasContent;
                    canClick();
            }
        });


        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                ischoose=b;
                canClick();
            }
        });


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(InputActivity.this,"queding",Toast.LENGTH_LONG).show();
            }
        });
    }

    private void canClick(){
        if (ischoose&&isnull){
            button.setEnabled(true);
        }else {
            button.setEnabled(false);
        }
    }
}
