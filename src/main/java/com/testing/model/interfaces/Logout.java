package com.testing.model.interfaces;

//@FunctionalInterface
public interface Logout {
	default void logout() {
		System.out.println("User logged out...");
	}
}
