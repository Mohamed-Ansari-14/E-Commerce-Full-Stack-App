package com.app.eCommerce.services.admin.adminOrder;

import java.util.List;

import com.app.eCommerce.dto.AnalyticsResponse;
import com.app.eCommerce.dto.OrderDto;

public interface AdminOrderService {

	List<OrderDto> getAllPlacedOrders();
	
	OrderDto changeOrderStatus(Long orderId, String status);
	
	AnalyticsResponse calculateAnalytics();
}
