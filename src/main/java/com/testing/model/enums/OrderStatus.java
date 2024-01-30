package com.testing.model.enums;

public enum OrderStatus {
	
	CONFIRMED("Order Confirmed"), 
	TRANSIT("Order In Transit"), 
	DELIVERED("Order Successfully Delivered");

	final String deliveryStatus;
	
	OrderStatus(String deliveryStatus) {
		this.deliveryStatus = deliveryStatus;
	}
	
}
