package com.wujie.mylistview.sendMSG;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.wujie.mylistview.R;

public class SendMsgActivity extends AppCompatActivity {
private Button btn_sendmsg;
private EditText editTextphone,editTextcontext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_msg);

        btn_sendmsg=findViewById(R.id.bt_sendmsg);
        editTextcontext=findViewById(R.id.et_content);
        editTextphone=findViewById(R.id.et_phonenumber);

        btn_sendmsg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String phone=editTextphone.getText().toString().trim();
                String content=editTextcontext.getText().toString().trim();
                sendMsg(phone,content);

            }
        });
    }

    public void sendMsg(String phone,String content){
        Uri smsToUri = Uri.parse("smsto:");
        Intent sendIntent = new Intent(Intent.ACTION_VIEW, smsToUri);
        sendIntent.putExtra("address", phone); //电话号码，这行去掉的话，默认就没有电话
        sendIntent.putExtra("sms_body",content);
        sendIntent.setType("vnd.android-dir/mms-sms");
        startActivity(sendIntent);
    }
}
