package com.user.service;

import java.util.List;

import com.user.dto.PasswordReseetRequest;
import com.user.dto.RegisterRequest;
import com.user.model.User;
import com.user.role.Role;

public interface UserService {

	User registeruser(RegisterRequest request);
	
	User updateuser(Long id, RegisterRequest request);
	
	User passwordreset(PasswordReseetRequest request);
	
	User findByIdandRole(Long id, Role role);
	User findByname(String username);
	
	
	List<User> fetch(Role role);
	
	void deleteByIdandRole(Role role, long id);
	
	
}
