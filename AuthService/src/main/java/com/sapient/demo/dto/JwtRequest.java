package com.sapient.demo.dto;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "userDetails")
public class JwtRequest implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7888636418057607660L;
	@Id
	private String id = null;
	
	private String username;
	private String password;
	private String role = null;
	
	public JwtRequest()
	{

	}
	public JwtRequest(String userName, String password, String role) {
		this.username = userName;
		this.password = password;
		this.role = role;
	}

	public JwtRequest(String username, String password) {
	this.setUsername(username);
	this.setPassword(password);
	}

	public String getUsername() {
	return this.username;
	}

	public void setUsername(String username) {
	this.username = username;
	}

	public String getPassword() {
	return this.password;
	}

	public void setPassword(String password) {
	this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

}
