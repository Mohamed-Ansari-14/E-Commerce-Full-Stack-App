package com.app.eCommerce.entity;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import com.app.eCommerce.dto.OrderDto;
import com.app.eCommerce.enums.OrderStatus;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "orders")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String orderDescription;
	
	private Date date;
	
	private Long amount;
	
	private String address;
	
	private String payment;
	
	private OrderStatus orderStatus;
	
	private Long totalAmount;
	
	private Long discount;
	
	private UUID trackingId;
	
	@OneToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "user_id", referencedColumnName = "id")
	private User user;
	
	@OneToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "coupon_id", referencedColumnName = "id")
	private Coupon coupon;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "order")
	private List<CartItems> cartItems;
	
	public OrderDto getOrderDto() {
		OrderDto orderDto = new OrderDto();
		
		orderDto.setId(id);
		orderDto.setOrderDescription(orderDescription);
		orderDto.setAddress(address);
		orderDto.setTrackingId(trackingId);
		orderDto.setAmount(amount);
		orderDto.setDate(date);
		orderDto.setOrderStatus(orderStatus);
		orderDto.setUserName(user.getName());
		if(coupon != null) {
			orderDto.setCouponName(coupon.getName());
		}
		return orderDto;
	}
}












