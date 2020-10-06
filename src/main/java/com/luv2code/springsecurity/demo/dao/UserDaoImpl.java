package com.luv2code.springsecurity.demo.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.springsecurity.demo.entity.User;

@Repository
public class UserDaoImpl implements UserDao {

	// need to inject the session factory
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public User findByUserName(String theUserName) {
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		User theUser = null;

		// now retrieve/read from database using username
		try {
			Query<User> theQuery = currentSession.createQuery("from user u where u.username = :uName", User.class);
			theQuery.setParameter("uName", theUserName);
			try {
				theUser = theQuery.getSingleResult();
			} catch (Exception e) {
				theUser = null;
			}
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return theUser;
	}

	@Override
	public void save(User theUser) {
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// create the user ... finally LOL
		currentSession.saveOrUpdate(theUser);
	}

}
