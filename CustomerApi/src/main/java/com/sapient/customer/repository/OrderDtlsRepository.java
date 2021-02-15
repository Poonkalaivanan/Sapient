package com.sapient.customer.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.sapient.demo.dto.OrderDtlsDTO;


@Repository
public interface OrderDtlsRepository extends MongoRepository<OrderDtlsDTO, String>{

}
