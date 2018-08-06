package com.wujie.mylistview.Dialog;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.wujie.mylistview.R;

public class LodingActivity extends AppCompatActivity {
private Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loding);

        btn=findViewById(R.id.btn_loading);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogUtils dialogUtils = new DialogUtils(LodingActivity.this);
                dialogUtils.showLoadingWithLabel("加载中...");
            }
        });
    }
}
