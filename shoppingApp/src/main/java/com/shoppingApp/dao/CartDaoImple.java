package com.shoppingApp.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.shoppingApp.model.Booking;
import com.shoppingApp.model.Cart;
import com.shoppingApp.model.Items;

@Repository
public class CartDaoImple implements CartDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public long save(Cart cart) {
		sessionFactory.getCurrentSession().save(cart);
		return cart.getId();
	}

	@Override
	public Cart get(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	// get all the cart item (id s)
	@Override
	public List<Cart> getCartItemsId(long customer_id) {
		List<Cart> cart_items=sessionFactory.getCurrentSession()
				.createQuery("from Cart where customer_id = :customer_id")
					.setParameter("customer_id", customer_id).list();
		return cart_items;
	}


	@Override
	public List<Cart> list() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(long id, Cart cart) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(long id) {
		Cart cart = sessionFactory.getCurrentSession().byId(Cart.class).load(id);
	    sessionFactory.getCurrentSession().delete(cart);
		
	}

}
