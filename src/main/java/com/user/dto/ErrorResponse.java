package com.user.dto;

import lombok.Data;

@Data
public class ErrorResponse {
	
	private int value;
	private String message;
	
	public ErrorResponse(Integer value, String message) {
		this.value = value;
		this.message = message;
	}

}
