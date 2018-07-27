package com.wujie.mylistview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class FirstListviewAdapter extends BaseAdapter {
    private List<String> list=new ArrayList<>();
    private Context mContext;
    private LayoutInflater inflater;

    FirstListviewAdapter(Context context, List<String> list){
        this.mContext=context;
        this.list=list;
        inflater = LayoutInflater.from(context);
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
        ViewHolderOne   viewHolderOne=null;
        if (view == null) {
             viewHolderOne = new ViewHolderOne();
            view = inflater.inflate(R.layout.item_first, null);
            viewHolderOne.tv11=view.findViewById(R.id.tv_first);
            view.setTag(viewHolderOne);
            viewHolderOne.tv11.setText(list.get(position));

        } else {
            viewHolderOne = (ViewHolderOne) view.getTag();
        }
        return  view;
    }

    class ViewHolderOne {
        public TextView tv11;
    }
}
