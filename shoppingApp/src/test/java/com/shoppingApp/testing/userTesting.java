package com.shoppingApp.testing;

import static org.junit.jupiter.api.Assertions.*;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
 

import org.junit.Before;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;



import com.shoppingApp.controller.UserController;
import com.shoppingApp.dao.UserDao;
import com.shoppingApp.model.User;
import com.shoppingApp.service.UserService;

@RunWith(MockitoJUnitRunner.class)
class userTesting {
	
	// creating the user object reference ..
	static User user=null;
	static HashMap<String, String> usernameAndPasswords = new HashMap<String, String>();
	
	@InjectMocks
	UserService userService;
	     
	@Mock
	UserDao userDao;
	 
	@Before
	public void init() {
	    MockitoAnnotations.initMocks(this);
	 }
	
	@Autowired
	UserController userController;
	
	@BeforeAll
	static void setup() {
		user=new User();
		
		if(user != null) {
			System.out.println("new user is created !");
		}
		else {
			System.out.println("something went wrong when creating new user !");
		}
		
	}
	
	// start model class testing ...
	
	@Test
	void setUsername() {
		String user_name = "Gayan";
		assertNotNull(user_name);
		user.setUser_name(user_name);
		usernameAndPasswords.put("user_name", user_name);
		System.out.println("set the user name !");
		
	}
	
	@Test
	void getUsername() {
		user.getUser_name();
		System.out.println("get the user name !" );
	}
	
	@Test
	void setPassword() {
		String password="123";
		assertNotNull(password);
		user.setPassword(password);
		usernameAndPasswords.put("password", password);
		System.out.println("set the password !");
	}
	
	@Test
	void getPassword() {
		user.getPassword();
		System.out.println("get the password !");
	}
	
	@Test
	void setEmail() {
		String email="test@gmail.com";
		assertNotNull(email);
		user.setEmail(email);
		usernameAndPasswords.put("email",email);
		System.out.println("set the email !");
	}
	
	@Test
	void getEmail() {
		user.getEmail();
		System.out.println("get the email !");
	}
	
	@Test
	void setOthervalues() {
		user.setOtp("ofijwgflknoiregjoierlk");
		user.setIs_comformed(0);
		user.setIs_loged(0);
		user.setRole(1);
		System.out.println("set other variables !");
	}
	
	@Test 
	void getOthervalues(){
		user.getOtp();
		user.getIs_comformed();
		user.getRole();
		user.getIs_loged();
		System.out.println("get other variables ");
	}
	
	// test the save method of the userDao..
	
	/**
	 * @return 
	 * 
	 */
	@Test
	void testSaveDao() {
		System.out.println("dao class save method testing ..");
		User user=new User();
		user.setId(1L);
		user.setUser_name("Gayan");
		user.setPassword("123");
		user.setEmail("test@gmail.com");
		user.setIs_comformed(0);
		user.setIs_loged(1);
		user.setRole(1);
		
	 	User user1=(User) (when(userDao.save(user)).thenReturn(user.getId()));
		assertEquals(user.getId(),(when(userDao.save(user)).thenReturn(user.getId())));
	} 
	
	// test the list method of UserDao ..
	
	@Test
	void testList() {
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
	

	@AfterAll
	static void end() {
		user=null;
		System.out.println("user will distroyed !");
	}


}
