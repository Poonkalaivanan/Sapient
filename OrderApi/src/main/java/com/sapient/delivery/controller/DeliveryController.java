package com.sapient.delivery.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sapient.delivery.service.DeliveryService;
import com.sapient.demo.dto.OrderDtlsDTO;
import com.sapient.demo.util.JwtTokenUtil;

@RestController
@CrossOrigin
@RequestMapping("/orders")
public class DeliveryController {

	@Autowired
	private DeliveryService deliveryService;
	
	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	
	@PostMapping("/updateDeliveryDtls")
	public ResponseEntity<Boolean> updateOrder(@RequestBody OrderDtlsDTO updatedOrder){
		Boolean returnValue = deliveryService.updateOrder(updatedOrder);
		return ResponseEntity.ok(returnValue);
	}
	
	@GetMapping("/getAllorders")
	public ResponseEntity<List<Integer>> getAllOrders(@RequestHeader("Authorization") String authToken){
		String userName = jwtTokenUtil.getUsernameFromToken(authToken.substring(7));
		List<Integer> returnList = deliveryService.getAllOrders(userName);
		return ResponseEntity.ok(returnList);
	}
	
	@GetMapping("/getOrderDtls")
	private ResponseEntity<OrderDtlsDTO> getOrderDtls(@RequestParam int orderNum){
		OrderDtlsDTO returnDtls = deliveryService.getOrderDtls(orderNum);
		return ResponseEntity.ok(returnDtls);
	}
}
