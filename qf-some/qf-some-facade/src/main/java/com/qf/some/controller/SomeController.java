package com.qf.some.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.qf.some.SomeUserService;

@RestController
public class SomeController {
	@Autowired
	private SomeUserService someUserService;
	
    @RequestMapping(value = "/add", method = RequestMethod.POST)
	 public Integer addSomeUser(@RequestBody String name){
		return someUserService.addSomeUser(name);
	 }
    
}
