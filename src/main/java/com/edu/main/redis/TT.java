package com.edu.main.redis;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.edu.main.bean.User;
import com.google.gson.Gson;
import com.google.gson.reflect.*;

/**
 * 
 * @description     redis测试
 * @author          lujiawei
 * @data            2016年12月4日 下午2:48:57
 * @version         v1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
@Transactional
public class TT {
	
	@Autowired
	private IRedisUtils redisUtils;
	
	@Test
	public void test(){
		/*redisUtils.put("name", "lujiawei");
		System.out.println(redisUtils.get("name"));
		redisUtils.exec();
		System.out.println(redisUtils.get("name"));*/
		
		User user1 = new User("1231", "1", new Date(), "广州市海珠区1", "1231");
		User user2 = new User("1232", "2", new Date(), "广州市海珠区2", "1232");
		User user3 = new User("1233", "3", new Date(), "广州市海珠区3", "1233");
		User user4 = new User("1234", "4", new Date(), "广州市海珠区4", "1234");
		
		List<User> userList = new ArrayList<User>();
		userList.add(user1);
		userList.add(user2);
		userList.add(user3);
		userList.add(user4);
		
		redisUtils.put("userList", userList);
		
		redisUtils.exec();
		
		List<User> userListRedis = new Gson().fromJson(redisUtils.get("userList"), new TypeToken<List<User>>() {}.getType());
		
		for(User u:userListRedis){
			System.out.println(u.getUsername() + " = "+u.getAddress());
		}
	}
	
}
