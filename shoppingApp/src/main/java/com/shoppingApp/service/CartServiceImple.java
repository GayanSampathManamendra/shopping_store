package com.shoppingApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shoppingApp.dao.CartDao;
import com.shoppingApp.model.Cart;
import com.shoppingApp.model.Items;

@Service
@Transactional(readOnly = true)
public class CartServiceImple implements CartService{

	@Autowired
	private CartDao cartDao;
	

	@Transactional
	@Override
	public long save(Cart cart) {
		return cartDao.save(cart);
	}

	@Override
	public Cart get(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	// get all the cart items (id ..)
	
	@Override
	public List<Cart> getCartItemsId(long customer_id) {
		return cartDao.getCartItemsId(customer_id);
	}

	
	@Override
	public List<Cart> list() {
		// TODO Auto-generated method stub
		return null;
	}

	@Transactional
	@Override
	public void update(long id, Cart cart) {
		// TODO Auto-generated method stub
		
	}

	@Transactional
	@Override
	public void delete(long id) {
		cartDao.delete(id);
	}

}
