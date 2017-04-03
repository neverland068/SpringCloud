package com.wisely.person.controller;


import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wisely.person.domain.TUser;
import com.wisely.person.mapper.TUserMapper;

@RestController
public class PersonController {
    @Autowired
    TUserMapper userMapper;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public int addPerson(@RequestBody String personName) {
        TUser u = new TUser();
        u.setName(personName);
        u.setDisplayName("D-" + personName);
        u.setCreateTime(new Date());
        u.setCreator("Admin");
        u.setDeleteFlag(false);
        u.setUpdater("Admin");
        u.setUpdateTime(new Date());
        int result = userMapper.insert(u);
        return result;
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public int deletePerson(@PathVariable Long id) {
        int result = userMapper.deleteByPrimaryKey(id);
        return result;
    }

    @RequestMapping(value = "/select/{id}", method = RequestMethod.GET)
    public TUser selectPerson(@PathVariable Long id) {
        TUser user = userMapper.selectByPrimaryKey(id);
        return user;
    }
    
    @RequestMapping(value = "/update", method = RequestMethod.PUT, produces="application/json",consumes="application/json")
    public Integer updatePerson(@RequestBody TUser user) {
        Integer result = userMapper.updateByPrimaryKey(user);
        return result;
    }



}
