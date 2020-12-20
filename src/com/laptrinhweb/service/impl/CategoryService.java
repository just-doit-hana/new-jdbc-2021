package com.laptrinhweb.service.impl;

import java.util.ArrayList;
import javax.inject.Inject;

//su dung java servlet weld
import com.laptrinhweb.dao.ICategoryDao;
import com.laptrinhweb.dao.impl.CategoryDao;
import com.laptrinhweb.model.CategoryModel;
import com.laptrinhweb.service.ICategoryService;

public class CategoryService implements ICategoryService {
	 @Inject
	private ICategoryDao categoryDao;
//   public CategoryService() {
//		categoryDao = new CategoryDao();
//	}
	@Override
	public ArrayList<CategoryModel> findAll(){
		try {
			return categoryDao.findAll();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
    
}
