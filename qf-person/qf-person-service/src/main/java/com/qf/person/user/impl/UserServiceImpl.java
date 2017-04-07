package com.qf.person.user.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qf.person.domain.TUser;
import com.qf.person.mapper.TUserMapper;
import com.qf.person.user.UserService;

/**
 * @author liuchaogang
 * @date 2017年4月6日
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    TUserMapper userMapper;

    @Override
    public int addUser(String userName) {
        TUser u = new TUser();
        u.setName(userName);
        u.setDisplayName("D-" + userName);
        u.setCreateTime(new Date());
        u.setCreator("Admin");
        u.setDeleteFlag(false);
        u.setUpdater("Admin");
        u.setUpdateTime(new Date());
        int result = userMapper.insert(u);
        return result;
    }


    @Override
    public int updateUser(TUser user) {
        Integer result = userMapper.updateByPrimaryKey(user);
        return result;
    }


    @Override
    public int deleteUser(Long id) {
        int result = userMapper.deleteByPrimaryKey(id);
        return result;
    }


    @Override
    public TUser selectUserById(Long id) {
        TUser user = userMapper.selectByPrimaryKey(id);
        return user;
    }

}
