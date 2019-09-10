package com.shoppingApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shoppingApp.dao.BookingDao;
import com.shoppingApp.model.Booking;


@Service
@Transactional(readOnly = true)
public class BookingServiceImp implements BookingService {

   @Autowired
   private BookingDao bookingDao;

   @Transactional
   @Override
   public long save(Booking booking) {
      return bookingDao.save(booking);
   }

   @Override
   public Booking get(long id) {
      return bookingDao.get(id);
   }

   @Override
   public List<Booking> list() {
      return bookingDao.list();
   }

   @Transactional
   @Override
   public void update(long id, Booking booking) {
      bookingDao.update(id, booking);
   }

   @Transactional
   @Override
   public void delete(long id) {
      bookingDao.delete(id);
   }

}
