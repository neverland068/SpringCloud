package com.qf.some.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.qf.some.SomeUserService;
import com.qf.some.person.PersonService;

/**
 * @author liuchaogang
 * @date 2017年4月6日
 */
@Service
public class SomeUserServiceImpl implements SomeUserService {
    @Autowired
    private PersonService personService;
    @Value("${my.message}") //1
    private String message; 
    
    @Override
//    @HystrixCommand(fallbackMethod = "fallbackSave") 
    public Integer addSomeUser(String name) {
       return personService.add(name+": "+message);
    }

    public Integer fallbackSave(String name){ 
        return -1;
    }

    
}
