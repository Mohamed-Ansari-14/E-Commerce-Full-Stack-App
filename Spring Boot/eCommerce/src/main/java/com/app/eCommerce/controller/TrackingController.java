package com.app.eCommerce.controller;

import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.app.eCommerce.dto.OrderDto;
import com.app.eCommerce.services.customer.cart.CartServices;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class TrackingController {

	private final CartServices cartServices;
	
	@GetMapping("/order/{trackingId}")
	public ResponseEntity<OrderDto> searchOrderByTrackingId(@PathVariable UUID trackingId){
		OrderDto orderDto = cartServices.searchOrderByTrackingId(trackingId);
		if(orderDto == null)
			return ResponseEntity.notFound().build();
		else
			return ResponseEntity.ok(orderDto);
	}
}
