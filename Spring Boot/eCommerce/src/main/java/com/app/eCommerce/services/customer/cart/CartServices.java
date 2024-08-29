package com.app.eCommerce.services.customer.cart;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.app.eCommerce.dto.AddProductInCartDto;
import com.app.eCommerce.dto.OrderDto;
import com.app.eCommerce.dto.PlaceOrderDto;

public interface CartServices {

	ResponseEntity<?> addProductToCart(AddProductInCartDto addProductInCartDto);
	
	OrderDto getCartByUserId(Long userId);
	
	OrderDto applyCoupon(Long userId, String code);
	
	OrderDto increaseProductQuantity(AddProductInCartDto addProductInCartDto);
	
	OrderDto decreaseProductQuantity(AddProductInCartDto addProductInCartDto);
	
	OrderDto placeOrder(PlaceOrderDto placeOrderDto);
	
	List<OrderDto> getMyPlacedOrders(Long userId);
}
