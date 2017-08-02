package br.com.api.campanha.teste;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import br.com.api.campanha.Application;
import lombok.Getter;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT, classes = { Application.class })
public class ApiTeste {
	
	@LocalServerPort
    private int port;
	
	@Getter
	@Autowired
	private TestRestTemplate restTemplate;
	
	@Getter
	private static HttpEntity<String> httpSimpleEntity;

	static {
		MultiValueMap<String, String> requestHeaders = new LinkedMultiValueMap<>();
		requestHeaders.add("Content-Type", MediaType.APPLICATION_JSON_VALUE);
		ApiTeste.httpSimpleEntity = new HttpEntity<>(requestHeaders);
	}
	
	public String context(){
		return "http://localhost:"+String.valueOf(port)+"/v1/";
	}
}
