package com.app.eCommerce.services.admin.category;

import java.util.List;

import com.app.eCommerce.dto.CategoryDto;
import com.app.eCommerce.entity.Category;

public interface CategoryService {

	Category createCategory(CategoryDto categoryDto);
	
	List<Category> getAllCategory();
}
