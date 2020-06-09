package com.lacomania.api.controller;

import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.MailException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.lacomania.api.exception.ExceptionDTO;
import com.lacomania.api.exception.FalhaEmailException;

@ControllerAdvice(basePackages = { "com.portalsurf.api.controller" })
@RestController
@RestControllerAdvice
public class ExceptionController extends ResponseEntityExceptionHandler implements ErrorController{

	
	@ExceptionHandler({FalhaEmailException.class, MailException.class})
	protected ResponseEntity<ExceptionDTO> handleMessageException(Exception ex) {
	       String error = ex.getMessage();
	       return buildResponseEntity(new ExceptionDTO(HttpStatus.BAD_REQUEST, error, ex));
	}

	
	private ResponseEntity<ExceptionDTO> buildResponseEntity(ExceptionDTO exceptionDTO) {
		// TODO Auto-generated method stub
		return new ResponseEntity<>(exceptionDTO, exceptionDTO.getStatus());
	}


	@Override
	public String getErrorPath() {
		// TODO Auto-generated method stub
		return null;
	}

}
