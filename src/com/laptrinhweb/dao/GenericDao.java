package com.laptrinhweb.dao;

import java.util.ArrayList;

import com.laptrinhweb.mapper.Rowmapper;


public interface GenericDao<T> {
	//doi tuong tra ve the t 
	// string cau lenh sql 
	//
 <T> ArrayList<T> query(String sql,Rowmapper<T>rowmapper,Object...parameters);
 void update (String sqlString , Object...parameters);
 Long insert(String sqlString , Object...parameters);
 void delete(String sqlString ,Object...parameters);
}
