package com.user.dto;

import lombok.Data;

@Data
public class LoginResponse {
	private String message;
	
	public LoginResponse(String msg) {
		super();
		this.message = msg;
	}

}
