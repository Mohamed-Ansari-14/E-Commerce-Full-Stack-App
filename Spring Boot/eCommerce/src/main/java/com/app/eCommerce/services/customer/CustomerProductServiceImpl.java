package com.app.eCommerce.services.customer;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.app.eCommerce.dto.ProductDetailDto;
import com.app.eCommerce.dto.ProductDto;
import com.app.eCommerce.entity.FAQ;
import com.app.eCommerce.entity.Product;
import com.app.eCommerce.entity.Review;
import com.app.eCommerce.repository.FAQRepository;
import com.app.eCommerce.repository.ProductRepository;
import com.app.eCommerce.repository.ReviewRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CustomerProductServiceImpl implements CustomerProductService{
	
	private final ProductRepository productRepository;
	
	private final FAQRepository faqRepository;
	
	private final ReviewRepository reviewRepository;

	public List<ProductDto> getAllProducts(){
		List<Product> products = productRepository.findAll();
		return products.stream().map(Product::getDto).collect(Collectors.toList());
	}
	
	public List<ProductDto> searchProductByTitle(String title){
		List<Product> products = productRepository.findAllByNameContaining(title);
		return products.stream().map(Product::getDto).collect(Collectors.toList());
	}
	
	public ProductDetailDto getProductDetailById(Long productId) {
		Optional<Product> optionalProduct = productRepository.findById(productId);
		if(optionalProduct.isPresent()) {
			List<FAQ> faqList = faqRepository.findAllByProductId(productId);
			List<Review> reviewList = reviewRepository.findAllByProductId(productId);
			
			ProductDetailDto productDetailDto = new ProductDetailDto();
			
			productDetailDto.setProductDto(optionalProduct.get().getDto());
			productDetailDto.setFaqDtoList(faqList.stream().map(FAQ::getFAQDto).collect(Collectors.toList()));
			productDetailDto.setReviewDtoList(reviewList.stream().map(Review::getDto).collect(Collectors.toList()));
			
			return productDetailDto; 
			
		}
		return null;
	}
}
















