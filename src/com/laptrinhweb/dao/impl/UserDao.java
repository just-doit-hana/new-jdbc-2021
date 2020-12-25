package com.laptrinhweb.dao.impl;

import java.util.List;

import com.laptrinhweb.dao.IUserDao;
import com.laptrinhweb.mapper.UserMapper;
import com.laptrinhweb.model.UserModel;

public class UserDao extends AbstractDao<UserModel> implements IUserDao {



	@Override
	public UserModel finByUserNameAndPasswordAndStatus(String userName, String password, Integer status)
		{
		List<UserModel> users = null;
		try {
			StringBuilder sql = new StringBuilder("SELECT * FROM user AS u");
			sql.append(" INNER JOIN role AS r ON r.id = u.roleid");
			sql.append(" WHERE username = ? AND password = ? AND status = ?");
	
			users = query(sql.toString(), new UserMapper(), userName, password, status);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return users.isEmpty() ? null : users.get(0);
		
	}

}
