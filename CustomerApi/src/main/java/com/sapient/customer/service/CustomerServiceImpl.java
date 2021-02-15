package com.sapient.customer.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.apache.commons.collections4.ListUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import com.sapient.customer.repository.OrderDtlsRepository;
import com.sapient.customer.repository.ProductDtlsRepository;
import com.sapient.demo.dto.OrderDtlsDTO;
import com.sapient.demo.dto.ProductDTO;

@Service
public class CustomerServiceImpl implements CustomerService {

	
	@Autowired
	private ProductDtlsRepository productRepo;
	
	@Autowired
	private OrderDtlsRepository orderRepo;
	
	Random rand = new Random();
	
	@Value("#{new Integer('${random.range}')}")
	private Integer RANGE;
	
	@Override
	public List<ProductDTO> getAllProducts() {
		return productRepo.findAll();
	}
	
	@Override
	public int placeOrder(String userName, List<ProductDTO> items) {
		int parentId = rand.nextInt(RANGE);
		try {
			
		if(items.size()>10) {

			Boolean isParentAdded = false;
			List<List<ProductDTO>> subSets = ListUtils.partition(items, 10);
			for(List<ProductDTO> item: subSets) {
				if(isParentAdded) {
					OrderDtlsDTO orderdtls = new OrderDtlsDTO(userName, item, rand.nextInt(RANGE), true, parentId);
					orderRepo.insert(orderdtls);
				}else {
					OrderDtlsDTO orderdtls = new OrderDtlsDTO(userName, item, parentId, false, 0);
					orderRepo.insert(orderdtls);
					isParentAdded = true;
				}
			}
		}
		else {
			OrderDtlsDTO orderdtls = new OrderDtlsDTO(userName, items, parentId, false, 0);
			orderRepo.insert(orderdtls);
		}
		}catch(Exception e) {
			return 0;
		}
		return parentId;
	}

}
