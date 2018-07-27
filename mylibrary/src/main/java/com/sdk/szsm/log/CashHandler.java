package com.sdk.szsm.log;

import android.content.Context;

import szxx.sdk.base.SDKContext;

/**
 * 描述:${异常信息捕获}
 * 创建者:victor
 * 邮箱: victorwangk@qq.com
 * SDK
 * 日期:2017/8/17
 */

public class CashHandler extends Thread implements Thread.UncaughtExceptionHandler {

    private Context mContext;
    private UncaughtExceptionHandler mDefaultHandler;
    private Throwable currentThrowable;
    private CashHandler(){}
    private static CashHandler mCashHandler = null;
    public static CashHandler instance(){
        if (mCashHandler == null){
            mCashHandler = new CashHandler();
        }
        return mCashHandler;
    }

    public void init(Context context){
        this.mContext = context;
        this.mDefaultHandler = Thread.getDefaultUncaughtExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler(this);
    }

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        e.printStackTrace();
        if (!handleException(e) && mDefaultHandler != null){
            mDefaultHandler.uncaughtException(t,e);
        } else {
            if (SDKContext.mCashHandler != null){
                SDKContext.mCashHandler.uncaughtException(t,e);
            }
        }
    }

    @Override
    public void run() {
        super.run();
        szxx.sdk.log.LogFactory.record(currentThrowable);
    }

    private boolean handleException(Throwable ex){
        if (ex == null){
            return false;
        }
        currentThrowable = ex;
        this.start();
        return true;
    }

}
