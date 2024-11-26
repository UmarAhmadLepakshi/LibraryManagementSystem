package com.example.demo.entites;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Users {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;
	
	@Column(nullable = false)
	String userEmail;
	
	@Column(nullable = false)
	String userPasswd;

	public Users() {
		super();
	}

	public Users(int id, String userEmail, String userPasswd) {
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
		return "Users [id=" + id + ", userEmail=" + userEmail + ", userPasswd=" + userPasswd + "]";
	}
}
