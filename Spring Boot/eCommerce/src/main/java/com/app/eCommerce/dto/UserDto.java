package com.app.eCommerce.dto;

import com.app.eCommerce.enums.UserRole;

import lombok.Data;

@Data
public class UserDto {

	private Long id;
	
	private String email;
	
	private String name;
	
	private UserRole userRole;
}
