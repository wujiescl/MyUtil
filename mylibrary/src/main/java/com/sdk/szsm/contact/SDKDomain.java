package com.sdk.szsm.contact;

/**
 * 描述:${Description}
 * 创建者:victor
 * 邮箱: victorwangk@qq.com
 * SDK
 * 日期:2017/8/17
 */

public interface SDKDomain {

    String AESENCRYPT_STR1 = "Crypto";
    String AESENCRYPT_STR2 = "HARMONY (SHA1 digest; SecureRandom; SHA1withDSA signature)";
    String AESENCRYPT_STR3 = "SecureRandom.SHA1PRNG";
    String AESENCRYPT_STR4 = "org.apache.harmony.security.provider.crypto.SHA1PRNG_SecureRandomImpl";
    String AESENCRYPT_STR5 = "SecureRandom.SHA1PRNG ImplementedIn";
    String AESENCRYPT_STR6 = "Software";

    String BASE64UTILS_STR1 = "iso8859-1";
    String BASE64UTILS_STR2 = "US-ASCII";

    String RSAENCRYPT_STR1 = "无此算法";
    String RSAENCRYPT_STR2 = "公钥非法";
    String RSAENCRYPT_STR4 = "私钥非法";
    String RSAENCRYPT_STR3 = "公钥数据为空";
    String RSAENCRYPT_STR5 = "私钥数据为空";
    String RSAENCRYPT_STR6 = "公钥数据流读取错误";
    String RSAENCRYPT_STR7 = "公钥输入流为空";
    String RSAENCRYPT_STR8 = "私钥数据读取错误";
    String RSAENCRYPT_STR9 = "私钥输入流为空";

    String OUTPACKETAPPROVE_STR1 = "请输入有效APPID";
    String OUTPACKETAPPROVE_STR2 = "请输入有效seqNO";
    String OUTPACKETAPPROVE_STR3 = "请输入有效random";
    String OUTPACKETAPPROVE_STR4 = "请输入有效secretKey";
    String OUTPACKETAPPROVE_STR5 = "加签方式有误";
    String OUTPACKETAPPROVE_STR6 = "加密方式有误";
    String OUTPACKETAPPROVE_STR7 = "token无效,请重新初始化";

    String REQUESTCENTER_STR1 = "secretKey";

    String GSONUTIL_STR1 = "非json数据格式";

    String HTTPMANAGER_STR1 = "utf-8";
    String HTTPMANAGER_REQUESTURL = "_RequestUrl ";
    String HTTPMANAGER_RESPONSECODE = "_ResponseCode ";
    String HTTPMANAGER_RESPONSEBODY = "_ResponseBody ";
    String HTTPMANAGER_REQUESTTIME = "_RequestTime 耗时:";
    String HTTPMANAGER_REQUESTPARAMS = "_RequestParams ";
    String HTTPMANAGER_STR2 = "毫秒";
    String HTTPMANAGER_STR3 = "Content-type";
    String HTTPMANAGER_STR4 = "application/x-www-form-urlencoded";
    String HTTPMANAGER_STR5 = "Cookie";
    String HTTPMANAGER_STR6 = "TLS";
    String HTTPMANAGER_STR7 = "set-cookie";
    String HTTPMANAGER_STR8 = "Redirection";
    String HTTPMANAGER_STR9 = "Client Error";
    String HTTPMANAGER_STR10 = "Server Error";

    String TLDOMAIN_STR1 = "url";

    String NJDOMAIN_SDKTYPE = "sdkType";
    String NJDOMAIN_SDKVERSION = "sdkVersion";
    String NJDOMAIN_SDKDESC = "sdkDesc";
    String NJDOMAIN_SDKIP = "sdkIP";
    String NJDOMAIN_SDKIMEI = "sdkImei";
    String NJDOMAIN_SDKOSVERSION = "sdkOsVersion";
    String NJDOMAIN_APPLICATIONID = "applicationID";

    String BUSINESS_STR1 = "returnCode";
    String BUSINESS_STR2 = "000000";
    String BUSINESS_STR3 = "-000000";//失败返回码
    String BUSINESS_STR4 = "验签失败,内容可能已被篡改,请重新发起交易";
    String BUSINESS_STR5 = "999999";
    String BUSINESS_STR6 = "服务器数据获取失败啦，请稍后再试!";

    String RESPONSE_SEQNO = "seqNO";
    String RESPONSE_RSPDATA = "rspData";
    String RESPONSE_RETURNCODE = "returnCode";
    String RESPONSE_RETURNMSG = "returnMsg";

    String RESPONSE_DEVICEID = "devId";
    String RESPONSE_DEVICENAME = "devName";
    String RESPONSE_APPID = "appID";
    String RESPONSE_RANDOM = "random";
    String RESPONSE_APPACCESSTOKEN = "appAccessToken";
    String RESPONSE_APPPARAM = "appParam";
    String RESPONSE_ERRORCODE = "errorCode";
    String RESPONSE_ERRORMSG = "errorMsg";
    String RESPONSE_SIGNMETHOD = "signMethod";
    String RESPONSE_ENCRYPTMETHOD = "encryptMethod";
    String RESPONSE_SECRETKEY = "secretKey";
    String RESPONSE_SIGN = "sign";
    String RESPONSE_SIGNDATA = "signData";
    String RESPONSE_SIGNDCERT = "signCert";
    String RESPONSE_REQDATA = "reqData";
    String RESPONSE_KEY = "aeskey";
    String RESPONSE_DATA = "data";
    String PAYUTIL_PAYINFO_STR1 = "支付信息为空";
    String RESPONSE_RANDOMNUM = "RandomNum";
    String RESPONSE_DEVICEID1 = "DeviceId";
    String RESPONSE_DEVICENAME1 = "DeviceName";
    String RESPONSE_IP = "IP";
    String RESPONSE_MAC = "MAC";
    String RESPONSE_PACKAGENAME = "PackageName";
    String RESPONSE_SIGNFIELD = "signField";

    String REGEXMODEL_STR1 = "非法的手机号";
    String REGEXMODEL_STR2 = "输入的参数无效";
    String REGEXMODEL_STR3 = "original非法";
    String BUSINESSREGEX_STR1 = "请输入有效参数";

    String HTTP_SOCKETTIMEOUT_ERRORMSG = "网络异常";

    String TLSDKMANANGERINNER_STR1 = "重复初始化,已取消任务";

    String PAYDIALOG_PAYING_SUCCESS_STR = "支付成功";
    String PAYDIALOG_PAYING_FAILD_STR = "支付失败";
    String PAYDIALOG_PAYING_CANCEL_STR = "用户取消";

    String TDTAG_PAY_NAME = "支付";
    String TDTAG_PAY_LABEL = "pay";
    String TDTAG_PAY_LABEL_EVENTID_1 = "调起支付";
    String TDTAG_PAY_LABEL_EVENTID_2 = "点击支付";
    String TDTAG_PAY_LABEL_EVENTID_3 = "支付成功";
    String TDTAG_PAY_LABEL_EVENTID_4 = "支付失败";
    String TDTAG_PAY_LABEL_EVENTID_5 = "取消支付";

    String TDTAG_WALLET_NAME = "钱包";
    String TDTAG_WALLET_LABEL = "wallet";
    String TDTAG_WALLET_LAYEL_EVENTID = "调起钱包";
}
