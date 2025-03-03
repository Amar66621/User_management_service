package com.user.dto;

import com.user.role.Role;

import lombok.Data;

@Data
public class RegisterRequest {
	private String username;
	private String email;
	private String password;
	private String confirmpassword;
	private String gender;
	private String age;
	private String phonenumber;
	private Role role;
	
	public RegisterRequest() {}

}
