package com.shoppingApp.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.shoppingApp.model.Booking;

@Repository
public class BookingDaoImp implements BookingDao {

   @Autowired
   private SessionFactory sessionFactory;

   @Override
   public long save(Booking booking) {
      sessionFactory.getCurrentSession().save(booking);
      return booking.getId();
   }

   @Override
   public Booking get(long id) {
      return sessionFactory.getCurrentSession().get(Booking.class, id);
   }

   @Override
   public List<Booking> list() {
      List<Booking> list = sessionFactory.getCurrentSession().createQuery("from Booking").list();
      return list;
   }

   @Override
   public void update(long id, Booking booking) {
      Session session = sessionFactory.getCurrentSession();
      Booking booking2 = session.byId(Booking.class).load(id);
      booking2.setCustomer_id(booking.getCustomer_id());
      booking2.setCustomer_name(booking.getCustomer_name());
      booking2.setAddress(booking.getAddress());
      booking2.setCity(booking.getCity());
      session.flush();
   }

   @Override
   public void delete(long id) {
      Booking booking = sessionFactory.getCurrentSession().byId(Booking.class).load(id);
      sessionFactory.getCurrentSession().delete(booking);
   }

}
