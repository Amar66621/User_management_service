package com.user.centralized;

import java.nio.file.AccessDeniedException;
import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.user.dto.ErrorResponse;
import com.user.exception.ErrorHandling;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class GloballyHandler {
	
	@ExceptionHandler(value = ErrorHandling.class)
	@ResponseStatus
	public @ResponseBody ErrorResponse handleException(Exception e) {
		return new ErrorResponse(HttpStatus.CONFLICT.value(), e.getMessage());
	}
	
	
//	 @ExceptionHandler(AccessDeniedException.class)
//	    public ResponseEntity<Map<String, Object>> handleAccessDeniedException(AccessDeniedException ex, HttpServletRequest request) {
//	        Map<String, Object> response = new LinkedHashMap<>();
//	        response.put("timestamp", LocalDateTime.now());
//	        response.put("status", HttpStatus.FORBIDDEN.value());
//	        response.put("error", "Forbidden");
//	        response.put("message", "You do not have permission to access this resource.");
//	        response.put("path", request.getRequestURI());
//
//	        return new ResponseEntity<>(response, HttpStatus.FORBIDDEN);
//	    }

}
