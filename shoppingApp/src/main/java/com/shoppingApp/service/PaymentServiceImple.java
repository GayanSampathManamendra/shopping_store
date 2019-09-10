package com.shoppingApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shoppingApp.dao.PaymentDao;
import com.shoppingApp.model.Payment;

@Service
@Transactional(readOnly = true)
public class PaymentServiceImple implements PaymentService{

	@Autowired
	private PaymentDao paymentDao; 
	
	@Transactional
	@Override
	public long save(Payment payment) {
		// TODO Auto-generated method stub
		return paymentDao.save(payment);
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

	@Transactional
	@Override
	public void update(long id, Payment payment) {
		// TODO Auto-generated method stub
		
	}

	@Transactional
	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub
		
	}

}
