package com.user.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.user.model.User;
import com.user.role.Role;
import com.user.service.UserService;

@RestController
@RequestMapping("/api/admin")
@PreAuthorize("hasAuthority('ADMIN')")
public class AdminController {
	
	@Autowired
	private UserService service;
	
//	<----------------------------------------------------------------------------------------------------------->
//This is for returning the specific user with their role and id
	
	
	
	@GetMapping("/{role}/{id}")
	public ResponseEntity<User> fetchByidnadRole( @PathVariable long id, @PathVariable Role role){
		return ResponseEntity.ok(service.findByIdandRole(id, role));
	}

	
//<--------------------------------------------------------------------------------------------------------------------->
//This method is used to find the no user based on their role{student and teacher}
	@GetMapping("/{role}")
	public ResponseEntity<List<User>> fetchuser(@PathVariable Role role){
		return ResponseEntity.ok(service.fetch(role));
	}
	
	
	
	
//	<---------------------------------------------------------------------------------------------------------------------->
//	This method dlete the user from the admin pannel if admin wants
	
	@DeleteMapping("/{role}/{id}")
	public ResponseEntity<Void> deleteuser( @PathVariable Role role,@PathVariable Long id){
		try {
            service.deleteByIdandRole(role, id);
            return ResponseEntity.noContent().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
	}
	
}
