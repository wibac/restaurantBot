package org.bot.restaurant;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Order {
	private String id;
	private String amount;

	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	
	
}
