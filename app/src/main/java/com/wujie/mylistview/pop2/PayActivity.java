package com.wujie.mylistview.pop2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.wujie.mylistview.R;

import java.util.ArrayList;
import java.util.List;

public class PayActivity extends AppCompatActivity implements View.OnClickListener,ChoosePayBankPopupWindow.OnItemClickListener{


    private List<PayType> list_bigdata;
    private RelativeLayout root;
    private TextView name,cardnum,detal;
    ChoosePayBankPopupWindow navfastbigpopuWindow;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay2);

        root=(RelativeLayout)findViewById(R.id.rr_choose);
        name= (TextView) findViewById(R.id.tv_bank_name);
        cardnum= (TextView) findViewById(R.id.tv_bank_card);
        detal= (TextView) findViewById(R.id.tv_bank_detail);

        root.setOnClickListener(this);
        list_bigdata=new ArrayList<PayType>();

        setData();


    }


    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.rr_choose:
                navfastbigpopuWindow   = new ChoosePayBankPopupWindow(this, list_bigdata,this);
                navfastbigpopuWindow.show(root, this);
                break;

        }

    }



    @Override
    public void onItemClick(int which) {
        Toast.makeText(PayActivity.this,"选中了"+list_bigdata.get(which).getBankName(), Toast.LENGTH_LONG).show();
        String bankName = list_bigdata.get(which).getBankName();
        String bankNum = list_bigdata.get(which).getBankNum();
        String bankDetail = list_bigdata.get(which).getBankDetail();
        name.setText(bankName);
        cardnum.setText(bankNum);
        detal.setText(bankDetail);
        Contact.ADD_NEW_CARD=false;
        Contact.CHOOSE_MONET=false;
        for (int i = 0; i <list_bigdata.size() ; i++) {
            list_bigdata.get(i).setChoose(false);
        }
        list_bigdata.get(which).setChoose(true);

    }

    @Override
    public void onAddCardClick() {
        for (int i = 0; i <list_bigdata.size() ; i++) {
            list_bigdata.get(i).setChoose(false);
        }
        Contact.ADD_NEW_CARD=true;
        Contact.CHOOSE_MONET=false;
        Toast.makeText(PayActivity.this,"选中了添加银行卡", Toast.LENGTH_LONG).show();

    }

    @Override
    public void onMoneyClick() {
        Toast.makeText(PayActivity.this,"选中了余额支付", Toast.LENGTH_LONG).show();
        for (int i = 0; i <list_bigdata.size() ; i++) {
            list_bigdata.get(i).setChoose(false);
        }
        Contact.CHOOSE_MONET=true;
        Contact.ADD_NEW_CARD=false;
    }

    private void setData() {
        list_bigdata=new ArrayList<>();
        PayType bankcard1=new PayType();
        PayType bankcard2=new PayType();
        PayType bankcard3=new PayType();
        PayType bankcard4=new PayType();
        PayType bankcard5=new PayType();
        PayType bankcard6=new PayType();
        PayType bankcard7=new PayType();
        PayType bankcard8=new PayType();
        PayType bankcard9=new PayType();
        bankcard1.setBankName("农业银行");
        bankcard1.setBankNum("8281");
        bankcard1.setBankDetail("单笔充值上线为20万元，很棒的");
        bankcard2.setBankName("工商银行");
        bankcard2.setBankNum("8282");
        bankcard2.setBankDetail("单笔充值上线为20万元，很棒的");
        bankcard3.setBankName("中国银行");
        bankcard3.setBankNum("8283");
        bankcard3.setBankDetail("单笔充值上线为20万元，很棒的");
        bankcard4.setBankName("建设银行");
        bankcard4.setBankNum("8284");
        bankcard4.setBankDetail("单笔充值上线为20万元，很棒的");
        bankcard5.setBankName("华夏银行");
        bankcard5.setBankNum("8285");
        bankcard5.setBankDetail("单笔充值上线为20万元，很棒的");
        bankcard6.setBankName("上海银行");
        bankcard6.setBankNum("8286");
        bankcard6.setBankDetail("单笔充值上线为20万元，很棒的");
        bankcard7.setBankName("招商银行");
        bankcard7.setBankNum("8287");
        bankcard7.setBankDetail("单笔充值上线为20万元，很棒的");
        bankcard8.setBankName("江苏银行");
        bankcard8.setBankNum("8288");
        bankcard8.setBankDetail("单笔充值上线为20万元，很棒的");
        bankcard9.setBankName("交通银行");
        bankcard9.setBankNum("8289");
        bankcard9.setBankDetail("单笔充值上线为20万元，很棒的");


        list_bigdata.add(bankcard1);
        list_bigdata.add(bankcard2);
        list_bigdata.add(bankcard3);
        list_bigdata.add(bankcard4);
        list_bigdata.add(bankcard5);
        list_bigdata.add(bankcard6);
        list_bigdata.add(bankcard7);
        list_bigdata.add(bankcard8);
        list_bigdata.add(bankcard9);


    }

}
