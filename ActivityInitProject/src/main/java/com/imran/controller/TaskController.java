package com.imran.controller;

import java.util.ArrayList;
import java.util.List;

import org.activiti.engine.RepositoryService;
import org.activiti.engine.TaskService;
import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.imran.model.TaskRepresentation;
import com.imran.workflow.MyService;


@RestController
public class TaskController {
	
    @Autowired
	private MyService myService;
     
    @Autowired
	private TaskService taskService;
     
 	@Autowired
 	RepositoryService repositoryService;
 	
	 
	 @RequestMapping(value="/tasks", method= RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	 public List<TaskRepresentation> getTasks(@RequestParam String assignee) {
		 
		 System.out.println("Request Params Assignee: "+assignee);
		 
		 System.out.println("Number of tasks : " + taskService.createTaskQuery().count());
		 
			 List<Task> tasks = myService.getTasks(assignee);
			 List<TaskRepresentation> dtos = new ArrayList<TaskRepresentation>();
			 for (Task task : tasks) {
			 dtos.add(new TaskRepresentation(task.getId(), task.getName(), task.getTaskDefinitionKey()));
		 }
		 return dtos;
	 }
	 
	 @RequestMapping(value="/complete-task", method= RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	 public String completeTasks(@RequestParam String assignee) {		 
	    System.out.println("Request Params Assignee: "+assignee);	 
	    List<Task> tasks = null;	    
		     tasks = taskService.createTaskQuery().taskAssignee(assignee).list();
		   if(!tasks.isEmpty()){
		    for (Task task : tasks) {
		      System.out.println("Task for "+assignee+": "+ task.getName()+" Hasbeen complete.");
		      // Complete the task
		  
		      taskService.complete(task.getId());
		    }
		      return "Successfully complete the task..!";
		  }
	   return "Task not Found for this user..!";
		    
	 }
	 
	 
	 @RequestMapping(value="/complete-task-id", method= RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	 public String completeTasksById(@RequestParam String taskId) {		 	 
	    System.out.println("Request Params Task Id: "+taskId);	 
	    List<Task> tasks = null;	    
		    // tasks = taskService.createTaskQuery().taskAssignee(assignee).list();
		     tasks = taskService.createTaskQuery().taskId(taskId).list();
		   if(!tasks.isEmpty()){
		    for (Task task : tasks) {
		    	
		    	if(task.getId().equals(taskId)){
		    		   System.out.println("Task for "+task.getName()+", Task ID: "+task.getId()+",  Hasbeen complete.");		    			  
		 		        taskService.complete(task.getId());
		    	}else{
		    		return "Task ID does not match";
		    	}
		   
		    }
		      return "Successfully complete the task..!";
		  }
	   return "Task not Found for this user..!";
		    
	 }
	 
}
 
