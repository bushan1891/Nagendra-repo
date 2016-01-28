package com.jcs.service;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
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

		return user;

	}

	public User fetchone(String email) throws Exception {

		// List<User> users = fetchAll();
		//
		// for (User usr : users) {
		// System.out.println(usr.getUserEmail() + email);
		// if (usr.getUserEmail().equals(email))
		//
		// return usr;
		// }

		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		try {
			String hql = "from User u where u.UserEmail = :email";
			List<User> result = session.createQuery(hql).setParameter("email", email).list();

			return result.get(0);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;

	}

	public List<Claim> fetchAllClaim(String email) throws Exception {

		User usr = fetchone(email);

		List<Claim> claimlist = new ArrayList<Claim>();

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

		// filtering claims with respect to the user claim can be done on db
		// side

		for (Claim c : claim) {
			int x = Character.getNumericValue(c.getClaimID().charAt(0));
			if (x == usr.getUserID()) {
				claimlist.add(c);
			}
		}

		return claimlist;

	}

	public Claim createClaim(Claim claim, String email) throws Exception {

		// assign claim id as the user id

		User usr = fetchone(email);
		DateFormat df = new SimpleDateFormat("dd/MM/yy hh/mm/ss");
		Date date = new Date(0);
		String str = usr.getUserID() + "claim" + claim.getClaimID();

		claim.setClaimID(str);
		claim.setAssignedAdjuster(2);
		claim.setStatus("pending");
		claim.setReportedDate(date);

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

	public Vehicle createVehicle(Vehicle vehicle, String email) throws Exception {

		User usr = fetchone(email);

		// vehicle.setId(usr.getUserID());

		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		try {

			String hql = "from Claim c where c.Vehicle = :vin";
			List<Claim> result = session.createQuery(hql).setParameter("vin", vehicle.getVin()).list();

			vehicle.setClaimNumber(result.get(0).getClaimID());

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
