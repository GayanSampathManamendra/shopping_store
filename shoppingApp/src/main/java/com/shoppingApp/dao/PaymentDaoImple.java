package com.shoppingApp.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.shoppingApp.model.Payment;

@Repository
public class PaymentDaoImple  implements PaymentDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public long save(Payment payment) {
		sessionFactory.getCurrentSession().save(payment);
		return payment.getId();
	}

	@Override
	public Payment get(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Payment> list() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(long id, Payment payment) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub
		
	}

}
