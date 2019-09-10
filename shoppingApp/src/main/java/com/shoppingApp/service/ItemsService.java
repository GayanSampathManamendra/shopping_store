package com.shoppingApp.service;

import java.util.List;

import com.shoppingApp.model.Items;

public interface ItemsService {
	
	long save(Items item);
	
	Items get(long id);
	
	List<Items> getItems(String item_category);
	
	List<Items> list();
	
	void update(long id, Items item);
	
	void delete(long id);
	
	 List<Items> getSupplierItems(long suplier_id);

}
