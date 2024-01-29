package com.testing.model;

public enum OrderStatus {
	
	CONFIRMED("Order Confirmed"), 
	TRANSIT("Order In Transit"), 
	DELIVERED("Order Successfully Delivered");

	String deliverlyStatus;
	
	OrderStatus(String deliveryStatus) {
		this.deliverlyStatus = deliveryStatus;
	}
	
}
