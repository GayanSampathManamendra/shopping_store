package com.shoppingApp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "Payment")
public class Payment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String order_id;
	private String amount;
	private int is_comformed;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getOrder_id() {
		return order_id;
	}
	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public int getIs_comformed() {
		return is_comformed;
	}
	public void setIs_comformed(int is_comformed) {
		this.is_comformed = is_comformed;
	}
	@Override
	public String toString() {
		return "Payment [id=" + id + ", order_id=" + order_id + ", amount=" + amount + ", is_comformed=" + is_comformed
				+ "]";
	}
	
	
}
