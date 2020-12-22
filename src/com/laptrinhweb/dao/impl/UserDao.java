package com.laptrinhweb.dao.impl;

import java.util.List;

import com.laptrinhweb.dao.IUserDao;
import com.laptrinhweb.mapper.UserMapper;
import com.laptrinhweb.model.UserModel;

public class UserDao extends AbstractDao<UserModel> implements IUserDao {

	@Override
	public UserModel finByUserNameAndPasswordAndStatus(String userName, String password, Integer status) {
		 
    	StringBuilder sql =  new StringBuilder("select *From user u ");
    	sql.append("inner join role r on r.id =i.roleid");
    	sql.append("where username =? and password =?and status =?;");
    	try {
			List<UserModel> users = query(sql.toString(), new UserMapper() , userName,password,status);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
//        return users.isEmpty()?null:users.get(0);
    	return null ;
	}

}
