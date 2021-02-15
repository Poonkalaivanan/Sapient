package com.sapient.admin.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.sapient.admin.dto.PalletDto;
import com.sapient.demo.dto.OrderDtlsDTO;

@Repository
public interface TransportDtls extends MongoRepository<PalletDto, String>{
	@Query(value="{'pallet':?0}", delete = true)
	PalletDto deleteOrderByPalletName(String name);
}
