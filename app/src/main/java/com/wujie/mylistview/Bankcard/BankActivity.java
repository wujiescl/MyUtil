package com.wujie.mylistview.Bankcard;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

import com.wujie.mylistview.R;

public class BankActivity extends Activity{
    private ContentWithSpaceEditText editText;
    Myet editText1;
    String banknum="6212261907000088042";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bank);
        editText = findViewById(R.id.tvbank);

        editText.setContentType(ContentWithSpaceEditText.TYPE_IDCARD);

        editText1=findViewById(R.id.card);

        String textWithoutSpace = editText1.getTextWithoutSpace();
        Log.d("wujie", "onCreate: "+textWithoutSpace);



    }


}
