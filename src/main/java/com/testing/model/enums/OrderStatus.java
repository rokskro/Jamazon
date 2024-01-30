package com.testing.model.enums;

public enum OrderStatus {
	
	CONFIRMED("Order Confirmed"), 
	TRANSIT("Order In Transit"), 
	DELIVERED("Order Successfully Delivered");

	String deliveryStatus;
	
	OrderStatus(String deliveryStatus) {
		this.deliveryStatus = deliveryStatus;
	}
	
	public String getOrderStatus() {
		return deliveryStatus;
	}
	
}
