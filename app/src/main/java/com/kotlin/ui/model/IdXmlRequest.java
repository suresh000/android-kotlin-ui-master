package com.kotlin.ui.model;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "root")
public class IdXmlRequest {

    @Element(name = "subKuaRefNo")
    private String subKuaRefNo;

    @Element(name = "licensekey")
    private String licensekey;

    @Element(name = "subKuaCode")
    private String subKuaCode;

    @Element(name = "authenticationType")
    private String authenticationType;

    @Element(name = "kuaApiVersion")
    private String kuaApiVersion;

    @Element(name = "reqResType")
    private String reqResType;

    @Element(name = "pan")
    private String pan;

    @Element(name = "successUrl")
    private String successUrl;

    @Element(name = "failUrl")
    private String failUrl;

    @Element(name = "checkSum")
    private String checkSum;

    public IdXmlRequest() {}

    public String getSubKuaRefNo() {
        return subKuaRefNo;
    }

    public void setSubKuaRefNo(String subKuaRefNo) {
        this.subKuaRefNo = subKuaRefNo;
    }

    public String getLicensekey() {
        return licensekey;
    }

    public void setLicensekey(String licensekey) {
        this.licensekey = licensekey;
    }

    public String getSubKuaCode() {
        return subKuaCode;
    }

    public void setSubKuaCode(String subKuaCode) {
        this.subKuaCode = subKuaCode;
    }

    public String getAuthenticationType() {
        return authenticationType;
    }

    public void setAuthenticationType(String authenticationType) {
        this.authenticationType = authenticationType;
    }

    public String getKuaApiVersion() {
        return kuaApiVersion;
    }

    public void setKuaApiVersion(String kuaApiVersion) {
        this.kuaApiVersion = kuaApiVersion;
    }

    public String getReqResType() {
        return reqResType;
    }

    public void setReqResType(String reqResType) {
        this.reqResType = reqResType;
    }

    public String getPan() {
        return pan;
    }

    public void setPan(String pan) {
        this.pan = pan;
    }

    public String getSuccessUrl() {
        return successUrl;
    }

    public void setSuccessUrl(String successUrl) {
        this.successUrl = successUrl;
    }

    public String getFailUrl() {
        return failUrl;
    }

    public void setFailUrl(String failUrl) {
        this.failUrl = failUrl;
    }

    public String getCheckSum() {
        return checkSum;
    }

    public void setCheckSum(String checkSum) {
        this.checkSum = checkSum;
    }

}
