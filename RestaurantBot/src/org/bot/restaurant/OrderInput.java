package org.bot.restaurant;

import java.util.List;

public class OrderInput {
	String robotID;
	List<Order> orders;
	public String getRobotID() {
		return robotID;
	}
	public void setRobotID(String robotID) {
		this.robotID = robotID;
	}
	public List<Order> getOrders() {
		return orders;
	}
	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}
}
