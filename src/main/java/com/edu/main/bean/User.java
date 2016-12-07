package com.edu.main.bean;

import java.util.Date;

public class User {

	private int id;
	
	private String username;
	
	private String sex;
	
	private Date birthday;
	
	private String address;
	
	private String password;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public User() {
		super();
	}

	public User(String username, String sex, Date birthday, String address, String password) {
		super();
		this.username = username;
		this.sex = sex;
		this.birthday = birthday;
		this.address = address;
		this.password = password;
	}
	
}
