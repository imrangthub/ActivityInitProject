package com.imran.model;

public class TaskRepresentation {
	
	 private String id;
	 private String name;
	 private String defId;

	 public TaskRepresentation(String id, String name, String defId) {
		 this.id = id;
		 this.name = name;
		 this.defId = defId;
	 }
	 public String getId() {
	     return id;
	 }
	 public void setId(String id) {
	    this.id = id;
	 }
    public String getName() {
	   return name;
	 }
	 public void setName(String name) {
	    this.name = name;
	 }
	public String getDefId() {
		return defId;
	}
	public void setDefId(String defId) {
		this.defId = defId;
	}
	
}

