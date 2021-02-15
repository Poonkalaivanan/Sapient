package com.sapient.admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sapient.admin.dto.PalletDto;
import com.sapient.admin.repository.ProductRepository;
import com.sapient.admin.repository.TransportDtls;
import com.sapient.demo.dto.ProductDTO;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private ProductRepository prodRepo;
	@Autowired
	private TransportDtls transRepo;
	@Override
	public Boolean updateProduct(ProductDTO product) {
		try {
			prodRepo.deleteProduct(product.getName());
			prodRepo.insert(product);
			return true;
		}catch(Exception e) {return false;}
	}
	@Override
	public List<PalletDto> getTransportDtls() {
		try {
			List<PalletDto> returnVal = transRepo.findAll();
			return returnVal;
		}catch(Exception e) {return null;}
	}
	@Override
	public Boolean updateTransDtls(PalletDto item) {
		try {
			transRepo.deleteOrderByPalletName(item.getPallet());
			transRepo.insert(item);
			return true;
		}catch(Exception e) {return false;}
	}
	

}
