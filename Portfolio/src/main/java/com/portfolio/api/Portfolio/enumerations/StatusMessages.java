package com.portfolio.api.Portfolio.enumerations;

public enum StatusMessages {

	SUCCESS("Success!"),
	ERROR_OCCURRED("Error Occurred"),
	INVALID_INPUT("Invalid user input, Please check your request"),
	BAD_REQUEST("Bad Request, please check your request"),
	UNPREDICTED_ERROR_OCCURRED("Unpredicted Error Occurred"),
	INVALID_ORDER_STATUS("Invalid Order Status"),
	INVALID_SECURITY_NAME("Invalid Security Name"),
	INVALID_TRANSACTION_TYPE("Valid Transaction Type"),
	INVALID_ORDER_REF("Invalid Order Ref No.");

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
