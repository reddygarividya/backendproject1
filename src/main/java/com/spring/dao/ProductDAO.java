
package com.spring.dao;

import java.util.List;

import com.spring.model.Product;

public interface ProductDAO
{
	
	public void insertProduct(Product product);
	public List<Product> retrieve();
	public Product findByPID(int pid);
	public void deleteProd(int pid);
	public void updateProd(Product prod);
	public List<Product> getProductByCategoryID(int cid);



}  


