package com.app.eCommerce.services.admin.coupon;

import java.util.List;

import com.app.eCommerce.entity.Coupon;

public interface AdminCouponService {

	Coupon createCoupon(Coupon coupon);
	
	List<Coupon> getAllCoupons();
}
