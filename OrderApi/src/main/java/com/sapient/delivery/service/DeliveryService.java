package com.sapient.delivery.service;

import java.util.List;

import com.sapient.demo.dto.OrderDtlsDTO;

public interface DeliveryService {

	public Boolean updateOrder(OrderDtlsDTO updatedOrder);

	public List<Integer> getAllOrders(String userName);

	public OrderDtlsDTO getOrderDtls(int orderNum);

}
