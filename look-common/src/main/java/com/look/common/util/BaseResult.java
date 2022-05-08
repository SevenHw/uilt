package com.look.common.util;

import java.io.Serializable;

/**
 * 返回结果Base
 * 
 */
public class BaseResult implements Serializable {

    private static final long serialVersionUID = -5342773507434772689L;

    protected boolean         result;                                  //结果：标识成功失�?

    protected String          resultCode;                              //code

    protected String          resultInfo;                              //info

    protected String          reason;                                  //原因

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public boolean getResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public String getResultInfo() {
        return resultInfo;
    }

    public void setResultInfo(String resultInfo) {
        this.resultInfo = resultInfo;
    }

}
