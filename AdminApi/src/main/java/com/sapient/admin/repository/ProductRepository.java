package com.sapient.admin.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.sapient.demo.dto.ProductDTO;

@Repository
public interface ProductRepository extends MongoRepository<ProductDTO, String>{
	
	@Query(value="{'name':?0}", delete = true)
	ProductDTO deleteProduct(String name);
}
