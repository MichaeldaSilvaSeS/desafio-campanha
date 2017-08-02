package br.com.api.campanha.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Socio nao existe")
public class CampanhaNaoExiste extends RuntimeException {
	private static final long serialVersionUID = 1L;

}
