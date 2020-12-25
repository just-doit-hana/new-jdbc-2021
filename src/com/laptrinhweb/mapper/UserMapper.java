package com.laptrinhweb.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.laptrinhweb.model.NewModel;
import com.laptrinhweb.model.RoleModel;
import com.laptrinhweb.model.UserModel;



public class UserMapper implements Rowmapper<UserModel> {

	@SuppressWarnings("unused")
	@Override
	public UserModel mapRow(ResultSet resultSet) {
		// TODO Auto-generated method stub
		
		UserModel users = new UserModel();
		try {
			UserModel user = new UserModel();
			user.setId(resultSet.getLong("id"));
			user.setUserName(resultSet.getString("username"));
			user.setFullName(resultSet.getString("fullname"));
			user.setPassword(resultSet.getString("password"));
			user.setStatus(resultSet.getInt("status"));
			try {
				RoleModel role = new RoleModel();
				role.setCode(resultSet.getString("code"));
				role.setName(resultSet.getString("name"));
				user.setRole(role);
			
			} catch (Exception e) {
				System.out.print(e.getMessage());
			}
			return user;
		} catch (SQLException e) {
			return null;
		}	
	

	}

}
