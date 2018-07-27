package com.wujie.mylistview.Base;

import android.view.View;

public class OnMultClickListener implements android.view.View.OnClickListener {

    long currtime;

    /**
     * 抛掉300ms内多余的回调接口，避免重复处理相同事务
     * 防止测试人员狂点更新按钮，导致弹出两个对话框
     */
    public void onClick(View v) {
        if (System.currentTimeMillis() - currtime > 1000) {
            currtime = System.currentTimeMillis();
            onMultClick(v);
        }
    }

    /**
     * @param v
     */
    public void onMultClick(View v) {
    }
}