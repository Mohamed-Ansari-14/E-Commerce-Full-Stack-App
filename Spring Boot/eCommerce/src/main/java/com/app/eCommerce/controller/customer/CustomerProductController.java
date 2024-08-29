package com.app.eCommerce.controller.customer;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.eCommerce.dto.ProductDto;
import com.app.eCommerce.services.customer.CustomerProductService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/customer")
@RequiredArgsConstructor
public class CustomerProductController {

	private final CustomerProductService customerProductService;
	
	@GetMapping("/products")
	public ResponseEntity<List<ProductDto>> getAllProducts(){
		List<ProductDto> productDtos = customerProductService.getAllProducts();
		return ResponseEntity.ok(productDtos);
	}
	
	@GetMapping("/search/{name}")
	public ResponseEntity<List<ProductDto>> getAllProductsByName(@PathVariable String name){
		List<ProductDto> productDtos = customerProductService.searchProductByTitle(name);
		return ResponseEntity.ok(productDtos);
	}
}













