package com.qf.some.request;

import com.qf.some.bean.SomeUser;

/**
 * @author liuchaogang
 * @date 2017年4月12日
 */
public class UpdateSomeRequest extends CommonRequest {

    /**
     * @return
     */
    private static final long serialVersionUID = -399930646510645524L;
    
    private SomeUser user;

    public SomeUser getUser() {
        return user;
    }

    public void setUser(SomeUser user) {
        this.user = user;
    }
    

}
