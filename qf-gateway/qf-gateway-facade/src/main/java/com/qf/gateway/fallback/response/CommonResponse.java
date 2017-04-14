package com.qf.gateway.fallback.response;

import java.io.Serializable;

/**
 * @author liuchaogang
 * @date 2017年4月12日
 */
public class CommonResponse implements Serializable{

    
    /**
     * @return
     */
    private static final long serialVersionUID = -8349696635548886541L;

    private String responseCode;
    
    private String responseMessage;
    

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
