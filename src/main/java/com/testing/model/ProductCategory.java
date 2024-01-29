package com.testing.model;

public enum ProductCategory {
	
	CLOTHING("Clothing Products"), 
	ELECTRONIC("Electonic Products"), 
	HOUSEHOLD("Household Products");

	String category;
	
	ProductCategory(String category) {
		this.category = category;
	}
	
	
	
}
