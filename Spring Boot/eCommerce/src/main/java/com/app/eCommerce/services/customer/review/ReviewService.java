package com.app.eCommerce.services.customer.review;

import java.io.IOException;

import com.app.eCommerce.dto.OrderedProductsResponseDto;
import com.app.eCommerce.dto.ReviewDto;

public interface ReviewService {

	OrderedProductsResponseDto getOrderedProductsDetailsByOrderId(Long orderId);
	
	ReviewDto giveReview(ReviewDto reviewDto) throws IOException;
}
