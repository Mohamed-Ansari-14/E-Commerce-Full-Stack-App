package com.app.eCommerce.controller.admin;

import java.io.IOException;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.eCommerce.dto.FAQDto;
import com.app.eCommerce.dto.ProductDto;
import com.app.eCommerce.services.admin.adminproduct.AdminProductService;
import com.app.eCommerce.services.admin.faq.FAQService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/admin")
@RequiredArgsConstructor
public class AdminProductController {

	private final AdminProductService adminProductService;
	
	private final FAQService faqService;
			
						//Bcoz of MultiPartFile we have to use @ModelAttribute instead of @RequestBody
	@PostMapping("/product")
	public ResponseEntity<ProductDto> addProduct(@ModelAttribute ProductDto productDto) throws IOException{
		ProductDto productDto1 = adminProductService.addProduct(productDto); 
		return ResponseEntity.status(HttpStatus.CREATED).body(productDto1);
	}
	
	@GetMapping("/products")
	public ResponseEntity<List<ProductDto>> getAllProducts(){
		List<ProductDto> productDtos = adminProductService.getAllProducts();
		return ResponseEntity.ok(productDtos);
	}
	
	@GetMapping("/search/{name}")
	public ResponseEntity<List<ProductDto>> getAllProductsByName(@PathVariable String name){
		List<ProductDto> productDtos = adminProductService.getAllProductsByName(name);
		return ResponseEntity.ok(productDtos);
	}
	
	@DeleteMapping("/product/{productId}")
	public ResponseEntity<Void> deleteProduct(@PathVariable("productId") Long ProductId){
		boolean deleted = adminProductService.deleteProduct(ProductId);
		if(deleted) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.notFound().build();
	}
	
	@PostMapping("/faq/{productId}")
	public ResponseEntity<FAQDto> postFAQ(@PathVariable Long productId, @RequestBody FAQDto faqDto){
		return ResponseEntity.status(HttpStatus.CREATED).body(faqService.postFAQ(productId, faqDto));
	}
	
	@GetMapping("/product/{productId}")
	public ResponseEntity<ProductDto> getProductById(@PathVariable Long productId){
		ProductDto productDto = adminProductService.getProductById(productId);
		if(productDto != null) {
			return ResponseEntity.ok(productDto);
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@PutMapping("/product/{productId}")
	public ResponseEntity<ProductDto> updateProduct(@PathVariable("productId") Long ProductId, 
			@ModelAttribute ProductDto productDto) throws IOException{
		
		ProductDto updatedProduct = adminProductService.updateProduct(ProductId, productDto);
		if(updatedProduct != null) {
			return ResponseEntity.ok(updatedProduct);
		}else {
			return ResponseEntity.notFound().build();
		}
	}
}















