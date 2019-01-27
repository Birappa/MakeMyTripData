package com.makemytrip.data.exception;

import java.util.Date;

public class ErrorResponse {

	private Date timestamp;
	private int status;
	private String errorMessage;
	
	public ErrorResponse(Date timestamp, int status, String errorMessage) {
		super();
		this.timestamp = timestamp;
		this.status = status;
		this.errorMessage = errorMessage;
	}
	
}
