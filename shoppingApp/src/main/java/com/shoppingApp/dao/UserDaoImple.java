package com.shoppingApp.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.shoppingApp.model.Booking;
import com.shoppingApp.model.User;

@Repository
public class UserDaoImple implements UserDao{
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public long save(User user) {
		sessionFactory.getCurrentSession().save(user);
		return user.getId();
	}

	@Override
	public User get(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> list() {
		List<User> all_Users = sessionFactory.getCurrentSession().createQuery("from User").list();
		return all_Users;
	}

	@Override
	public void update(long id, User user) {
		  Session session = sessionFactory.getCurrentSession();
	      User current_user = session.byId(User.class).load(id);
	      current_user.setEmail(user.getEmail());
	      current_user.setIs_comformed(user.getIs_comformed());
	      current_user.setOtp(user.getOtp());
	      current_user.setPassword(user.getPassword());
	      current_user.setRole(user.getRole());
	      current_user.setUser_name(user.getUser_name());
	      current_user.setIs_loged(user.getIs_loged());
	      session.flush();
		
	}

	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<User> checkOtp(String otp) {
		return sessionFactory.getCurrentSession()
				.createQuery("from User where otp = :otp").setParameter("otp", otp).list();
	}


}
