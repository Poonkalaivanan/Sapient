package com.sapient.login.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sapient.demo.dto.JwtRequest;
import com.sapient.demo.dto.JwtResponse;
import com.sapient.demo.service.JwtUserDetailsService;
import com.sapient.demo.util.JwtTokenUtil;

@RestController
@CrossOrigin
@RequestMapping("/login")
public class LoginController {

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Autowired
	private JwtUserDetailsService userDetailsService;
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {

	final UserDetails userDetails = userDetailsService
	.loadUserByUsername(authenticationRequest.getUsername());

	if(!(userDetails.getPassword().equals(authenticationRequest.getPassword()))) throw new Exception("Invalid User");
	final String token = jwtTokenUtil.generateToken(userDetails);

	
	return ResponseEntity.ok(new JwtResponse(token));
	}
	
	@RequestMapping(value="/getUserDtls")
	public UserDetails getUserDtls(@RequestHeader("Authorization") String authToken){
		String userName = jwtTokenUtil.getUsernameFromToken(authToken.substring(7));
		final UserDetails userDetails = userDetailsService
				.loadUserByUsername(userName);
		return userDetails;
}
}