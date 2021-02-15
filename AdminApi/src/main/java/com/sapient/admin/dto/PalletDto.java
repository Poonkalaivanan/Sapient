package com.sapient.admin.dto;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "transportDtls")
public class PalletDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5671961274407166701L;

	@Id
	private String id;
	private String pallet;
	private String truck;
	public PalletDto() {}
	public String getPallet() {
		return pallet;
	}
	public void setPallet(String pallet) {
		this.pallet = pallet;
	}
	public String getTruck() {
		return truck;
	}
	public void setTruck(String truck) {
		this.truck = truck;
	}
	
}
