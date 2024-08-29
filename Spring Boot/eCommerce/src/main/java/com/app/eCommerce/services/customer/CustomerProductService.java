package com.app.eCommerce.services.customer;

import java.util.List;

import com.app.eCommerce.dto.ProductDto;

public interface CustomerProductService {

	List<ProductDto> searchProductByTitle(String title);
	
	List<ProductDto> getAllProducts();
}
