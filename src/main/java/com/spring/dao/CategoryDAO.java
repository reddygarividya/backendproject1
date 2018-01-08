package com.spring.dao;

import java.util.List;

import com.spring.model.Category;

public interface CategoryDAO 
{

	public void insertCategory(Category category);
	public Category findByCatId(int cid);
	public List<Category> retrieve();
} 
