package com.shoppingApp.testing;

import static org.junit.jupiter.api.Assertions.*;

import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Scanner;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.shoppingApp.controller.UserController;
import com.shoppingApp.model.User;

class userTesting {


	// creating the user object reference ..
	static User user=null;
	static HashMap<String, String> usernameAndPasswords = new HashMap<String, String>();
	
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
	
	
	@AfterAll
	static void end() {
		user=null;
		System.out.println("user will distroyed !");
	}


}
