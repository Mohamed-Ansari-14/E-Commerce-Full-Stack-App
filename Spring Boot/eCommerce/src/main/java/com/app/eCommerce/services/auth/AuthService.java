package com.app.eCommerce.services.auth;

import com.app.eCommerce.dto.SignupRequest;
import com.app.eCommerce.dto.UserDto;

public interface AuthService {

	UserDto createUser(SignupRequest signupRequest);
	
	Boolean hasUserWithEmail(String email);
}
