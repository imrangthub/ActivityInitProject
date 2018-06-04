//package com.imran.workflow;
//
//import java.util.Map;
//import javax.annotation.PostConstruct;
//import org.activiti.engine.RuntimeService;
//import org.activiti.engine.runtime.ProcessInstance;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//@Component
//public class WorkflowInitializer {
//	
//	@Autowired
//	private RuntimeService runtimeService;
//	private static RuntimeService staticRuntimeService;
//	
//	@PostConstruct
//	private RuntimeService setRuntimeService(){
//		return staticRuntimeService= runtimeService;
//	}
//	
//	public static ProcessInstance start(String key,Map<String,Object> variables){
//		ProcessInstance processInstance = staticRuntimeService.startProcessInstanceByKey(key, variables);
//		return processInstance;
//	}
//}