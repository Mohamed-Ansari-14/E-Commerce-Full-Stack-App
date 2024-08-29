package com.app.eCommerce.services.customer;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.app.eCommerce.dto.ProductDto;
import com.app.eCommerce.entity.Product;
import com.app.eCommerce.repository.ProductRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CustomerProductServiceImpl implements CustomerProductService{
	
	private final ProductRepository productRepository;

	public List<ProductDto> getAllProducts(){
		List<Product> products = productRepository.findAll();
		return products.stream().map(Product::getDto).collect(Collectors.toList());
	}
	
	public List<ProductDto> searchProductByTitle(String title){
		List<Product> products = productRepository.findAllByNameContaining(title);
		return products.stream().map(Product::getDto).collect(Collectors.toList());
	}
}
















