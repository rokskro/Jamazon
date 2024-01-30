package com.testing.model.enums;

public enum ProductCategory {
	
	CLOTHING("Clothing Products"), 
	ELECTRONIC("Electonic Products"), 
	HOUSEHOLD("Household Products");

	final String category;
	
	ProductCategory(String category) {
		this.category = category;
	}
	
	
	
}
