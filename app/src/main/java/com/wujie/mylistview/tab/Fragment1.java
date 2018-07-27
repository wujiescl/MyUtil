package com.wujie.mylistview.tab;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.wujie.mylistview.R;

public class Fragment1 extends Fragment {
TextView textView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View inflate = inflater.inflate(R.layout.fragment1, container, false);

        textView=inflate.findViewById(R.id.tv);
        textView.setText("黑死了");
        return inflate;
    }

}