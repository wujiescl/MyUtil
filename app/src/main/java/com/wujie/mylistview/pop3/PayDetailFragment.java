package com.wujie.mylistview.pop3;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.wujie.mylistview.FirstListviewAdapter;
import com.wujie.mylistview.R;

import java.util.ArrayList;
import java.util.List;


/**
 * 底部弹窗Fragment
 */
public class PayDetailFragment extends DialogFragment implements View.OnClickListener{

    private Button btnPay;
    private CheckBox checkBox1,checkBox2,checkBox3;
    private TextView textView1,textView2,textView3;
    private boolean ischoose1=false,ischoose2=false,ischoose3=false;



    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // 使用不带Theme的构造器, 获得的dialog边框距离屏幕仍有几毫米的缝隙。
        Dialog dialog = new Dialog(getActivity(), R.style.BottomDialog);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE); // 设置Content前设定
        dialog.setContentView(R.layout.fragment_pay_detail);
        dialog.setCanceledOnTouchOutside(true); // 外部点击取消
        // 设置宽度为屏宽, 靠近屏幕底部。
        final Window window = dialog.getWindow();
        window.setWindowAnimations(R.style.AnimBottom);
        final WindowManager.LayoutParams lp = window.getAttributes();
        lp.gravity = Gravity.BOTTOM; // 紧贴底部
        lp.width = WindowManager.LayoutParams.MATCH_PARENT; // 宽度持平
        lp.height = getActivity().getWindowManager().getDefaultDisplay().getHeight() * 1/ 2;//弹框的高度
        window.setAttributes(lp);

        initView(dialog);
        return dialog;
    }

    private void initView(Dialog dialog) {
        btnPay=dialog.findViewById(R.id.btn_confirm_agree);
        checkBox1=dialog.findViewById(R.id.cb_choose1);
        checkBox2=dialog.findViewById(R.id.cb_choose2);
        checkBox3=dialog.findViewById(R.id.cb_choose3);
        textView1=dialog.findViewById(R.id.tv_agreement_content1);
        textView2=dialog.findViewById(R.id.tv_agreement_content2);
        textView3=dialog.findViewById(R.id.tv_agreement_content3);
        btnPay.setOnClickListener(this);
        textView1.setOnClickListener(this);
        textView2.setOnClickListener(this);
        textView3.setOnClickListener(this);
        btnPay.setEnabled(false);

        checkBox1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                ischoose1=b;
                canClick();
                if (b){
                    checkBox1.setBackgroundResource(R.drawable.icon_choose_checked);

                }else {
                    checkBox1.setBackgroundResource(R.drawable.icon_choose_normal);
                }
            }
        });
        checkBox2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                ischoose2=b;
                canClick();
                if (b){
                    checkBox2.setBackgroundResource(R.drawable.icon_choose_checked);

                }else {
                    checkBox2.setBackgroundResource(R.drawable.icon_choose_normal);
                }
            }
        });
        checkBox3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                ischoose3=b;
                canClick();
                if (b){
                    checkBox3.setBackgroundResource(R.drawable.icon_choose_checked);

                }else {
                    checkBox3.setBackgroundResource(R.drawable.icon_choose_normal);
                }
            }
        });



    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_confirm_agree:
                Toast.makeText(getContext(),"可以了",Toast.LENGTH_SHORT).show();
            break;
            case R.id.tv_agreement_content1:
                Toast.makeText(getContext(),"协议1",Toast.LENGTH_SHORT).show();
                break;
            case R.id.tv_agreement_content2:
                Toast.makeText(getContext(),"协议2",Toast.LENGTH_SHORT).show();
                break;
            case R.id.tv_agreement_content3:
                Toast.makeText(getContext(),"协议3",Toast.LENGTH_SHORT).show();
                break;
        }
    }

    private void canClick(){
        if (!ischoose1&&!ischoose2&&!ischoose3){
            btnPay.setEnabled(false);
        }else {
            btnPay.setEnabled(true);
        }
    }
}
