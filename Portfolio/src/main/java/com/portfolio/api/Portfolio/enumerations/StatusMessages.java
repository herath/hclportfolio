package com.portfolio.api.Portfolio.enumerations;

public enum StatusMessages {

	SUCCESS("Success!"),
	ERROR_OCCURRED("Error Occurred"),
	BAD_REQUEST("Bad Request, please check your request"),
	UNPREDICTED_ERROR_OCCURRED("Unpredicted Error Occurred");

	private String statusMessage;
	
	StatusMessages(String statusMessage){
		this.statusMessage = statusMessage;
	}

	public String getStatusMessage() {
		return statusMessage;
	}

	public void setStatusMessage(String statusMessage) {
		this.statusMessage = statusMessage;
	}

}
