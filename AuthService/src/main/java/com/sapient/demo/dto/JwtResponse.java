package com.sapient.demo.dto;

import java.io.Serializable;

public class JwtResponse implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6712195816918021532L;
	
	private final String jwttoken;

	public JwtResponse(String jwttoken) {
	this.jwttoken = jwttoken;
	}

	public String getToken() {
	return this.jwttoken;
	}
}
