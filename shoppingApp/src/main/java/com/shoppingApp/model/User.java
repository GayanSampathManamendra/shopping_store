package com.shoppingApp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;

@Entity(name = "User")
@Table(
        indexes = {
            @Index(columnList = "otp")
        }
      )
public class User {
	
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long id;
	 
	 @Column(unique = true, length = 32)
	 private String user_name;
	 
	 private String password;
	 
	 @Column(unique = true, length = 32)
	 private String email;
	 
	 private int role;
	 private String otp;
	 private int is_comformed;
	 private int is_loged;
	 
	 
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getRole() {
		return role;
	}
	public void setRole(int role) {
		this.role = role;
	}
	public String getOtp() {
		return otp;
	}
	public void setOtp(String otp) {
		this.otp = otp;
	}
	public int getIs_comformed() {
		return is_comformed;
	}
	public void setIs_comformed(int is_comformed) {
		this.is_comformed = is_comformed;
	}
	public int getIs_loged() {
		return is_loged;
	}
	public void setIs_loged(int is_loged) {
		this.is_loged = is_loged;
	}
	 
	
	
}
