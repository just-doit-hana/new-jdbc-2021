package com.laptrinhweb.service;


import com.laptrinhweb.model.UserModel;

public interface IUserService {
	UserModel finByUserNameAndPasswordAndStatus(String userName,String password,Integer status);
	
}
