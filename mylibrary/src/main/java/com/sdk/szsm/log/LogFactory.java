package com.sdk.szsm.log;

import android.util.Log;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;

import szxx.sdk.business.api.SDKBusinessApi;
import szxx.sdk.contact.SDKConfig;
import szxx.sdk.net.HttpManager;
import szxx.sdk.net.NetResponseAttr;
import szxx.sdk.util.DeviceHelper;
import szxx.sdk.util.dataanalysis.GsonUtil;


/***
 * @Title:LogFactory.java
 * @Description:日志打印控制文件
 * @author:wangkang
 * @date:2015年11月2日上午10:54:29
 */
public class LogFactory {
    private static final String TAG = LogFactory.class.getSimpleName();
    //是否需打印日志
    public static boolean debug = true;
    private static boolean printInsideLog = true;
    private static boolean isOpenUploadLog = false;

    public static void v(String TAG, String msg) {
        if (debug) {
            pritln(5, TAG, msg);
        }
    }

    public static void e(String TAG, String msg) {
        if (debug) {
            pritln(1, TAG, msg);
        }
    }

    public static void e(String TAG, String msg, Throwable tb) {
        if (debug) {
            Log.e(TAG, msg, tb);
        }
    }

    public static void d(String TAG, String msg) {
        if (debug) {
            pritln(2, TAG, msg);
        }
    }

    public static void d(String TAG, String msg, Throwable tr) {
        if (debug) {
            Log.d(TAG, msg, tr);
        }
    }

    public static void w(String TAG, String msg) {
        if (debug) {
            pritln(3, TAG, msg);
        }
    }

    public static void i(String TAG, String msg) {
        if (debug) {
            pritln(4, TAG, msg);
        }
    }

//    private static void pritln(int key, String TAG, String msg){
//        switch (key) {
//            case 1:
//                Log.e(TAG, msg);
//                break;
//            case 2:
//                Log.d(TAG, msg);
//                break;
//            case 3:
//                Log.w(TAG, msg);
//                break;
//            case 4:
//                Log.i(TAG, msg);
//                break;
//            case 5:
//                Log.v(TAG, msg);
//                break;
//        }
//    }

    private static void pritln(int key, String TAG, String msg) {
        if (!TAG.equals(SDKBusinessApi.class.getSimpleName()) && !printInsideLog){
            return;
        }
        int maxLogSize = 5000;
        for (int i = 0; i <= msg.length() / maxLogSize; i++) {
            int start = i * maxLogSize;
            int end = (i + 1) * maxLogSize;
            end = end > msg.length() ? msg.length() : end;
            switch (key) {
                case 1:
                    Log.e(TAG, msg.substring(start, end));
                    break;
                case 2:
                    Log.d(TAG, msg.substring(start, end));
                    break;
                case 3:
                    Log.w(TAG, msg.substring(start, end));
                    break;
                case 4:
                    Log.i(TAG, msg.substring(start, end));
                    break;
                case 5:
                    Log.v(TAG, msg.substring(start, end));
                    break;
            }
        }
    }

    /***
     * 错误日志搜集上传
     * @param ex 错误信息
     */
    public static void record(Throwable ex) {

        final LogFormat logFormat = new LogFormat(DeviceHelper.getMODEL(), DeviceHelper.getSysVersion(), DeviceHelper
                .getSDKVersion()
                , SDKConfig.version, String.valueOf(System.currentTimeMillis()), getErrorInfo(ex));
        final String logData = logFormat.getReq(logFormat);
        if (printInsideLog){
            d(TAG, logData);
        }

        if (!isOpenUploadLog) {
            return;
        }
        NetResponseAttr netResponseAttr = HttpManager.newInstance().upLoadLog(SDKConfig.uploadLogUrl, logData);
        d(TAG, GsonUtil.instance().object2Json(netResponseAttr));
    }


    /***
     * 捕捉失败信息体
     * @param e
     * @return
     */
    public static String getErrorInfo(Throwable e) {
        String errorInfo = "";

        Writer writer = new StringWriter();
        PrintWriter printWriter = new PrintWriter(writer);
        e.printStackTrace(printWriter);
        Throwable cause = e.getCause();
        while (cause != null) {
            cause.printStackTrace(printWriter);
            cause = cause.getCause();
        }
        printWriter.close();
        errorInfo = writer.toString();

        return errorInfo;
    }

}
