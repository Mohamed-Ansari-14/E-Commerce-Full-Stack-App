package com.app.eCommerce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.eCommerce.entity.Order;
import com.app.eCommerce.enums.OrderStatus;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long>{

	Order findByUserIdAndOrderStatus(Long userId, OrderStatus orderStatus);
	
	List<Order> findAllByOrderStatusIn(List<OrderStatus> orderStatusList);
	
	//newly added....
	Order findTopByUserIdOrderByIdDesc(Long userId);
	
	List<Order> findByUserIdAndOrderStatusIn(Long userId, List<OrderStatus> orderStatus);
}
