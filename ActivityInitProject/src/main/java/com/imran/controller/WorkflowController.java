package com.imran.controller;

import java.util.ArrayList;
import java.util.List;

import org.activiti.engine.RepositoryService;
import org.activiti.engine.TaskService;
import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.imran.model.TaskRepresentation;
import com.imran.workflow.MyService;


@RestController
public class WorkflowController {
	
    @Autowired
	private MyService myService;
     
    @Autowired
	private TaskService taskService;
     
 	@Autowired
 	RepositoryService repositoryService;
 	
    @GetMapping("/")
    @ResponseBody
    public String index() {
    	long NumberOfRepository = repositoryService.createProcessDefinitionQuery().count();   	
    	  System.out.println("Number of process definitions: "+ NumberOfRepository);   	
        return "Number of process definitions From test Controller: "+NumberOfRepository;
    }

	 @RequestMapping(value="/startprocess", method= RequestMethod.GET)
	 public String startProcessInstance() {
	        myService.startProcess();
	     return "Successfully Process started";
	 }
	 
	 @RequestMapping(value="/startprocess-withvar", method= RequestMethod.GET)
	 public String startProcessInstanceWithVariabl3e(@RequestParam String x) {
	        myService.startProcessWithVar(x);
	     return "Successfully Process started With Variable";
	 }
	 
	 @RequestMapping(value="/startprocess-inclusive", method= RequestMethod.GET)
	 public String startProcessInstanceWithVariableInclusive(@RequestParam String val) {
	        myService.startProcessWithVar(val);
	     return "Successfully Inclusive Process started With Variable";
	 }

	 
}
 
