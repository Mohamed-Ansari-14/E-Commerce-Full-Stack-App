package com.app.eCommerce.controller.customer;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.eCommerce.dto.AddProductInCartDto;
import com.app.eCommerce.dto.OrderDto;
import com.app.eCommerce.dto.PlaceOrderDto;
import com.app.eCommerce.exceptions.ValidationException;
import com.app.eCommerce.services.customer.cart.CartServices;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/customer")
@RequiredArgsConstructor
public class CartController {
	
	private final CartServices cartServices;
	
	@PostMapping("/cart")
	public ResponseEntity<?> addProductToCart(@RequestBody AddProductInCartDto addProductInCartDto){
		return cartServices.addProductToCart(addProductInCartDto);
	}
	
	@GetMapping("/cart/{userId}")
	public ResponseEntity<?> getCartByUserId(@PathVariable Long userId){
		OrderDto orderDto = cartServices.getCartByUserId(userId);
		return ResponseEntity.status(HttpStatus.OK).body(orderDto);
	}
	
	@GetMapping("/coupon/{userId}/{code}")
	public ResponseEntity<?> applyCoupon(@PathVariable Long userId, @PathVariable String code){
		try {
			OrderDto orderDto = cartServices.applyCoupon(userId, code);
			return ResponseEntity.ok(orderDto);
		}catch(ValidationException ex) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
		}
	}
	
	@PostMapping("/addition")
	public ResponseEntity<OrderDto> increaseProductQuantity(@RequestBody AddProductInCartDto addProductInCartDto){
		return ResponseEntity.status(HttpStatus.CREATED).body(cartServices.increaseProductQuantity(addProductInCartDto));
	}
	
	@PostMapping("/deduction")
	public ResponseEntity<OrderDto> decreaseProductQuantity(@RequestBody AddProductInCartDto addProductInCartDto){
		return ResponseEntity.status(HttpStatus.CREATED).body(cartServices.decreaseProductQuantity(addProductInCartDto));
	}
	
	@PostMapping("/placeOrder")
	public ResponseEntity<OrderDto> placeOrder(@RequestBody PlaceOrderDto placeOrderDto){
		return ResponseEntity.status(HttpStatus.CREATED).body(cartServices.placeOrder(placeOrderDto));
	}
	
	@GetMapping("/myOrders/{userId}")
	public ResponseEntity<List<OrderDto>> getMyPlacedOrders(@PathVariable Long userId){
		return ResponseEntity.ok(cartServices.getMyPlacedOrders(userId));
	}
}
















