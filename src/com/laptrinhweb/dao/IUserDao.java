package com.laptrinhweb.dao;

import com.laptrinhweb.model.UserModel;

public interface IUserDao extends GenericDao<UserModel> {
UserModel finByUserNameAndPasswordAndStatus(String userName,String password,Integer status) throws ClassNotFoundException;
	
}
