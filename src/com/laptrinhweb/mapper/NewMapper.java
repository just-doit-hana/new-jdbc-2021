package com.laptrinhweb.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.laptrinhweb.model.NewModel;



public class NewMapper implements Rowmapper<NewModel> {

	@Override
	public NewModel mapRow(ResultSet rs) {
		// TODO Auto-generated method stub
		
		try {
			NewModel news = new NewModel();
			news.setId(rs.getLong("id"));
			news.setTitle(rs.getString("title"));
			news.setContents(rs.getString("content"));
			news.setCategoryId(rs.getLong("categoryid"));
			news.setThumnail(rs.getString("thumbnail"));
			news.setShortDescription(rs.getString("shortdescription"));
			news.setCreatedDate(rs.getTimestamp("createddate"));
			news.setCreatedBy(rs.getString("createdby"));
			if (rs.getTimestamp("modifieddate")!=null) {
				news.setModifiedDate(rs.getTimestamp("modifieddate"));
			}// update moi co maay cai nay 
			if (rs.getTimestamp("modifiedby")!=null) {
				news.setModifiedBy(rs.getString("modifiedby"));
			}
			return news;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

}
