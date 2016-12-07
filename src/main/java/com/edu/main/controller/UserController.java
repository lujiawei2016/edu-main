package com.edu.main.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.edu.main.bean.User;
import com.edu.main.redis.IRedisUtils;
import com.edu.main.service.IUserService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private IUserService userService;
	
	@Autowired
	private IRedisUtils redisUtils;

	@RequestMapping("/findAllUser")
	@RequiresPermissions("user:findAllUser")
	public String findAllUser(ModelMap modelMap){
		List<User> userList = new ArrayList<User>();
		try {
			userList = userService.findAllUser();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(userList);
		return "index";
	}
	
	@RequestMapping("/saveUser")
	public String saveUser(String username,String password){
		userService.saveUser(username, password);;
		System.out.println(redisUtils.get("name3"));
		return "0";
	}
	
	@RequestMapping("/login")
	public void login(String username,String password){
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken(username, password);
		try {
			subject.login(token);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
