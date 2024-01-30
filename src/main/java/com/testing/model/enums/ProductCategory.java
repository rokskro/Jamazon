package com.testing.model.enums;

public enum ProductCategory {
	
	CLOTHING("Clothing Products"), 
	ELECTRONIC("Electonic Products"), 
	HOUSEHOLD("Household Products");

	String category;
	
	ProductCategory(String category) {
		this.category = category;
	}
	
	public String getCategory() {
		return category;
	}
	
	
}
