package com.app.eCommerce.services.customer;

import java.util.List;

import com.app.eCommerce.dto.ProductDetailDto;
import com.app.eCommerce.dto.ProductDto;
import com.app.eCommerce.entity.User;

public interface CustomerProductService {

	List<ProductDto> searchProductByTitle(String title);
	
	List<ProductDto> getAllProducts();
	
	ProductDetailDto getProductDetailById(Long productId);
	
	User getUserById(Long id);
}
