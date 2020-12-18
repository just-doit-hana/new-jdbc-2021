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
			return news;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

}
