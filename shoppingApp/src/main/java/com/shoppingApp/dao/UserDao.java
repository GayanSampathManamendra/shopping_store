package com.shoppingApp.dao;

import java.util.List;

import com.shoppingApp.model.User;

public interface UserDao {
	
	   long save(User user);

	   User get(long id);

	   List<User> list();

	   User update(long id, User user);

	   void delete(long id);

	List<User> checkOtp(String otp);
	
	


}
