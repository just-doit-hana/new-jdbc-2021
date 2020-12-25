package com.laptrinhweb.service.impl;

import javax.inject.Inject;

import com.laptrinhweb.dao.IUserDao;
import com.laptrinhweb.model.UserModel;
import com.laptrinhweb.service.IUserService;

public class UserService implements IUserService {
@Inject
private IUserDao userDao;
	@Override
	public UserModel finByUserNameAndPasswordAndStatus(String userName, String password, Integer status) throws ClassNotFoundException {
		return userDao.finByUserNameAndPasswordAndStatus(userName, password, status);
}
}

	

	
