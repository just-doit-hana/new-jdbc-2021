package com.laptrinhweb.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.laptrinhweb.model.NewModel;
import com.laptrinhweb.model.RoleModel;
import com.laptrinhweb.model.UserModel;



public class UserMapper implements Rowmapper<UserModel> {

	@Override
	public UserModel mapRow(ResultSet rs) {
		// TODO Auto-generated method stub
		
		UserModel users = new UserModel();
		try {
			users.setId(rs.getLong("id"));
			users.setUserName(rs.getString("userName"));
			users.setFullName(rs.getString("fullname"));
			users.setPassword(rs.getString("password"));
			users.setStatus(rs.getInt("status"));
			try {
				RoleModel role = new RoleModel();
				role.setCode(rs.getString("code"));
				role.setName(rs.getString("name"));
				users.setRole(role);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		
			return users;
		} catch (SQLException e) {
			return null;
		}
	

	}

}
