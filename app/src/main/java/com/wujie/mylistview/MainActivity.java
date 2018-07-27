package com.wujie.mylistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
   private ListView listView;
   private ListViewAdapter listViewAdapter;
    private List<Bean.ResultBean> list=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        for (int i = 0; i < 20; i++) {
            Bean.ResultBean resultBean=new Bean.ResultBean();
            resultBean.setTitle("银行卡"+i);
            resultBean.setCardnum("62122619070000"+i);
            resultBean.setType(0);
            if (i==3||i==5||i==10){
                resultBean.setTitle("亲属卡"+i);
                resultBean.setType(1);
            }
            list.add(resultBean);
        }

        listView=findViewById(R.id.listview);
        listViewAdapter=new ListViewAdapter(MainActivity.this,list);
        listView.setAdapter(listViewAdapter);
    }
}
