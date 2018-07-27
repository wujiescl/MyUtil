package com.wujie.mylistview.pop;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.wujie.mylistview.R;

import java.util.ArrayList;
import java.util.List;

public class PopActivity extends Activity implements SheetItem.OnSheetItemClickListener {
    private Button button;
    private ActionSheet actionSheet;
    ArrayList<SheetItem> list=new ArrayList<>();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pop);
        button=findViewById(R.id.btn);



        for (int i = 0; i < 2; i++) {
            SheetItem action=new SheetItem(this);
            action.setLogo("121");
            action.setName("中国建设银行"+i);
            list.add(action);
        }

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                actionSheet=new ActionSheet(PopActivity.this)
                        .builder()
                        .setCancelable(false)
                        .setCancelBtnVisible(true)
                        .setTitle("支付方式")
                        .setCanceledOnTouchOutside(true)
                        .addSheetItem(list, PopActivity.this);

                actionSheet.show();
            }
        });
    }

    @Override
    public void onSheetItemClick(int which) {
      switch (which){
          case 1:
          Toast.makeText(PopActivity.this,""+which,Toast.LENGTH_LONG).show();
          break;
      }
    }
}
