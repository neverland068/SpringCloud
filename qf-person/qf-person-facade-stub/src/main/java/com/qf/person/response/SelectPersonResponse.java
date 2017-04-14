package com.qf.person.response;

/**
 * @author liuchaogang
 * @date 2017年4月12日
 */
public class SelectPersonResponse<User> extends CommonResponse {

    /**
     * @return
     */
    private static final long serialVersionUID = -7319419590547516624L;
    
    User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    
    
    

}
