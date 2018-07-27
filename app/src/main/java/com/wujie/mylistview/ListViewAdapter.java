package com.wujie.mylistview;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ListViewAdapter  extends BaseAdapter {
    private Context mContext;
    private List<Bean.ResultBean> list=new ArrayList<>();
    private LayoutInflater inflater;
    private final int TYPE_COUNT = 2;

    private final int TYPE_ONE = 0;

    private final int TYPE_TWO = 1;

    private int currentType;


    ListViewAdapter(Context context,List<Bean.ResultBean> list){
        this.mContext=context;
        this.list=list;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getItemViewType(int position) {
        Log.i("debug", "position=" + position);
        Bean.ResultBean result = list.get(position);
        Log.i("ddd", "result=" + result);
        int type = result.getType();
        switch (type) {
            case TYPE_ONE:
                return TYPE_ONE;

            case TYPE_TWO:
                return TYPE_TWO;

            default:
                return -1;
        }
    }

    @Override
    public int getViewTypeCount() {
        return TYPE_COUNT;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        Bean.ResultBean resultBean=list.get(position);
        currentType=getItemViewType(position);
        if (currentType==TYPE_ONE){
            ViewHolderOne viewHolderOne;
            if (view == null) {
                viewHolderOne = new ViewHolderOne();
                view = inflater.inflate(R.layout.item_type0, null);
                viewHolderOne.tv11=view.findViewById(R.id.tv11);
                viewHolderOne.tv12=view.findViewById(R.id.tv12);
                view.setTag(viewHolderOne);
                viewHolderOne.tv11.setText(resultBean.getTitle());
                viewHolderOne.tv12.setText(resultBean.getCardnum());
            } else {
                viewHolderOne = (ViewHolderOne) view.getTag();
            }
        }else if (currentType==TYPE_TWO){
            ViewHolderTwo viewHolderTwo;
            if (view == null) {
                viewHolderTwo = new ViewHolderTwo();
                view = inflater.inflate(R.layout.item_type1, null);
                viewHolderTwo.tv21=view.findViewById(R.id.tv21);
                view.setTag(viewHolderTwo);
            } else {
                viewHolderTwo = (ViewHolderTwo) view.getTag();
            }
            viewHolderTwo.tv21.setText(resultBean.getTitle());
        }

        return view;
    }


    class ViewHolderOne {
        public TextView tv11;
        public TextView tv12;
    }

    class ViewHolderTwo {
        public TextView tv21;
    }
}
