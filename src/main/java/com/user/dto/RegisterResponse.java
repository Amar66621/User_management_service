package com.user.dto;

import com.user.role.Role;

import lombok.Data;

@Data
public class RegisterResponse {
	
	private Long id;
	private String username;
	private String email;
	private String password;
	private String age;
	private String gender;
	private String phonenumber;
	private String message;
	private String status;
	private Role role;
}
