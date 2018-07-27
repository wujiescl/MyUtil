package com.wujie.mylistview.payBord;

import android.app.Activity;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.wujie.mylistview.R;

public class PayKeyPwdActivity extends Activity implements SelectPopupWindow.OnPopWindowClickListener{
    Button btn;
    private SelectPopupWindow menuWindow;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paykey);
        btn=findViewById(R.id.btn_key);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                menuWindow = new SelectPopupWindow(PayKeyPwdActivity.this, PayKeyPwdActivity.this);
                Rect rect = new Rect();
                getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
                int winHeight = getWindow().getDecorView().getHeight();
                menuWindow.showAtLocation(getWindow().getDecorView(), Gravity.BOTTOM, 0, winHeight - rect.bottom);
            }
        });
    }

    @Override
    public void onPopWindowClickListener(String psw, boolean complete) {
        if(complete)
            Toast.makeText(this, "您输入的密码是"+psw, Toast.LENGTH_SHORT).show();
    }

}
