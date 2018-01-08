package com.spring.daoImpl;

import java.util.List;


import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.spring.dao.ProductDAO;
import com.spring.model.Product;

@Repository
public class ProductDAOImpl implements ProductDAO
{
	public  ProductDAOImpl(){}
	
	@Autowired
	SessionFactory sessionFactory;
	
	public ProductDAOImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}

	
	@Transactional
	public void insertProduct(Product product)
	{
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.saveOrUpdate(product);
		session.getTransaction().commit();
		
	}
	
	public List<Product> retrieve()
	{
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		List<Product> li=session.createQuery("from Product").list();
		session.getTransaction().commit();
		return li;
	}

	@Transactional
	 public Product findByPID(int pid) 
	{
		Session session=sessionFactory.openSession();
		Product p=null;
		try
		{
			session.beginTransaction();
			  p= session.get(Product.class, pid); 
			session.getTransaction().commit();
			
		}
		catch(HibernateException e)
		{
			System.out.println(e.getMessage());
			session.getTransaction().rollback();
		}
		return p; 
	}



	public Product findByPID() {
		return null;
	}
public List<Product> getProdByCatId(int cid)
{
	Session session=sessionFactory.openSession();
	List<Product> prod=null;
	try {
		session.beginTransaction();
		prod=session.createQuery("from Product where cid=" +cid).list();
		session.getTransaction().commit();
	} catch(Exception e)
	{
		e.printStackTrace();
		session.getTransaction().rollback();
		
	}
	return prod;
	
}


	
	 


 
	
} 
