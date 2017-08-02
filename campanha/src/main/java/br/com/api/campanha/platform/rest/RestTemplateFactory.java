package br.com.api.campanha.platform.rest;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class RestTemplateFactory {
	
	@Bean
	public RestTemplate createRestTemplate(){
		return new RestTemplate();
	}

}
