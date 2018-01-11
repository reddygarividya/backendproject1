package com.spring.daoImpl;

import java.util.List;


import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.dao.CategoryDAO;
import com.spring.model.Category;

@Repository
@Service
public class CategoryDAOImpl implements CategoryDAO
{
	@Autowired
	SessionFactory sessionFactory;
	
	
	public CategoryDAOImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory = sessionFactory;
	}
	public void insertCategory(Category category)
	{
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		session.persist(category);
		session.getTransaction().commit();
		
	}
	public List<Category> retrieve()
	{
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		List<Category>li=session.createQuery("from Category").list();
		session.getTransaction().commit();
		return li;
	}
	public Category findByCatId(int cid)
	{
		Session session=sessionFactory.openSession();
		Category c=null;
		try
		{
			session.beginTransaction();
			c= session.get(Category.class, cid);
			session.getTransaction().commit();
		}
		catch(HibernateException e)
		{
			System.out.println(e.getMessage());
			session.getTransaction().rollback();
		}
		return c;
	}
	
	public void deleteCat(int cid) 
	{
			Session session=sessionFactory.openSession();
			session.beginTransaction();
			Category c=(Category)session.get(Category.class,cid);
			session.delete(c);
			session.getTransaction().commit();
		}
	}

