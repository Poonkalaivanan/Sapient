package com.sapient.customer.service;

import java.util.List;

import com.sapient.demo.dto.OrderDtlsDTO;
import com.sapient.demo.dto.ProductDTO;


public interface CustomerService {
	
public List<ProductDTO> getAllProducts();

public int placeOrder(String userName, List<ProductDTO> items);

}
