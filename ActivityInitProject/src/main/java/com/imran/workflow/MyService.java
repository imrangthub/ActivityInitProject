package com.imran.workflow;

import java.util.List;
import java.util.Date;
import java.util.HashMap;

import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.imran.model.Person;
import com.imran.model.PersonRepository;

@Service
public class MyService {
	
	 @Autowired
	 private RuntimeService runtimeService;
	 
	 @Autowired
	 private TaskService taskService;
	 
	 @Autowired
	 private PersonRepository personRepository;
	 
	@Transactional
	public void startProcess() {	
	  runtimeService.startProcessInstanceByKey("exclusiveGetwayTaskProcess");
	 }
	
	@Transactional
	public void startProcessWithVar(String val) {		
		HashMap<String, Object> variableMap = new HashMap<String, Object>();
		int userInput = 0;
		 userInput = Integer.parseInt(val);
		if(userInput==2){
	        variableMap.put("isEnableTaskTwo", true);
	        variableMap.put("isEnableTaskThree", false);
		}else if(userInput==3){
	        variableMap.put("isEnableTaskTwo", false);
	        variableMap.put("isEnableTaskThree", true);
		}else{
	        variableMap.put("isEnableTaskTwo", true);
	        variableMap.put("isEnableTaskThree", true);
		}
		
	  runtimeService.startProcessInstanceByKey("inclusiveGetwayTaskProcess", variableMap);
	 }
		
	
   	@Transactional
 	public List<Task> getTasks(String assignee) {	
	    return taskService.createTaskQuery().taskAssignee(assignee).list();
	 
	 }
   	
    public void createDemoUsers() {
		 if (personRepository.findAll().size() == 0) {
	           personRepository.save(new Person("imran", "MD IMRAN", "HOSSAIN", new Date()));
	           personRepository.save(new Person("trademakers", "Tijs", "Rademakers", new Date()));
       }
   }


}
