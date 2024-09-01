package com.app.eCommerce.services.customer.wishlist;

import java.util.List;

import com.app.eCommerce.dto.WishlistDto;

public interface WishlistService {

	WishlistDto addProductToWishlist(WishlistDto wishlistDto);
	
	List<WishlistDto> getWishlistByUserId(Long userId);
}
