package com.shoppingApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shoppingApp.dao.ItemsDao;
import com.shoppingApp.model.Items;

@Service
@Transactional(readOnly=true)
public class ItemsServiceImple implements ItemsService{

	@Autowired
	private ItemsDao itemsDao;
	
	@Transactional 
	@Override
	public long save(Items item) {
		return itemsDao.save(item);
	}

	
	@Override
	public Items get(long id) {
		return itemsDao.get(id);
	}
	
	// get the items from given category
	
	@Override
	public List<Items> getItems(String item_category) {
		return itemsDao.getItems(item_category);
	}


	@Override
	public List<Items> list() {
		// TODO Auto-generated method stub
		return null;
	}

	@Transactional
	@Override
	public void update(long id, Items item) {
		// TODO Auto-generated method stub
		
	}

	@Transactional
	@Override
	public void delete(long id) {
		itemsDao.delete(id);
		
	}


	@Override
	public List<Items> getSupplierItems(long suplier_id) {
		return itemsDao.getSupplierItems(suplier_id);
	}

}
