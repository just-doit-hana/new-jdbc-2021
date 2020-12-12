package com.laptrinhweb.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.laptrinhweb.model.CategoryModel;

public class CategoryMapper implements Rowmapper<CategoryModel> {

	@Override
	public CategoryModel mapRow(ResultSet rs) {
		// TODO Auto-generated method stub
		try {
			CategoryModel cate = new CategoryModel();
			cate.setCode(rs.getString("code"));
			 cate.setName(rs.getString("name"));
			 return cate;
		} catch (SQLException e) {
			// TODO: handle exception
			return null;
		}

	}

}
