package com.edu.main.dao;

import java.util.List;

import com.edu.main.bean.User;

public interface IUserDao {

	public List<User> findAllUser();
	
	public void saveUser(User user);
}
