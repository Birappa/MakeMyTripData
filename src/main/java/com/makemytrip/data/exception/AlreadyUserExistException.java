package com.makemytrip.data.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class AlreadyUserExistException extends RuntimeException {

	public AlreadyUserExistException(String errorMessage) {
		super(errorMessage);
	}
}
