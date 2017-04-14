package com.qf.gateway.fallback.response;

/**
 * @author liuchaogang
 * @date 2017年4月12日
 */
public enum ResponseCode {
    RC_CALL_ERROR("1001","Call Service failed.")
    ;
    
    private String responseCode;
    private String responseMessage;
    
    ResponseCode(String responseCode, String responseMessage){
        this.responseCode = responseCode;
        this.responseMessage = responseMessage;
    }

    public String getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }

    public String getResponseMessage() {
        return responseMessage;
    }

    public void setResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }
    
    
}
