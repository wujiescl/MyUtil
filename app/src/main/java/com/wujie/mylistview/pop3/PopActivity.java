package com.wujie.mylistview.pop3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.wujie.mylistview.R;

public class PopActivity extends AppCompatActivity {
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pop2);

        btn=findViewById(R.id.btn_pop);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PayDetailFragment payDetailFragment=new PayDetailFragment();
                payDetailFragment.show(getSupportFragmentManager(),"payDetailFragment");
            }
        });
    }
}
