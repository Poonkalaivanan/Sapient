package com.sapient.customer.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.sapient.demo.dto.ProductDTO;

@Repository
public interface ProductDtlsRepository extends MongoRepository<ProductDTO, String>{

}
