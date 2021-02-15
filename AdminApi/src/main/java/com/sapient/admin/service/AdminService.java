package com.sapient.admin.service;

import java.util.List;

import com.sapient.admin.dto.PalletDto;
import com.sapient.demo.dto.ProductDTO;

public interface AdminService {

	Boolean updateProduct(ProductDTO product);

	List<PalletDto> getTransportDtls();

	Boolean updateTransDtls(PalletDto item);

}
