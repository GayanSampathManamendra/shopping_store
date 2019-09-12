package com.shoppingApp.testing;

import static org.junit.jupiter.api.Assertions.*;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.stubbing.OngoingStubbing;
import org.springframework.beans.factory.annotation.Autowired;



import com.shoppingApp.controller.UserController;
import com.shoppingApp.dao.UserDao;
import com.shoppingApp.model.User;
import com.shoppingApp.service.UserService;
import com.shoppingApp.service.UserServiceImple;
 

import org.junit.jupiter.api.Test;

@RunWith(MockitoJUnitRunner.class)
class userDaoTesting {
	
	@InjectMocks
	UserService userService=new UserServiceImple();
	     
	@Mock
	UserDao userDao;
	 
	@BeforeEach
	public void init() {
		System.out.println("mock initialized !");
	    MockitoAnnotations.initMocks(this);
	 }
	
	@Autowired
	UserController userController;

	@Test
	void testSaveDao() {
		System.out.println("save method testing ..");
		User user=new User();
		user.setId(1L);
		user.setUser_name("Gayan");
		user.setPassword("123");
		user.setEmail("test@gmail.com");
		user.setIs_comformed(0);
		user.setIs_loged(1);
		user.setRole(1);
		
		when(userDao.save(user)).thenReturn(user.getId());
		//assertEquals(1L,when(userDao.save(user)).thenReturn(user.getId()));
	} 
	
	@Test
	void testList() {
		System.out.println("List method testing..");
		List<User> userList1=new ArrayList<User>();
		User user1=new User();
		user1.setId(1L);
		user1.setUser_name("gayan");
		user1.setEmail("gayan@gmail.com");
		user1.setIs_comformed(1);
		user1.setIs_loged(1);
		user1.setOtp("soiajhdfoijasoifjoiajfoiw+656faf");
		user1.setPassword("123");
		user1.setRole(1);
		
		User user2=new User();
		user1.setId(2L);
		user1.setUser_name("sampath");
		user1.setEmail("samapth@gmail.com");
		user1.setIs_comformed(1);
		user1.setIs_loged(1);
		user1.setOtp("soiajhdfsfdafsafsafaaf");
		user1.setPassword("12345");
		user1.setRole(1);
		
		userList1.add(user1);
		userList1.add(user2);
		
		when(userDao.list()).thenReturn(userList1);
		
		List<User> userList2=userService.list();
		
		assertEquals(2,userList2.size());
		verify(userDao, times(1)).list();
		
	}
	
	
	//@Test
	void testUpdate() {
		  System.out.println("Update method testing..");
		  User current_user=new User();
		  current_user.setId(1L);
		  current_user.setEmail("gayan@gmail.com");
	      current_user.setIs_comformed(0);
	      current_user.setOtp("oijhsoidjvpoisj7656kijhbv");
	      current_user.setPassword("123");
	      current_user.setRole(1);
	      current_user.setUser_name("gayan");
	      current_user.setIs_loged(0);
	      
	      User new_user=new User();
	      current_user.setId(1L);
	      new_user.setEmail("sampath@gmail.com");
	      new_user.setIs_comformed(1);
	      new_user.setOtp("oijhsoioijhsfngalkan");
	      new_user.setPassword("456");
	      new_user.setRole(1);
	      new_user.setUser_name("sampath");
	      new_user.setIs_loged(1);
	      
	      UserDao updated_user=(UserDao) when(userDao.update(current_user.getId(), new_user)).thenReturn(new_user);
	      
	      assertEquals(new_user,updated_user);
	      
	      
	}
	      

}
