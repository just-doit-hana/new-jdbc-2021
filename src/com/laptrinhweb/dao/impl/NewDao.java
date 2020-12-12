package com.laptrinhweb.dao.impl;
 

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.laptrinhweb.dao.INewDao;
import com.laptrinhweb.mapper.NewMapper;
import com.laptrinhweb.model.CategoryModel;
import com.laptrinhweb.model.NewModel;

public class NewDao  extends AbstractDao<NewModel> implements INewDao {

	
	@Override
	public ArrayList<NewModel> findByCategoryId(Long CategoryID) {
		
		  List<NewModel> list = new ArrayList<NewModel>(); 
		   // neu trong day co bao nhieu tham so thi ben duoi phan return cung tra ve bay nhieu tham so 
	    	String sqlString = "select *From news  where categoryid =?;";
			return  query(sqlString, new NewMapper(), CategoryID);
	    	
	
	}
}
