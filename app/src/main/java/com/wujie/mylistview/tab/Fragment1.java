package com.wujie.mylistview.tab;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.wujie.mylistview.R;


import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;

public class Fragment1 extends Fragment {
    private String TAG="wujie";
TextView textView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View inflate = inflater.inflate(R.layout.fragment1, container, false);

        textView=inflate.findViewById(R.id.tv);
        textView.setText("黑死了");
        getData();
        return inflate;
    }
    public  void getData(){

        String url = "http://wujiescl.free.ngrok.cc/GetH5/goods/getAllgoods";

        Map<String, String> params = new HashMap<>();
        params.put("phone", "13789543678");


    }
}