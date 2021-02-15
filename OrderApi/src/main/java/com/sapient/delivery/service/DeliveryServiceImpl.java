package com.sapient.delivery.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sapient.delivery.repository.DeliveryRepository;
import com.sapient.demo.dto.OrderDtlsDTO;

@Service
public class DeliveryServiceImpl implements DeliveryService{

	@Autowired
	private DeliveryRepository deliveryRepo;

	@Override
	public Boolean updateOrder(OrderDtlsDTO updatedOrder) {
		try {
		deliveryRepo.deleteOrderByOrderNum(updatedOrder.getOrderRefNumber());
		deliveryRepo.insert(updatedOrder);
		return true;
		}catch(Exception e) {return false;}
	}

	@Override
	public List<Integer> getAllOrders(String userName) {
		try {
		List<Integer> orderNumbers = new ArrayList<Integer>();
		List<OrderDtlsDTO> userOrders = deliveryRepo.findorderByUser(userName);
		for (OrderDtlsDTO order: userOrders) orderNumbers.add(order.getOrderRefNumber());
		return orderNumbers;
		}catch(Exception e) { return null;}
	}
	@Override
	public OrderDtlsDTO getOrderDtls(int orderNum) {
		try {
		OrderDtlsDTO orderDtls = deliveryRepo.findOrderByOrderNum(orderNum);
		return orderDtls;
	}catch(Exception e) { return null;}
	}
}
