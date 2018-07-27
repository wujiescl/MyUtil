package com.sdk.szsm.log;

import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import szxx.sdk.util.XMLUtil;

/**
 * 描述:${Description}
 * 创建者:wangkang
 * 邮箱: victorwangk@qq.com
 * SDK
 * 日期:2017/8/11
 */

public class LogFormat {
    private String model = null;//手机型号
    private String sysVersion = null; //系统版本号
    private String sysSdkVersion = null; //系统SDK版本号
    private String sdkVersion = null; //系统SDK版本号
    private String logName = null; //日志文件名称
    private String logInfo = null; //错误日志信息

    public LogFormat(String model, String sysVersion, String sysSdkVersion, String sdkVersion, String logName, String
            logInfo) {
        this.model = model;
        this.sysVersion = sysVersion;
        this.sysSdkVersion = sysSdkVersion;
        this.sdkVersion = sdkVersion;
        this.logName = logName;
        this.logInfo = logInfo;
    }

    public String getSysVersion() {
        return sysVersion;
    }

    public void setSysVersion(String sysVersion) {
        this.sysVersion = sysVersion;
    }

    public String getSdkVersion() {
        return sdkVersion;
    }

    public void setSdkVersion(String sdkVersion) {
        this.sdkVersion = sdkVersion;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getReleaseVersion() {
        return sysVersion;
    }

    public void setReleaseVersion(String releaseVersion) {
        this.sysVersion = releaseVersion;
    }

    public String getSysSdkVersion() {
        return sysSdkVersion;
    }

    public void setSysSdkVersion(String sysSdkVersion) {
        this.sysSdkVersion = sysSdkVersion;
    }

    public String getLogName() {
        return logName;
    }

    public void setLogName(String logName) {
        this.logName = logName;
    }

    public String getLogInfo() {
        return logInfo;
    }

    public void setLogInfo(String logInfo) {
        this.logInfo = logInfo;
    }

    public String getReq(LogFormat req) {
        Document doc = null;
        Element root = null;
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory
                    .newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            doc = builder.newDocument();

            root = doc.createElement("log");
            Element modelEle = doc.createElement("model");
            modelEle.appendChild(doc.createTextNode(req.getModel()));
            Element releaseVersionEle = doc.createElement("sysVersion");
            releaseVersionEle.appendChild(doc.createTextNode(req.getReleaseVersion()));
            Element sysSdkVersion = doc.createElement("sysSdkVersion");
            sysSdkVersion.appendChild(doc.createTextNode(req.getSysSdkVersion()));
            Element sdkVersionEle = doc.createElement("sdkVersion");
            sdkVersionEle.appendChild(doc.createTextNode(req.getSdkVersion()));
            Element logNameEle = doc.createElement("logName");
            logNameEle.appendChild(doc.createTextNode(req.getLogName()));
            Element logInfoEle = doc.createElement("logInfo");
            logInfoEle.appendChild(doc.createTextNode(req.getLogInfo()));

            root.appendChild(modelEle);
            root.appendChild(releaseVersionEle);
            root.appendChild(sysSdkVersion);
            root.appendChild(sdkVersionEle);
            root.appendChild(logNameEle);
            root.appendChild(logInfoEle);


            doc.appendChild(root);
        } catch (DOMException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
        return XMLUtil.getXML(doc);
    }
}
