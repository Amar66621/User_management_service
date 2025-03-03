package com.user.translator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.user.dto.RegisterRequest;
import com.user.model.User;

@Component
public class UserTranslator {

	  @Autowired
	    private ObjectMapper objectMapper;

	    public User toUser(RegisterRequest request) {
	        return objectMapper.convertValue(request, User.class);
	    }
}
