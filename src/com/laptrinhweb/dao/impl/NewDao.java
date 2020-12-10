package com.laptrinhweb.dao.impl;
 

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.laptrinhweb.dao.INewDao;
import com.laptrinhweb.model.CategoryModel;
import com.laptrinhweb.model.NewModel;

public class NewDao implements INewDao {

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
	public ArrayList<NewModel> findByCategoryId(Long CategoryID) {
		
		  List<NewModel> list = new ArrayList<NewModel>(); 
		    Connection con = myConnection(); 
	    	String sqlString = "select *From news  where categoryid =?;";
	    	PreparedStatement pst =null;
	    	ResultSet rs =null;
		    if(con!=null) {

				try {
					  pst = con.prepareStatement(sqlString);
					  pst.setLong(1, CategoryID);
				      rs = pst.executeQuery();
			    	while (rs.next()) {
						NewModel news = new NewModel();
						news.setId(rs.getLong("id"));
						news.setTitle(rs.getString("title"));
						 list.add(news);
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
			return (ArrayList<NewModel>) list;
		}
	
	
}
