package com.user.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.user.model.User;
import com.user.repo.UserRepository;






@Service
public class CustomUserDetailService  implements UserDetailsService{
	
	@Autowired
	private UserRepository repo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		User user = repo.findByUsername(username).orElseThrow(()-> new UsernameNotFoundException("User not found with username"));
		
		 return new org.springframework.security.core.userdetails.User(
	                user.getUsername(),
	                user.getPassword(),
	                new ArrayList<>()
	        );
	}

}
