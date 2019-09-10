package com.shoppingApp.dao;

import java.util.List;

import javax.management.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.shoppingApp.model.Items;

@Repository
public class ItemsDaoImple implements ItemsDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public long save(Items item) {
		sessionFactory.getCurrentSession().save(item);
		return item.getId();
	}

	@Override
	public Items get(long id) {
		return sessionFactory.getCurrentSession().get(Items.class, id);
	}
	
	// get all the items of given category
	
	@Override
	public List<Items> getItems(String item_category) {
		System.out.println(item_category);
		List<Items> categorized_items=sessionFactory.getCurrentSession()
											.createQuery("from Items where item_category = :item_category")
												.setParameter("item_category", item_category).list();
		return categorized_items;
	}

	@Override
	public List<Items> list() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(long id, Items item) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(long id) {
		Items item=sessionFactory.getCurrentSession().byId(Items.class).load(id);
		sessionFactory.getCurrentSession().delete(item);
	}

	@Override
	public List<Items> getSupplierItems(long suplier_id) {
		System.out.println(suplier_id);
		List<Items> supplier_items=sessionFactory.getCurrentSession()
											.createQuery("from Items where suplier_id = :suplier_id")
												.setParameter("suplier_id", suplier_id).list();
		return supplier_items;
	}

}
