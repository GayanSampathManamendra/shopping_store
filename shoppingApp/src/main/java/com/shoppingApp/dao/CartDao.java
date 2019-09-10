package com.shoppingApp.dao;

import java.util.List;

import com.shoppingApp.model.Cart;
import com.shoppingApp.model.Items;

public interface CartDao {

long save(Cart cart);
	
	Cart get(long id);
	
	List<Cart> getCartItemsId(long customer_id);
	
	List<Cart> list();
	
	void update(long id, Cart cart);
	
	void delete(long id);
}
