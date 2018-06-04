package com.imran.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.imran.workflow.MyService;


@RestController
public class PersonController {
	
    @Autowired
	private MyService myService;

	 @RequestMapping(value="/createuser", method= RequestMethod.GET)
	 public String startProcessInstance() {
	        myService.createDemoUsers();
	     return "Successfully User created";
	 }

	 
}
 
