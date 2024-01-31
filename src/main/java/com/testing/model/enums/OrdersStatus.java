package com.testing.model.enums;

public enum OrdersStatus {
	
	CONFIRMED("Order Confirmed"), 
	TRANSIT("Order In Transit"), 
	DELIVERED("Order Successfully Delivered");

	final String deliveryStatus;
	
	OrdersStatus(String deliveryStatus) {
		this.deliveryStatus = deliveryStatus;
	}
	
	public String getOrdersStatus() {
		return deliveryStatus;
	}
	
}
