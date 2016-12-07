package com.edu.main.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.edu.main.bean.User;
import com.edu.main.dao.IUserDao;
import com.edu.main.service.IUserService;


@Service("userService")
@Transactional
public class UserService implements IUserService {
	
	@Autowired
	private IUserDao userDao;

	@Override
	public List<User> findAllUser() {
		return userDao.findAllUser();
	}

	@Override
	public void saveUser(String username, String password) {
		User user1 = new User();
		
		user1.setUsername(username);
		user1.setPassword(password);
		user1.setBirthday(new Date());
		user1.setAddress("广东省韶关市翁源县");
		user1.setSex("1");
		userDao.saveUser(user1);
		
		saveUser2();
	}
	
	public void saveUser2(){
		int i = 1/0;
		User user2 = new User();
		user2.setUsername("2");
		user2.setPassword("2");
		user2.setBirthday(new Date());
		user2.setAddress("广东省韶关市翁源县"+"2");
		user2.setSex("2");
		userDao.saveUser(user2);
	}
	
}
