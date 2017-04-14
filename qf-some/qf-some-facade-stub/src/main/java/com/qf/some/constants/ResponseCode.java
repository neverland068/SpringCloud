package com.qf.some.constants;

/**
 * @author liuchaogang
 * @date 2017年4月12日
 */
public enum ResponseCode {
    RC_SUCCESS("1000","success"),
    RC_PARAMETER_ERROR("1001","parameter invalid"),
    RC_EXCEPTION_ERROR("1002","service exception"),
    RC_CALL_PERSON_ERROR("1000002001","Call Person Service Failed"),
    RC_SOME_ADD_ERROR("1000002002","Add failed"),
    RC_SOME_UPDATE_ERROR("1000002003","Update failed"),
    RC_SOME_DELETE_ERROR("1000002004","Delete failed"),
    RC_SOME_SELECT_ERROR("1000002005","Select failed")
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
