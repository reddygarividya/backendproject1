package com.spring.daoImpl;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.dao.UserDAO;
import com.spring.model.User;


@Repository
public class UserDAOImpl implements UserDAO
{
	public  UserDAOImpl(){}
 @Autowired
 SessionFactory sessionFactory;
 
 @Autowired
 public UserDAOImpl(SessionFactory sessionFactory)
 {
	 super();
	 this.sessionFactory=sessionFactory;
	 
 }

 public boolean insertUser(User user)
 {
	Session session= sessionFactory.openSession(); 
	 
	session.beginTransaction();
	session.save(user);
	session.getTransaction().commit();
	return true;
 }
 
}
