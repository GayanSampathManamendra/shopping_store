package com.shoppingApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shoppingApp.model.Booking;
import com.shoppingApp.service.BookingService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class BookingController {

   @Autowired
   private BookingService bookingService;
   

   /*---Add new booking---*/
   @PostMapping("/booking")
   public ResponseEntity<?> save(@RequestBody Booking booking) {
      long id = bookingService.save(booking);
      System.out.println(id);
      return ResponseEntity.ok().body("New Booking has been saved with ID:" + id);
   }

   /*---Get a booking by id---*/
   @GetMapping("/booking/{id}")
   public ResponseEntity<Booking> get(@PathVariable("id") long id) {
      Booking booking = bookingService.get(id);
      return ResponseEntity.ok().body(booking);
   }

   /*---get all bookings---*/
   @GetMapping("/booking")
   public ResponseEntity<List<Booking>> list() {
      List<Booking> bookings = bookingService.list();
      return ResponseEntity.ok().body(bookings);
   }

   /*---Update a booking by id---*/
   @PutMapping("/booking/{id}")
   public ResponseEntity<?> update(@PathVariable("id") long id, @RequestBody Booking booking) {
      bookingService.update(id, booking);
      return ResponseEntity.ok().body("Booking has been updated successfully.");
   }

   /*---Delete a booking by id---*/
   @DeleteMapping("/booking/{id}")
   public ResponseEntity<?> delete(@PathVariable("id") long id) {
      bookingService.delete(id);
      return ResponseEntity.ok().body("Booking has been deleted successfully.");
   }
}