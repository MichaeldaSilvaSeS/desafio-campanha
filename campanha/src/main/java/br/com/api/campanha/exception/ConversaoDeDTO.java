package br.com.api.campanha.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Socio nao existe")
public class ConversaoDeDTO extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public ConversaoDeDTO(Throwable t) {
		super(t);
	}
}
