package org.bot.restaurant;

import java.util.ArrayList;
import java.util.List;

public class Polling {
	static Polling polling;
	private Polling(){
		System.out.println("Private constructor to make this class singleton");
	}
	
	static Polling getPollingObj(){
		if(polling==null){
			polling = new Polling();
		}
		return polling;
	}
	List<Robot> lstRobot;
	List<Order> lstOrder;
	public List<Robot> getLstRobot() {
		if(lstRobot==null){
			lstRobot = new ArrayList<Robot>();
		}
		return lstRobot;
	}
	public void setLstRobot(List<Robot> lstRobot) {
		this.lstRobot = lstRobot;
	}
	public List<Order> getLstOrder() {
		if(lstOrder==null){
			lstOrder = new ArrayList<Order>();
		}
		return lstOrder;
	}
	public void setLstOrder(List<Order> lstOrder) {
		this.lstOrder = lstOrder;
	}
}
