package com.app.eCommerce.services.customer.review;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.app.eCommerce.dto.OrderedProductsResponseDto;
import com.app.eCommerce.dto.ProductDto;
import com.app.eCommerce.dto.ReviewDto;
import com.app.eCommerce.entity.CartItems;
import com.app.eCommerce.entity.Order;
import com.app.eCommerce.entity.Product;
import com.app.eCommerce.entity.Review;
import com.app.eCommerce.entity.User;
import com.app.eCommerce.repository.OrderRepository;
import com.app.eCommerce.repository.ProductRepository;
import com.app.eCommerce.repository.ReviewRepository;
import com.app.eCommerce.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService {

	private final OrderRepository orderRepository;
	
	private final ProductRepository productRepository;
	
	private final UserRepository userRepository;
	
	private final ReviewRepository reviewRepository;
	
	public OrderedProductsResponseDto getOrderedProductsDetailsByOrderId(Long orderId) {
		Optional<Order> optionalOrder = orderRepository.findById(orderId);
		OrderedProductsResponseDto orderedProductsResponseDto = new OrderedProductsResponseDto();
		
		if(optionalOrder.isPresent()) {
			orderedProductsResponseDto.setOrderAmount(optionalOrder.get().getAmount());
			
			List<ProductDto> productDtoList = new ArrayList<>();
			for(CartItems cartItems : optionalOrder.get().getCartItems()) {
				ProductDto productDto = new ProductDto();
				
				productDto.setId(cartItems.getProduct().getId());
				productDto.setName(cartItems.getProduct().getName());
				productDto.setPrice(cartItems.getPrice());
				productDto.setQuantity(cartItems.getQuantity());
				
				productDto.setByteImg(cartItems.getProduct().getImg());
				
				productDtoList.add(productDto);
			}
			orderedProductsResponseDto.setProductDtoList(productDtoList);
		}
		
		return orderedProductsResponseDto;
	}
	
	public ReviewDto giveReview(ReviewDto reviewDto) throws IOException {
		Optional<Product> optionalProduct = productRepository.findById(reviewDto.getProductId());
		Optional<User> optionalUser = userRepository.findById(reviewDto.getUserId());
		
		if(optionalProduct.isPresent() && optionalUser.isPresent()) {
			Review review = new Review();
			
			review.setRating(reviewDto.getRating());
			review.setDescription(reviewDto.getDescription());
			review.setUser(optionalUser.get());
			review.setProduct(optionalProduct.get());
			review.setImg(reviewDto.getImg().getBytes());
			
			return reviewRepository.save(review).getDto();
		}
		return null;
	}
}













