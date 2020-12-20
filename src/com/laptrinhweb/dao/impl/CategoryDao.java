package com.laptrinhweb.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.laptrinhweb.dao.ICategoryDao;
import com.laptrinhweb.mapper.CategoryMapper;
import com.laptrinhweb.model.CategoryModel;

public class CategoryDao extends AbstractDao<CategoryModel> implements ICategoryDao {
	
	@Override
	public ArrayList<CategoryModel> findAll() throws ClassNotFoundException  
	
		{
		    List<CategoryModel> list = new ArrayList<CategoryModel>(); 
			String sqlString = "Select *From category;";
			return query(sqlString, new CategoryMapper());
		}
	} 

	
	

