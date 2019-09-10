package com.shoppingApp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="Items")
public class Items {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	
	private String item_name;
	private String item_category;
	private long suplier_id;
	private long stock;
	private int price;
	private String brand;
	private String description;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getItem_name() {
		return item_name;
	}
	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}
	public String getItem_category() {
		return item_category;
	}
	public void setItem_category(String item_category) {
		this.item_category = item_category;
	}
	public long getSuplier_id() {
		return suplier_id;
	}
	public void setSuplier_id(long suplier_id) {
		this.suplier_id = suplier_id;
	}
	public long getStock() {
		return stock;
	}
	public void setStock(long stock) {
		this.stock = stock;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	@Override
	public String toString() {
		return "Items [id=" + id + ", item_name=" + item_name + ", item_category=" + item_category + ", suplier_id="
				+ suplier_id + ", stock=" + stock + ", price=" + price + ", brand=" + brand + ", description="
				+ description + "]";
	}
	
	
}
