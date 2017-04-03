package com.wisely.ui.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.wisely.ui.domain.Person;

@Service
public class PersonHystrixService {

	@Autowired
	PersonService personService; 

	@HystrixCommand(fallbackMethod = "fallbackSave") //1
	public Integer save(String name) {
		return personService.add(name);
	}
	
	public Integer fallbackSave(String name){ 
		return -1;
	}
}
