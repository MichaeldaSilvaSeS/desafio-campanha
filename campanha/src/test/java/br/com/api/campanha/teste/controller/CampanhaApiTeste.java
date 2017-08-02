package br.com.api.campanha.teste.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import br.com.api.campanha.teste.ApiTeste;
import br.com.api.campanha.transfer.CampanhaDto;

public class CampanhaApiTeste extends ApiTeste {

	@Test
	public void deveAdicionarCampanhaERetornarHttp200() {
		CampanhaDto campanhaDto = new CampanhaDto();
		campanhaDto.setId_campanha(null);
		campanhaDto.setInicio_vigencia(new Date());
		campanhaDto.setFim_vigencia(new Date());
		campanhaDto.setNome_da_campanha("Campanha");

		String url = context();
		ResponseEntity<String> responseEntity = getRestTemplate().postForEntity(url, campanhaDto, String.class);

		Assert.assertNotNull(responseEntity);
		Assert.assertEquals(200, responseEntity.getStatusCodeValue());

	}

	@Test
	public void deveAlterarCampanhaERetornarHttp200() {
		Map<String, String> urlsParam = new HashMap<>();
		urlsParam.put("idCampanha", "1");
		CampanhaDto campanhaDto = new CampanhaDto();
		campanhaDto.setId_campanha(null);
		campanhaDto.setInicio_vigencia(new Date());
		campanhaDto.setFim_vigencia(new Date());
		campanhaDto.setNome_da_campanha("Campanha");

		String url = context().concat("{idCampanha}");
		ResponseEntity<String> responseEntity = getRestTemplate().exchange(url, HttpMethod.PUT,
				new HttpEntity<CampanhaDto>(campanhaDto, getHttpSimpleEntity().getHeaders()), String.class, urlsParam);

		Assert.assertNotNull(responseEntity);
		Assert.assertEquals(200, responseEntity.getStatusCodeValue());
	}

	@Test
	public void deveRemoverCampanhaERetornarHttp200() {
		Map<String, String> urlsParam = new HashMap<>();
		urlsParam.put("idCampanha", "1");

		String url = context().concat("{idCampanha}");
		ResponseEntity<String> responseEntity = getRestTemplate().exchange(url, HttpMethod.DELETE,
				getHttpSimpleEntity(), String.class, urlsParam);

		Assert.assertNotNull(responseEntity);
		Assert.assertEquals(200, responseEntity.getStatusCodeValue());
	}

	@Test
	public void deveListarCampanhasAtivosERetornarHttp200() {
		String url = context();
		ResponseEntity<String> responseEntity = getRestTemplate().exchange(url, HttpMethod.GET, getHttpSimpleEntity(),
				String.class);

		Assert.assertNotNull(responseEntity);
		Assert.assertFalse(responseEntity.getBody().isEmpty());
		Assert.assertEquals(200, responseEntity.getStatusCodeValue());
	}

	@Override
	public String context() {
		return super.context().concat("campanha/");
	}
}
