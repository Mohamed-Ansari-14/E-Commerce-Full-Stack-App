package com.app.eCommerce.controller.admin;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.eCommerce.dto.CategoryDto;
import com.app.eCommerce.entity.Category;
import com.app.eCommerce.services.admin.category.CategoryService;

import lombok.RequiredArgsConstructor;

//@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/admin")
@RequiredArgsConstructor
public class AdminCategoryController {

	private final CategoryService categoryService;
	
	@PostMapping("category")
	public ResponseEntity<Category> createCategory(@RequestBody CategoryDto categoryDto){
		Category category = categoryService.createCategory(categoryDto);
		return ResponseEntity.status(HttpStatus.CREATED).body(category);
	}
	
	@GetMapping("")
	public ResponseEntity<List<Category>> getAllCategories(){
		return ResponseEntity.ok(categoryService.getAllCategory());
	}
}



















