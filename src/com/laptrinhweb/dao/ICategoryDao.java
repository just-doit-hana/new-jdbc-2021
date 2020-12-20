package com.laptrinhweb.dao;


import java.util.ArrayList;
import com.laptrinhweb.model.CategoryModel;

public interface ICategoryDao extends GenericDao<CategoryModel>{
 ArrayList<CategoryModel> findAll() throws ClassNotFoundException; 
}
   