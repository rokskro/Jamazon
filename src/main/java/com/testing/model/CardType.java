package com.testing.model;

public enum CardType {
	
	VISA("Visa Card"), 
	MASTERCARD("Mastercard Card"), 
	JAMMYFRIEND("JammyFriend Easy Payment System");

	String paymentType;
	
	CardType(String paymentType) {
		this.paymentType = paymentType;
	}
	
	
	
}
