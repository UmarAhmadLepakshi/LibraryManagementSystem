package com.example.demo.payload;

public class UsersDto {
	int id;
	String userEmail;
	String userPasswd;
	
	public UsersDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UsersDto(int id, String userEmail, String userPasswd) {
		super();
		this.id = id;
		this.userEmail = userEmail;
		this.userPasswd = userPasswd;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserPasswd() {
		return userPasswd;
	}

	public void setUserPasswd(String userPasswd) {
		this.userPasswd = userPasswd;
	}

	@Override
	public String toString() {
		return "UsersDto [id=" + id + ", userEmail=" + userEmail + ", userPasswd=" + userPasswd + "]";
	}
}
