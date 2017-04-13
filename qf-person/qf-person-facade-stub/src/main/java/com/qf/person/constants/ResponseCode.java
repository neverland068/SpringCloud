package com.qf.person.constants;

/**
 * @author liuchaogang
 * @date 2017年4月12日
 */
public enum ResponseCode {
    RC_SUCCESS("1000","success"),
    RC_PARAMETER_ERROR("1001","parameter invalid"),
    RC_EXCEPTION_ERROR("1002","service exception"),
    RC_PERSON_ADD_ERROR("1000001001","Add failed"),
    RC_PERSON_UPDATE_ERROR("1000001002","Update failed"),
    RC_PERSON_DELETE_ERROR("1000001003","Delete failed"),
    RC_PERSON_SELECT_ERROR("1000001004","Select failed")
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
