package com.jcs.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.jcs.model.*;
import com.jcs.util.HibernateUtil;

public class BoxService {

	private EntityManager entityManager;

	public List<Claim> dummypushClaim() {

		List<Claim> claim = new ArrayList<Claim>();
		Set<Vehicle> vehicle = new HashSet<Vehicle>();

		Claim c = new Claim();
		Vehicle v = new Vehicle();

		c.setClaimID("cllaim new");
		
		v.setVin("vinno");
		

		vehicle.add(v);
		claim.add(c);

		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		
		try {
			session.save(v);
			session.save(c);
			session.getTransaction().commit();
			System.out.println("dummy data pushed at claim ");
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		

		return claim;
	}

	public List<User> dummypush() {

		User usr = new User();
		UserInfo usrinfo = new UserInfo();
		/*
		 * Claim claim = new Claim(); List<Claim> c = new ArrayList<Claim>();
		 */
		// claim.setClaiminfo("i am a claim");

		usr.setUserEmail("bushan1891@gmail.com");
		usr.setUserinfo(usrinfo);
		usr.setUserKey("password");
		usr.setUserName("nagendra");
		usr.setUserType("Agent");
		// usr.setClaims(c);

		/*
		 * claim.setUserID(usr.getUserID()); c.add(claim);
		 */

		usrinfo.setAddress("9135 judicial drive apt 3132");
		usrinfo.setEmail("bushan1891@gmail.com");
		usrinfo.setPhone(858760000);
		usrinfo.setTitle("developer");

		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		List<User> list = new ArrayList<User>();
		list.add(usr);
		try {
			// session.save(claim);
			session.save(usrinfo);
			session.save(usr);
			session.getTransaction().commit();
			System.out.println("dummy data pushed");
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println();
		return list;

	}

	public List<User> fetchAll() throws Exception {

		List<User> user = new ArrayList<User>();
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		try {
			user = session.createQuery("From User").list();
			session.getTransaction().commit();
			session.close();
		}

		catch (Exception e) {
			e.printStackTrace();
		}

		//System.out.println(user.get(0).getUserName());
		// System.out.println(user.get(1).getUserName());

		// System.out.println(user.get(0).getUserName());

		return user;

	}

	public User fetchone(String email) throws Exception {

		List<User> users = fetchAll();

		for (User usr : users) {
			System.out.println(usr.getUserEmail() + email);
			if (usr.getUserEmail().equals(email))

				return usr;
		}

		return null;

	}
	
	
	public List<Claim> fetchAllClaim() throws Exception {

		List<Claim> claim = new ArrayList<Claim>();
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		try {
			claim = session.createQuery("From Claim").list();
			session.getTransaction().commit();
			session.close();
		}

		catch (Exception e) {
			e.printStackTrace();
		}

		 System.out.println(claim.get(0).getClaimID());


		return claim;

	}	
	
	
	public Claim createClaim(Claim claim) throws Exception{
		
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		try {
			
			session.save(claim);
			session.getTransaction().commit();
			System.out.println(" request to push claim has been pushed ");
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return claim;
	}
	
	
	public Vehicle createVehicle(Vehicle vehicle) throws Exception{
		
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		try {
			
			session.save(vehicle);
			session.getTransaction().commit();
			System.out.println(" request to push Vehicle has been pushed ");
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return vehicle;
	}
	
	

}
