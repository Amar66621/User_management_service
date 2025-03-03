package com.user.dto;

import lombok.Data;

@Data
public class PasswordReseetRequest {
	
	private String email;
	private String newpassword;
	private String confirmpassword;

}
