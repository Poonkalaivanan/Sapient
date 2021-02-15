package com.sapient.customer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sapient.customer.service.CustomerService;
import com.sapient.demo.dto.OrderDtlsDTO;
import com.sapient.demo.dto.ProductDTO;
import com.sapient.demo.util.JwtTokenUtil;

@RestController
@CrossOrigin
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerService custService;
	
	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	
	@GetMapping("/getAllProducts")
	public ResponseEntity<?> getAllProducts(){
		List<ProductDTO> returnList = custService.getAllProducts();
		if(returnList.isEmpty()) return ResponseEntity.ok("No Items available");
		return ResponseEntity.ok(returnList);
	}
	
	@PostMapping("/placeOrder")
	public ResponseEntity<?> placeOrder(@RequestBody List<ProductDTO> items, @RequestHeader("Authorization") String authToken){
		String userName = jwtTokenUtil.getUsernameFromToken(authToken.substring(7));
		int responseVal = custService.placeOrder(userName, items);
		if(0 == responseVal) return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error in placing order");
		else return ResponseEntity.ok(responseVal);
	}
}
