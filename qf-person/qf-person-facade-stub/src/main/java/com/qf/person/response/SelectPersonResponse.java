package com.qf.person.response;

/**
 * @author liuchaogang
 * @date 2017年4月12日
 */
public class SelectPersonResponse<T> extends CommonResponse {

    /**
     * @return
     */
    private static final long serialVersionUID = -7319419590547516624L;
    
    T user;

    public T getUser() {
        return user;
    }

    public void setUser(T user) {
        this.user = user;
    }
    
    
    

}
