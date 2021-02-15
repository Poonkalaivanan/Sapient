package com.sapient.demo.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.sapient.demo.dto.JwtRequest;
import com.sapient.demo.repository.userDtlsRepository;

@Component
public class JwtUserDetailsService implements UserDetailsService{
	
	@Autowired
	private userDtlsRepository usrRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		JwtRequest usrDtls = usrRepo.findUserByName(username);
		GrantedAuthority auth = new SimpleGrantedAuthority(usrDtls.getRole());
		Collection<GrantedAuthority> authCol = new ArrayList<GrantedAuthority>();
		authCol.add(auth);
		UserDetails user = new User(usrDtls.getUsername(), usrDtls.getPassword(), true, true, true, true, authCol);
		return user;
	}

}
