package com.shoppingApp.service;

import java.util.List;

import com.shoppingApp.model.Payment;

public interface PaymentService {
	
	long save(Payment payment);

	   Payment get(long id);

	   List<Payment> list();

	   void update(long id, Payment payment);

	   void delete(long id);
}
