package com.luv2code.springsecurity.demo.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.springsecurity.demo.entity.Role;

@Repository
public class RoleDaoImpl implements RoleDao {

	// need to inject the session factory
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Role findRoleByName(String theRoleName) {

		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		Role theRole = null;
		try {
			// now retrieve/read from database using name
			Query<Role> theQuery = currentSession.createQuery("from role where name=:rolename", Role.class);
			theQuery.setParameter("rolename", theRoleName);
			try {
				theRole = theQuery.getSingleResult();
			} catch (Exception e) {
				theRole = null;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return theRole;
	}
}
