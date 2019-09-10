package com.shoppingApp.controller;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.*;
import java.util.Properties;
import java.util.Random;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shoppingApp.model.User;
import com.shoppingApp.service.UserService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class UserController {
	
	@Autowired
	private UserService userService;
	//private User user;
	
	
	private String[] upper_letters= {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
	private String[] lower_letters= {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
	private String[] number= {"0","1","2","3","4","5","6","7","8","9"};
	private String Otp_code="";
	int i=1;
	
	/*-- signup new user -- */
	@PostMapping("/signup")
	
	public int save(@RequestBody User user) throws Exception{
		
		generateOtp();
		
		while(i>0) {
			if(check_otp(Otp_code)==true) {
				// set particular otp to user and save that user..
				System.out.println("this is an unique otp : "+Otp_code);
				user.setPassword(getMD5(user.getPassword()));
				user.setOtp(getMD5(Otp_code));
				try {
					long id=userService.save(user);
					// send email to particular user with otp code..
					// call send email function ..
					Otp_code="";
					return 1;
					
					
				}catch(Exception e) {
					System.out.println("Email Or User name already exits ..");
					Otp_code="";
					return 0;
					
				}
			}
			else {
				System.out.println("Otp there exites ..");
				Otp_code="";
				generateOtp();
				i++;
			}	
		}
		return 0;
	}
	
	// log the user..
	
	@GetMapping("/login")
	public User chekLogin(@RequestBody User user) throws NoSuchAlgorithmException {
		List<User> get_All_Users=userService.list();
		for(int i=0;i<get_All_Users.size();i++) {
			if((get_All_Users.get(i).getUser_name()).equals(user.getUser_name())) {
				if((get_All_Users.get(i).getPassword()).equals(getMD5(user.getPassword()))){
					System.out.println("success !");
					return get_All_Users.get(i);
				}
				else {
					System.out.println("incorect password !");
					return null;
				}
			}
		}
		System.out.println("incorrect username !");
		return null;
		
	}
	
	// validate the otp code ..
	
	@GetMapping("/user/loginAndSignup/otp/validation/{otp}")
	public User validate_otp(@PathVariable("otp") String otp) throws NoSuchAlgorithmException {
		return this.otpVarification(otp);
	}
	
	// varification code..
	
	public User otpVarification(String otp) throws NoSuchAlgorithmException {
		otp=getMD5(otp);
		System.out.println(otp);
		List<User> validated_user=userService.checkOtp(otp);
		if(validated_user.size()!=0) {
			validated_user.get(0).setIs_comformed(1);
			userService.update(validated_user.get(0).getId(), validated_user.get(0));
			return validated_user.get(0);
		}
		return null;
	}
	
	
	// encode the string using MD5 algo 
	public static String getMD5(String data) throws NoSuchAlgorithmException
    { 
		MessageDigest messageDigest=MessageDigest.getInstance("MD5");
        messageDigest.update(data.getBytes());
        byte[] digest=messageDigest.digest();
        StringBuffer sb = new StringBuffer();
        for (byte b : digest) {
            sb.append(Integer.toHexString((int) (b & 0xff)));
        }
        return sb.toString();
    }
	
	
	// generate 6 digit OTP code..
	public String generateOtp() {
		
		Otp_code=Otp_code.concat(upper_letters[new Random().nextInt(26)]);
		Otp_code=Otp_code.concat(number [new Random().nextInt(9)]);
		Otp_code=Otp_code.concat(lower_letters[new Random().nextInt(26)]);
		Otp_code=Otp_code.concat(upper_letters[new Random().nextInt(26)]);
		Otp_code=Otp_code.concat(number[new Random().nextInt(9)]);
		Otp_code=Otp_code.concat(lower_letters[new Random().nextInt(26)]);
		
		System.out.println(Otp_code);
		return Otp_code;
	}
	
	
	
	// check whether generated otp code already exits in db..
	@GetMapping("/check")
	public boolean check_otp(String otp) throws NoSuchAlgorithmException {
		
		if(userService.checkOtp(getMD5(otp)) == null ) {
			return false;
		}
		else {
			return true;
		}
	}
	
	
	// send email to customer with particular otp..
	
	public void send() throws MessagingException {
		String to = "gayansampathmanamendra@gmail.com";
	    String subject = "Online Shopping store varification code .";
	    String msg ="email text....";
	    final String from ="ucscgreenhouseiot@gmail.com";
	    final  String password ="ucsc@123";


	    Properties props = new Properties();  
	    props.setProperty("mail.transport.protocol", "smtp");     
	    props.setProperty("mail.host", "smtp.gmail.com");  
	    props.put("mail.smtp.auth", "true");  
	    props.put("mail.smtp.port", "465");  
	    props.put("mail.debug", "true");  
	    props.put("mail.smtp.socketFactory.port", "465");  
	    props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");  
	    props.put("mail.smtp.socketFactory.fallback", "false");  
	    Session session = Session.getDefaultInstance(props,  
	    new javax.mail.Authenticator() {
	       protected PasswordAuthentication getPasswordAuthentication() {  
	       return new PasswordAuthentication(from,password);  
	   }  
	   });  

	   //session.setDebug(true);  
	   Transport transport = session.getTransport();  
	   InternetAddress addressFrom = new InternetAddress(from);  

	   MimeMessage message = new MimeMessage(session);  
	   message.setSender(addressFrom);  
	   message.setSubject(subject);  
	   message.setContent(msg, "text/plain");  
	   message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));  

	   transport.connect();  
	   Transport.send(message);
	   System.out.println(message);
	   transport.close();
	   System.out.println("mail send !");
	   } 

	// logout the user..
	
	@PutMapping("/user/logout")
	public String logout(@RequestBody User user) {
		userService.update(user.getId(), user);
		return "logout";
	}
}	
	



