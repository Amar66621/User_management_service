package com.user.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.user.dao.RegisterDao;
import com.user.dto.PasswordReseetRequest;
import com.user.dto.RegisterRequest;
import com.user.exception.ErrorHandling;
import com.user.model.User;
import com.user.repo.UserRepository;
import com.user.role.Role;
import com.user.service.UserService;
import com.user.translator.UserTranslator;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserServiceimpl implements UserService{
	
	@Autowired
	private RegisterDao dao;
	@Autowired
	private UserTranslator translator;
	@Autowired
	private UserRepository repo;
	
	
	
	
//<------------------------------------------------------------------------------------------------->	
//	this method is for to register a new user as based on their roles{ STUDENT< TEACHER< ADMIN}
	
	
	@Override
	public User registeruser(RegisterRequest request) {
		// TODO Auto-generated method stub
		User user = translator.toUser(request);
		
		User registereduser = dao.registeruser(request);
        log.info("User registered: {}", registereduser.getUsername());
		
		return registereduser;
	}


//<-------------------------------------------------------------------------------------------------------->
//This method is for if user wants to update their profile


	@Override
	public User updateuser(Long id, RegisterRequest request) {
		// TODO Auto-generated method stub
		
		User user = translator.toUser(request);
		
		User update = dao.updateuser(request, id);
		log.info("User update successfully:", update.getEmail());
		return update;
	}

	
//<---------------------------------------------------------------------------------------------------------------->	
//This is for too reset the password of the user account if user forget it
	
	
	
	@Override
	public User passwordreset(PasswordReseetRequest request) {
		// TODO Auto-generated method stub
		User user = dao.passwordreset(request);
		
		log.info("password reset successfully for email: ", request.getEmail());
		
		return user;
	}

	
	
	
//<--------------------------------------------------------------------------------------------------------------------------?>
//This method is for admin if they wants to find the single user
	
	@Override
	public User findByIdandRole(Long id, Role role) {
		// TODO Auto-generated method stub
		User user = repo.findByIdAndRole(id, role).orElseThrow(
				()-> new IllegalArgumentException("User not found with thier id and role"));
		
		return user;
	}

	
	
	
//<-------------------------------------------------------------------------------------------------------------------------->
//This is also same as above but find by their username
	
	@Override
	public User findByname(String username) {
		// TODO Auto-generated method stub
		User user = repo.findByUsername(username).orElseThrow(null);
		return user;
	}
	
	
	
	
//<----------------------------------------------------------------------------------------------------------------------------->
//This is for admin if they want to find all user using their role
	
	

	@Override
	public List<User> fetch(Role role) {
		// TODO Auto-generated method stub
		List<User> user = repo.findByRole(role);
		
		return user;
	}
	
	
	
	
	
	
	
//<---------------------------------------------------------------------------------------------------------------------------------->
//	This method is for admin also if they want to remaove student or teacher form the database


	@Override
	public void deleteByIdandRole(Role role, long id) throws ErrorHandling{
		// TODO Auto-generated method stub
		List<User> users = repo.findByRole(role);
		boolean existuser = users.stream().anyMatch(user-> user.getId().equals(id));
		
		if(existuser) {
			repo.deleteById(id);
		}else {
			throw new ErrorHandling("User with id"+id+"user with role"+role+"not found");
		}
		
	}
	
	

}
