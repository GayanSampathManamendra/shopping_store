package com.shoppingApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shoppingApp.dao.UserDao;
import com.shoppingApp.model.User;

@Service
@Transactional(readOnly = true)
public class UserServiceImple implements UserService {
	
	@Autowired
	private UserDao userDao;

	@Transactional
	@Override
	public long save(User user) {
		System.out.println(user.getOtp());
		return userDao.save(user);
	}

	@Override
	public User get(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> list() {
		return userDao.list();
	}

	@Transactional
	@Override
	public void update(long id, User user) {
		userDao.update(id, user);
		
	}

	@Transactional
	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<User> checkOtp(String otp) {
		return userDao.checkOtp(otp);
	}

	

}
