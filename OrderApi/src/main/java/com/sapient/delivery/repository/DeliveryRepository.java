package com.sapient.delivery.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.sapient.demo.dto.OrderDtlsDTO;

@Repository
public interface DeliveryRepository extends MongoRepository<OrderDtlsDTO, String>{

	@Query(value="{'orderRefNumber':?0}", delete = true)
	OrderDtlsDTO deleteOrderByOrderNum(int orderNumber);
	
	@Query("{'customerId' : ?0}")
	List<OrderDtlsDTO> findorderByUser(String userName);
	
	@Query("{'orderRefNumber':?0}")
	OrderDtlsDTO findOrderByOrderNum(int orderNumber);
}
