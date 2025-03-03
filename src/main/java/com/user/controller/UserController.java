package com.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.user.dto.PasswordReseetRequest;
import com.user.dto.RegisterRequest;
import com.user.model.User;

import com.user.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/user")

public class UserController {
	
	@Autowired
	private UserService service;
	
	
	
	@PostMapping("/register")
	public ResponseEntity<User> register( @Valid @RequestBody RegisterRequest request){
		return ResponseEntity.ok(service.registeruser(request));
	}
	
	
	@PutMapping("/update/{id}")
	@PreAuthorize("hasAnyAuthority('STUDENT', 'TEACHER')")
	public ResponseEntity<User> update(@Valid @RequestBody RegisterRequest request, @PathVariable Long id){
		return ResponseEntity.ok(service.updateuser(id, request));
	}

	
	
	@PostMapping("/passwordreset")
	@PreAuthorize("hasAnyAuthority('STUDENT', 'TEACHER')")
	public ResponseEntity<User> passwordreset(@RequestBody PasswordReseetRequest request){
		return ResponseEntity.ok(service.passwordreset(request));
	}
}
