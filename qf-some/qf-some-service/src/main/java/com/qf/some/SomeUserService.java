package com.qf.some;

import com.qf.some.bean.SomeUser;

/**
 * @author liuchaogang
 * @date 2017年4月6日
 */
public interface SomeUserService {

    public int addSomeUser(String userName); 
    public int updateSomeUser(SomeUser user);
    public int deleteSomeUser( Long id);
    public SomeUser selectSomeUserById(Long id);
}
