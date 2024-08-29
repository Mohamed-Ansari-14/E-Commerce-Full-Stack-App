package com.app.eCommerce.services.admin.category;

import java.util.List;

import org.springframework.stereotype.Service;

import com.app.eCommerce.dto.CategoryDto;
import com.app.eCommerce.entity.Category;
import com.app.eCommerce.repository.CategoryRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

	private final CategoryRepository categoryRepository;
	
	public Category createCategory(CategoryDto categoryDto) {
		Category category = new Category();
		
		category.setName(categoryDto.getName());
		category.setDescription(categoryDto.getDescription());
		
		return categoryRepository.save(category);
	}
	
	public List<Category> getAllCategory() {
		return categoryRepository.findAll();
	}
	
	
}
