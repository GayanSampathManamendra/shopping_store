package com.shoppingApp.dao;

import java.util.List;

import com.shoppingApp.model.Booking;
import com.shoppingApp.model.Payment;

public interface PaymentDao {
	
	long save(Payment payment);

	   Payment get(long id);

	   List<Payment> list();

	   void update(long id, Payment payment);

	   void delete(long id);
}
