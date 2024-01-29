package com.testing.model;

//@FunctionalInterface
public interface Logout {
	default void logout() {
		System.out.println("User logged out...");
	}
}
