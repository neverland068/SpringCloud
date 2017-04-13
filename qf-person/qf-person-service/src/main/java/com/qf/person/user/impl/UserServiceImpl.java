package com.qf.person.user.impl;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.qf.person.domain.TUser;
import com.qf.person.mapper.TUserMapper;
import com.qf.person.user.UserService;

/**
 * @author liuchaogang
 * @date 2017年4月6日
 */
@Service
public class UserServiceImpl implements UserService {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);
    
    @Autowired
    TUserMapper userMapper;

    @Override
    public int addUser(String userName) {
        LOGGER.info("The add user name is >>>>>>>>>>>>>>>>"+userName);
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
        LOGGER.info("The update user is >>>>>>>>>>>>>>>>"+JSON.toJSONString(user));
        Integer result = userMapper.updateByPrimaryKey(user);
        return result;
    }


    @Override
    public int deleteUser(Long id) {
        LOGGER.info("The delete userId is >>>>>>>>>>>>>>>>"+id);
        int result = userMapper.deleteByPrimaryKey(id);
        return result;
    }


    @Override
    public TUser selectUserById(Long id) {
        LOGGER.info("The selete userId is >>>>>>>>>>>>>>>>"+id);
        TUser user = userMapper.selectByPrimaryKey(id);
        return user;
    }

}
