package com.qf.person.request;

import com.alibaba.fastjson.JSON;
import com.qf.person.bean.User;

/**
 * @author liuchaogang
 * @date 2017年4月12日
 */
public class UpdatePersonRequest extends CommonRequest {

    /**
     * @return
     */
    private static final long serialVersionUID = -399930646510645524L;
    
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    

}
