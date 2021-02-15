package com.sapient.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sapient.admin.dto.PalletDto;
import com.sapient.admin.service.AdminService;
import com.sapient.demo.dto.ProductDTO;

@RestController
@CrossOrigin
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	private AdminService adminService;
	
	@PostMapping("/updateProductDtls")
	public ResponseEntity<Boolean> updateProduct(@RequestBody ProductDTO product){
		Boolean returnValue = adminService.updateProduct(product);
		return ResponseEntity.ok(returnValue);
	}
	//Add UpdatePallet and truck api call
	@GetMapping("/getAllTransportDtls")
	public ResponseEntity<List<PalletDto>> getTransportDtls(){
		List<PalletDto> returnValue = adminService.getTransportDtls();
		return ResponseEntity.ok(returnValue);
	}
	
	@PostMapping("/updateTransportDtls")
	public ResponseEntity<Boolean> updateTransportDtls(@RequestBody PalletDto item){
		Boolean returnVal = adminService.updateTransDtls(item);
		return ResponseEntity.ok(returnVal);
	}
}
