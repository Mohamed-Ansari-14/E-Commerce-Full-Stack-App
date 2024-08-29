package com.app.eCommerce.entity;

import com.app.eCommerce.enums.UserRole;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "Users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String email;
	
	private String password;
	
	private String name;
	
	private UserRole role;
	
	@Lob		//using of this we can store the large data
	@Column(columnDefinition = "longblob")		//specifies the column in the database type LONG BLOB
	private byte[] img;
}
