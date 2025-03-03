package com.user.dao;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.user.dto.PasswordReseetRequest;
import com.user.dto.RegisterRequest;
import com.user.exception.ErrorHandling;
import com.user.model.User;
import com.user.repo.UserRepository;



@Component
public class RegisterDao {
	@Autowired
	private UserRepository repos;


	 private final PasswordEncoder encoder;

	    public RegisterDao(PasswordEncoder encoder) {
	        this.encoder = encoder;
	    }
	    
	    
	    
//<----------------------------------------------------------------------------------------------------------------------------------------->
	    
	public User registeruser(RegisterRequest request) throws ErrorHandling{
		 if (!request.getPassword().equals(request.getConfirmpassword())) {
	            throw new ErrorHandling("Password and Confirm Password do not match");
	        }
		 
		 if(repos.existsByUsername(request.getUsername())) {
			 throw new ErrorHandling("User Already exist");
		 }
		 
		 if(repos.existsByEmail(request.getEmail())) {
			 throw new ErrorHandling("Email already exist");
			 
		 }
		 
		  User user = new User();
	        user.setUsername(request.getUsername());
	        user.setPassword(encoder.encode(request.getPassword())); // Encrypt password
	        user.setEmail(request.getEmail());
	        user.setGender(request.getGender());
	        user.setAge(request.getAge());
	        user.setPhonenumber(request.getPhonenumber());
	        user.setRole(request.getRole());

//	        RoleEnum roleEnum = RoleEnum.ROLE_USER;
//
//	        // Find role by RoleEnum
//	        UserRole userRole = rolerepo.findByName(roleEnum)
//	                .orElseThrow(() -> new RuntimeException("Role not found: " + roleEnum));
//
//	        user.setRoles(Collections.singleton(userRole));

	        // Save the user to the database
	        return repos.save(user);
		
	
	}
	
	
//<---------------------------------------------------------------------------------------------------------------------------------------->
	
	
	
	public User updateuser(RegisterRequest request, Long id) throws ErrorHandling{
		
		User existinguser = repos.findById(id).orElse(null);
		
		if(existinguser == null) {
			throw new ErrorHandling("User not found with this id" +id);
		}
		
		if(request.getUsername()!=null) {
			existinguser.setUsername(request.getUsername());
		}
		
		if(request.getEmail()!=null) {
			existinguser.setEmail(request.getEmail());
		}
		
		if(request.getAge()!=null) {
			existinguser.setAge(request.getAge());
		}
		
		if(request.getGender()!= null) {
			existinguser.setGender(request.getGender());
		}
		
		if(request.getPhonenumber()!= null) {
			existinguser.setPhonenumber(request.getPhonenumber());
		}
		return repos.save(existinguser);
	}
	
	
//<------------------------------------------------------------------------------------------------------------------------------------------->	
	
	
	
	public User passwordreset(PasswordReseetRequest request) throws ErrorHandling{
		  User user = repos.findByEmail(request.getEmail()).orElse(null);
		  
		  if(user == null) {
			  throw new ErrorHandling("User not found With that Email"+request.getEmail());
		  }
		  
		  
		  if (!request.getNewpassword().equals(request.getConfirmpassword())) {
	            throw new ErrorHandling("New password and confirm password do not match.");
	        }
		  
		  
		  String hashpassword = encoder.encode(request.getNewpassword());
		  user.setPassword(hashpassword);
		  return repos.save(user);
	}
	
	
}
