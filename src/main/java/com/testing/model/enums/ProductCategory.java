package com.testing.model.enums;

public enum ProductCategory {
	
	CLOTHING("Clothing Products"), 
	ELECTRONIC("Electronic Products"),
	HOUSEHOLD("Household Products");

	final String category;
	
	ProductCategory(String category) {
		this.category = category;
	}
	
	public String getCategory() {
		return category;
	}
	
	
}
