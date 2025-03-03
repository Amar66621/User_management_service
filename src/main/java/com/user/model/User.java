package com.user.model;





import com.user.role.Role;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
@Table
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	@Column(unique = true, nullable = false)
	private String username;
	
	@Column(nullable = false)
	@NotEmpty(message = "Email cannot be empty")
    @Email(message = "Email should be valid")
	private String email;
	
	@Column(nullable = false)
	@NotEmpty(message = "Password cannot be empty")
    @Size(min = 8, message = "Password should be at least 8 characters long")
	
	private String password;
	
	
	
	@Column(nullable = false)
	private String gender;
	
	@Column(nullable = false)
	private String age;
	@NotEmpty(message = "Mobile number cannot be empty")
    @Pattern(regexp = "^\\d{10}$", message = "Mobile number should be 10 digits")
    @Column(nullable = false)
	private String phonenumber;
	
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private Role role;
	
	

}
