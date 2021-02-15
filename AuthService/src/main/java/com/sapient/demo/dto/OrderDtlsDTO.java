package com.sapient.demo.dto;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "orderDtls")
public class OrderDtlsDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5657069381152975600L;
	
	@Id
	public String id=null;
	
	public List<ProductDTO> getProduct() {
		return product;
	}
	public void setProduct(List<ProductDTO> product) {
		this.product = product;
	}
	public Boolean getIsSubOrder() {
		return isSubOrder;
	}
	public void setIsSubOrder(Boolean isSubOrder) {
		this.isSubOrder = isSubOrder;
	}
	public int getParentOrderRefNumber() {
		return parentOrderRefNumber;
	}
	public void setParentOrderRefNumber(int parentOrderRefNumber) {
		this.parentOrderRefNumber = parentOrderRefNumber;
	}
	public int getOrderRefNumber() {
		return orderRefNumber;
	}
	public void setOrderRefNumber(int orderRefNumber) {
		this.orderRefNumber = orderRefNumber;
	}
	public String getPalletRefNumber() {
		return palletRefNumber;
	}
	public void setPalletRefNumber(String palletRefNumber) {
		this.palletRefNumber = palletRefNumber;
	}
	public String getTruckRefNumber() {
		return truckRefNumber;
	}
	public void setTruckRefNumber(String truckRefNumber) {
		this.truckRefNumber = truckRefNumber;
	}
	public Boolean getIsLost() {
		return isLost;
	}
	public void setIsLost(Boolean isLost) {
		this.isLost = isLost;
	}
	public Boolean getIsDamaged() {
		return isDamaged;
	}
	public void setIsDamaged(Boolean isDamaged) {
		this.isDamaged = isDamaged;
	}
	public Boolean getIsDelivered() {
		return isDelivered;
	}
	public void setIsDelivered(Boolean isDelivered) {
		this.isDelivered = isDelivered;
	}
	
	private List<ProductDTO> product;
	private Boolean isSubOrder = false;
	private int parentOrderRefNumber = 0;
	private int orderRefNumber;
	private String palletRefNumber = "";
	private String truckRefNumber = "";
	private Boolean isLost = false;
	private Boolean isDamaged = false;
	private Boolean isDelivered = false;
	private String customerId;
	
	public OrderDtlsDTO(String customerId, List<ProductDTO> product,int orderRefNumber,Boolean isSubOrder,int parentOrderRefNumber) {
		this.customerId = customerId;
		this.product = product;
		this.isSubOrder = isSubOrder;
		this.orderRefNumber = orderRefNumber;
		this.parentOrderRefNumber = parentOrderRefNumber;
		
	}
	public OrderDtlsDTO(int orderRefNumber, String palletRefNumber,String truckRefNumber) {
		this.orderRefNumber = orderRefNumber;
		this.palletRefNumber = palletRefNumber;
		this.truckRefNumber = truckRefNumber;
		
	}
	public OrderDtlsDTO(int orderRefNumber, Boolean isLost, Boolean isDamaged, Boolean isDelivered) {
		this.orderRefNumber = orderRefNumber;
		this.isLost = isLost;
		this.isDamaged = isDamaged;
		this.isDelivered = isDelivered;
		
	}
	public OrderDtlsDTO() {}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
}
