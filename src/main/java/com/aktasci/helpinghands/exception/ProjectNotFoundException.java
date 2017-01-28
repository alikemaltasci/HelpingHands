package com.aktasci.helpinghands.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "This project is not found")
public class ProjectNotFoundException extends Exception {
	private static final long serialVersionUID = 100L;

}
