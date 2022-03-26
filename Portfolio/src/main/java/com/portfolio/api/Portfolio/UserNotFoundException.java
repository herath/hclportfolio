package com.portfolio.api.Portfolio;

import org.springframework.http.HttpStatus;

public class UserNotFoundException extends RuntimeException{

	private static final String errMessage = "User not found";

	private static final long serialVersionUID = 1L;

	/**
	 * Instantiates a new Ach node limit exception.
	 */
	public UserNotFoundException() {
		super(errMessage);
	}

}
