package com.wujie.mylistview.SixPwdView;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.wujie.mylistview.R;

public class SixPwdViewActivity extends Activity implements PasswordInputView.OninputPwdOverListener{
     PasswordInputView passwordInputView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_six_pwd_view);

       passwordInputView = (PasswordInputView) findViewById(R.id.passwordInputView);
       passwordInputView.setOnPswChanged(this);
        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });
    }

    @Override
    public void inputOver() {
        Toast.makeText(SixPwdViewActivity.this, passwordInputView.getText(), Toast.LENGTH_SHORT).show();

    }
}
