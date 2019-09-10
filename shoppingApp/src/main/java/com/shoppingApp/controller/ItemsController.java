package com.shoppingApp.controller;

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

import com.shoppingApp.model.Items;
import com.shoppingApp.service.ItemsService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class ItemsController {
	
	@Autowired
	private ItemsService itemsService;
	
	// register a new item
	
	@PostMapping("/item/register")
	public Items save(@RequestBody Items item){
		long id=itemsService.save(item);
		return item;
	}
	
	// view the items for given category ..
	
	@GetMapping("/items/show/{item_category}")
	public List<Items> getItemsFormGivenCategory(@PathVariable("item_category") String item_category){
		return itemsService.getItems(item_category);
	}
	
	
	// show the selected item..
	
	@GetMapping("/item/show/{id}")
	public Items getSelectedItem(@PathVariable("id") long id) {
		return itemsService.get(id);
	}
	
	@DeleteMapping("/item/delete/{id}")
	public ResponseEntity<?> removeFromStore(@PathVariable("id") long id) {
		itemsService.delete(id);
		return ResponseEntity.ok().body("remove item from cart with id :"+id);
		
	}


}
