package com.edu.main.service;

import java.util.List;

import com.edu.main.bean.User;

public interface IUserService {

	public List<User> findAllUser();
	
	public void saveUser(String username,String password);
}
