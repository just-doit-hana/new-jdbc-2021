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

	
	// thao tac  
	// JDBC cung cap cho ta mot cai transaction 
	// dau tien thi se open transaction 
	// them , xoa , sua 
	 // close transaction 
	
	
	//Su khac nhau giua prepared  statement (1) va statement (2) 
	// 1 thi co the truyen tham so truc tieps trong cau sql 
	 // 2 thi khong cos the lam dc  dieu do
	
	@Override
	public Long save(NewModel news) {
		// TODO Auto-generated method stub
//		ResultSet resultSet = null ;
//		Long id  = null ;
//		Connection connection = myConnection();
//		PreparedStatement statement =null;
//		try {
     String	sql = "INSERT INTO news (title,content,categoryid) values(?,?,?);";
		
			return insert(sql, news.getTitle(),news.getContents(),news.getCategoryId());
			
			
//			connection.setAutoCommit(false);
//		    statement = connection.prepareStatement(sql,statement.RETURN_GENERATED_KEYS); // get genrated key 
//		 	statement.setString(1, news.getTitle());
//			statement.setString(2, news.getContents());
//			statement.setLong(3, news.getCategoryId());
//			resultSet = statement.getGeneratedKeys(); // id o trong tat ca cac bang trong table  data no random  do do can su dung no 
//			// va trong database no generate bao nhieeu thi nay bay nhiu
//			statement.executeUpdate();
//			if (resultSet.next()) {
//				id= resultSet.getLong(1);
//			} 
//			connection.commit(); // co autocommit khi thuc khi  cac thao tac hoan tat thi moi  them vao database 
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			if ( connection!= null) {
//				try {
//					connection.rollback();  // neu them khong dung thi se rollback lai tu dau 
//				} catch (SQLException e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				}
//			}
//		}
//		finally {
//			if (connection != null) {
//				try {
//					connection.close();
//				} catch (SQLException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}
//			if (resultSet != null) {
//				try {
//					resultSet.close();
//				} catch (SQLException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}
//			if (statement != null) {
//				try {
//					statement.close();
//				} catch (SQLException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}
//		}
//		
//		return null;
	}

	
	// vi du finby cai gi do thi tra ve mot list 
	// con find one cai gi do thi tra ve 1 phan tu 
	@Override
	public NewModel findOne(Long id) {
		  
		   // neu trong day co bao nhieu tham so thi ben duoi phan return cung tra ve bay nhieu tham so 
	    	String sqlString = "select *From news  where id =?;";
	    	List<NewModel> news = query(sqlString, new NewMapper(), id);  // chung ta chi lay 1 thuoc tinh duy nhat thoi no nam o vi tri thu 0 trong list 
			return news.isEmpty() ? null :news.get(0);
	    	
		
	}

	@Override
	public void update(NewModel update) {
		// TODO Auto-generated method stub
		// nhieu qua cat chuoi nen dung string buider
		
		StringBuilder sql = new StringBuilder( "Update news Set title =? , thumbnail=?,");
		sql.append("shortdescription=?,content=?,categoryid=?,");
		sql.append("createddate=?,createdby=? where id =?;");
		update(sql.toString(),update.getTitle(),update.getThumnail(),update.getShortDescription(),
				update.getContents(),update.getCategoryId(),
				update.getCreatedDate(),update.getCreatedBy(),update.getId());
	}


	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub
		String sql = "Delete From news Where id=?";
		update(sql,id);
		
	}
}
