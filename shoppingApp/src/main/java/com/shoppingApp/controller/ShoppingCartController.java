package com.shoppingApp.controller;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shoppingApp.model.Cart;
import com.shoppingApp.model.Items;
import com.shoppingApp.model.Payment;
import com.shoppingApp.service.CartService;
import com.shoppingApp.service.ItemsService;
import com.shoppingApp.service.PaymentService;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("/api")
public class ShoppingCartController {
	
	@Autowired
	private CartService cartService;
	
	@Autowired
	private ItemsService itemsService;
	
	@Autowired
	private PaymentService paymentService;
	
	
	// add to new item to cart
	
	@PostMapping("/item/addToCart")
	public ResponseEntity<?> save(@RequestBody Cart cart){
		long id=cartService.save(cart);
		return ResponseEntity.ok().body("add item to cart with id : "+id);
	}
	
	// get the all the items form given customer's cart..
	
	@GetMapping("/show/cart/{customer_id}")
	public  List<Items> getCartItemsOfGivenCustomer(@PathVariable("customer_id") long customer_id){
		
		//get all the items ids from particular cart..
		List<Cart> cart_items=cartService.getCartItemsId(customer_id);
		List cart_items_info=new ArrayList();
		
		for(int i=0;i<cart_items.size();i++) {
			if(cart_items.get(i).getIs_payed()==0) {
				cart_items_info.add(itemsService.get(cart_items.get(i).getOrder_id()));
				//System.out.println(itemsService.get(cart_items.get(i).getOrder_id()));
			}
			
		}
		
		return cart_items_info;
		
	}
	
	@GetMapping("/show/items/{suplier_id}")
	public  List<Items> getItems(@PathVariable("suplier_id") long suplier_id){
		
		//get all the items ids from particular cart..
		List<Items> supplier_items=itemsService.getSupplierItems(suplier_id);
				
		return supplier_items;
		
	}
	
	
	// remove item from cart..
	
	@DeleteMapping("/item/remove/{id}")
	public ResponseEntity<?> removeFromCart(@PathVariable("id") long id) {
		cartService.delete(id);
		return ResponseEntity.ok().body("remove item from cart with id :"+id);
		
	}
	
	@PostMapping("/item/buy/pay")
	public ResponseEntity<?> payment(@RequestBody Payment payment) throws NoSuchAlgorithmException{
		System.out.println("order id : "+payment.getOrder_id());
		System.out.println("amount : "+payment.getAmount());
		payment.setOrder_id(getMD5(payment.getOrder_id()));
		payment.setAmount(getMD5(payment.getAmount()));
		paymentService.save(payment);
		
		return ResponseEntity.ok().body("ok");
		
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
		
	

}
