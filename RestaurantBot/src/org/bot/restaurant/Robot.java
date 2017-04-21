package org.bot.restaurant;

public class Robot {
	String id;
	Boolean status;
	public Robot(){
		
	}
	public Robot(String id, Boolean status){
		this.id = id;
		this.status = status;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Boolean getStatus() {
		return status;
	}
	public void setStatus(Boolean status) {
		this.status = status;
	}
	
}
