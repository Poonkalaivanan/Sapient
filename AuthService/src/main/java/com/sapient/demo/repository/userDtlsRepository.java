package com.sapient.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.sapient.demo.dto.JwtRequest;

@Repository
public interface userDtlsRepository extends MongoRepository<JwtRequest, String> {

	@Query("{'username' : ?0}")
	JwtRequest findUserByName(String userName);
}
