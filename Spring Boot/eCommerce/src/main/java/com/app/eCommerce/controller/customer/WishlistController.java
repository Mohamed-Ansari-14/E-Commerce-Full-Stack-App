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

import com.app.eCommerce.dto.WishlistDto;
import com.app.eCommerce.services.customer.wishlist.WishlistService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/customer")
public class WishlistController {

	private final WishlistService wishlistService;
	
	@PostMapping("/wishlist")
	public ResponseEntity<?> addProductToWishlist(@RequestBody WishlistDto wishlistDto){
		WishlistDto postedWishlistDto = wishlistService.addProductToWishlist(wishlistDto);
		
		if(postedWishlistDto == null)
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Something went wrong!");
		else
			return ResponseEntity.status(HttpStatus.CREATED).body(postedWishlistDto);
	}
	
	@GetMapping("/wishlist/{userId}")
	public ResponseEntity<List<WishlistDto>> getWishlistByUserId(@PathVariable Long userId){
		return ResponseEntity.ok(wishlistService.getWishlistByUserId(userId));
	}
}















