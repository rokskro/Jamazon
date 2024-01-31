package com.testing.model.enums;

public enum SignOfTheStars {
	
	ARIES("Aries"),
	TAURUS("Taurus"),
	GEMINI("Gemini"),
	CANCER("Cancer"),
	LEO("Leo"),
	VIRGO("Virgo"),
	LIBRA("Libra"),
	SCORPIO("Scorpio"),
	SAGITTARIUS("Sagittarius"),
	CAPRICORN("Capricorn"),
	AQUARIUS("Aquarius"),
	PISCES("Pisces");

	final String starSign;
	
	SignOfTheStars(String starSign) {
		this.starSign = starSign;
	}
	
	public String getStarSign() {
		return starSign;
	}
	
	

}
