package com.shoppingApp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="Cart")
public class Cart {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private long order_id;
	private long customer_id;
	private long suplier_id;
	private int is_payed;
	private String order_date;
	private int quentity;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getOrder_id() {
		return order_id;
	}
	public void setOrder_id(long order_id) {
		this.order_id = order_id;
	}
	public long getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(long customer_id) {
		this.customer_id = customer_id;
	}
	public long getSuplier_id() {
		return suplier_id;
	}
	public void setSuplier_id(long suplier_id) {
		this.suplier_id = suplier_id;
	}
	public int getIs_payed() {
		return is_payed;
	}
	public void setIs_payed(int is_payed) {
		this.is_payed = is_payed;
	}
	public String getOrder_date() {
		return order_date;
	}
	public void setOrder_date(String order_date) {
		this.order_date = order_date;
	}
	public int getQuentity() {
		return quentity;
	}
	public void setQuentity(int quentity) {
		this.quentity = quentity;
	}
	
	@Override
	public String toString() {
		return "Cart [id=" + id + ", order_id=" + order_id + ", customer_id=" + customer_id + ", suplier_id="
				+ suplier_id + ", is_payed=" + is_payed + ", order_date=" + order_date + ", quentity=" + quentity + "]";
	}
	
	
}
