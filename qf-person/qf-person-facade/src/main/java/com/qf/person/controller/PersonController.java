package com.qf.person.controller;


import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.qf.person.domain.TUser;
import com.qf.person.user.UserService;

@RestController
public class PersonController {
    @Autowired
    UserService userService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public int addPerson(@RequestBody String personName) {
        return userService.addUser(personName);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public int deletePerson(@PathVariable Long id) {
        return userService.deleteUser(id);
    }

    @RequestMapping(value = "/select/{id}", method = RequestMethod.GET)
    public TUser selectPerson(@PathVariable Long id) {
        return userService.selectUserById(id);
    }
    
    @RequestMapping(value = "/update", method = RequestMethod.PUT, produces="application/json",consumes="application/json")
    public Integer updatePerson(@RequestBody TUser user) {
        return userService.updateUser(user);
    }



}
