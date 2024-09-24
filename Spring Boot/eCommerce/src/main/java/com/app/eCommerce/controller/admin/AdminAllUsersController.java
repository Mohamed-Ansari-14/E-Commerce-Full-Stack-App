package com.app.eCommerce.controller.admin;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.app.eCommerce.entity.User;
import com.app.eCommerce.services.admin.allUsers.AllUsersService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/admin")
@RequiredArgsConstructor
public class AdminAllUsersController {
	
	private final AllUsersService allUsersService;	
	
	@GetMapping("/users")
	public ResponseEntity<List<User>> getAllProducts(){
		List<User> userList = allUsersService.getAllUsers();
		return ResponseEntity.ok(userList);
	}
}
