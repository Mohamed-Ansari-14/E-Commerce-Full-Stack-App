package com.app.eCommerce.services.customer.wishlist;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.app.eCommerce.dto.WishlistDto;
import com.app.eCommerce.entity.Product;
import com.app.eCommerce.entity.User;
import com.app.eCommerce.entity.Wishlist;
import com.app.eCommerce.repository.ProductRepository;
import com.app.eCommerce.repository.UserRepository;
import com.app.eCommerce.repository.WishlistRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class WishlistServiceImpl implements WishlistService{

	private final UserRepository userRepository;
	
	private final ProductRepository productRepository;
	
	private final WishlistRepository wishlistRepository;
	
	
	public WishlistDto addProductToWishlist(WishlistDto wishlistDto) {
		Optional<Product> optionalProduct = productRepository.findById(wishlistDto.getProductId());
		Optional<User> optionalUser = userRepository.findById(wishlistDto.getUserId());
		
		if(optionalProduct.isPresent() && optionalUser.isPresent()) {
			Wishlist wishlist = new Wishlist();
			wishlist.setProduct(optionalProduct.get());
			wishlist.setUser(optionalUser.get());
			
			return wishlistRepository.save(wishlist).getWishlistDto();
		}
		
		return null;
	}
	
	public List<WishlistDto> getWishlistByUserId(Long userId){
		return wishlistRepository.findAllByUserId(userId).stream()
				.map(Wishlist::getWishlistDto).collect(Collectors.toList());
	}
}





















