package com.qf.person.user;

import com.qf.person.domain.TUser;

/**
 * @author liuchaogang
 * @date 2017年4月6日
 */
public interface UserService {

    public int addUser(String userName); 
    public int updateUser(TUser user);
    public int deleteUser( Long id);
    public TUser selectUserById(Long id);
}
