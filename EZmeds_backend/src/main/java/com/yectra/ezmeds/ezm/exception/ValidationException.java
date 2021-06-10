package com.yectra.ezmeds.ezm.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ValidationException extends MissingServletRequestParameterException {
	private static final long serialVersionUID = 3416786238928623724L;
	
    public ValidationException(String message, String parameterType) {
        super(message, parameterType);
    }
    
}
