package com.app.eCommerce.services.admin.allUsers;

import java.util.List;

import org.springframework.stereotype.Service;

import com.app.eCommerce.entity.User;
import com.app.eCommerce.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AllUsersServiceImpl implements AllUsersService {

	private final UserRepository userRepository;
	
	public List<User> getAllUsers(){
		return userRepository.findAll();
	}
}
