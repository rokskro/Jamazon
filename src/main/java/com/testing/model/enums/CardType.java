package com.testing.model.enums;

public enum CardType {
	
	VISA("Visa Card"), 
	MASTERCARD("Mastercard Card"), 
	JAMMYFRIEND("JammyFriend Easy Payment System");

	final String paymentType;
	
	CardType(String paymentType) {
		this.paymentType = paymentType;
	}
	
	public String getCardType() {
		return paymentType;
	}
	
	
	
}
