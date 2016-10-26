package com.uow.cs.gpthirteen.bean;

public class LoginBean {
	
	private String username;
	private String password;
	private int user_id;
	private String name;	
	
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getUser_ID() {
		return user_id;
	}
	public void setUser_ID(int user_id) {
		this.user_id = user_id;
	}
	public String getRole_Name() {
		return name;
	}
	public void setRole_Name(String name) {
		this.name = name;
	}
}
