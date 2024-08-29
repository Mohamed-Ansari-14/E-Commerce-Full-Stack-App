package com.app.eCommerce.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.eCommerce.entity.Coupon;

@Repository
public interface CouponRepository extends JpaRepository<Coupon, Long> {

	boolean existsByCode(String code);
	
	Optional<Coupon> findByCode(String code);
}
