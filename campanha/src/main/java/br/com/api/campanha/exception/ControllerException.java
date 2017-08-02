package br.com.api.campanha.exception;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerException {
	
	@ExceptionHandler(ConstraintViolationException.class)
	public void handlerConstraintViolationException(HttpServletResponse response, Exception ex) throws IOException{
		response.sendError(HttpStatus.BAD_REQUEST.value(), ex.getMessage());
	}
}