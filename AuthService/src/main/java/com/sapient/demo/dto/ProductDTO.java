package com.sapient.demo.dto;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "productDtls")
public class ProductDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3746342692205364085L;
	
	@Id
	private String id = null;
	
	private String name;
	private String description;
	private int cost = 0;
	private Boolean isAvailable = true;
	private String seller;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	public Boolean getIsAvailable() {
		return isAvailable;
	}
	public void setIsAvailable(Boolean isAvailable) {
		this.isAvailable = isAvailable;
	}
	public String getSeller() {
		return seller;
	}
	public void setSeller(String seller) {
		this.seller = seller;
	}
	public ProductDTO() {}
}
