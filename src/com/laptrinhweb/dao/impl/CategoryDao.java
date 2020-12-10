package com.laptrinhweb.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.laptrinhweb.dao.ICategoryDao;
import com.laptrinhweb.model.CategoryModel;

public class CategoryDao implements ICategoryDao {
	public  Connection myConnection() {
		Connection con=null;
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jspservletjdbc", "root","Quynh@822000");
		} catch (Exception e) {
			// TODO: handle exception
		}
		return con;
		
	}
	
	@Override
	public ArrayList<CategoryModel> findAll()  {
	    List<CategoryModel> list = new ArrayList<CategoryModel>(); 
	    Connection con = myConnection(); 
    	String sqlString = "Select *From category;";
    	PreparedStatement pst =null;
    	ResultSet rs =null;
	    if(con!=null) {

			try {
				  pst = con.prepareStatement(sqlString);
			      rs = pst.executeQuery();
		    	while (rs.next()) {
					CategoryModel cate = new CategoryModel();
					cate.setCode(rs.getString("code"));
					 cate.setName(rs.getString("name"));
					 list.add(cate);
			} 
		    	if (con != null) {
					con.close();
				}
		    	if (pst != null) {
					pst.close();
				}
		    	if (rs != null) {
					rs.close();
				}
			}catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
	    			
	}
		return (ArrayList<CategoryModel>) list;
	}
}
	
	

