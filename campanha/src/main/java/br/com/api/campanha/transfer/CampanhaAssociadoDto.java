package br.com.api.campanha.transfer;

import lombok.Data;

@Data
public class CampanhaAssociadoDto {	
	private Long id_campanha_socio;	
	private CampanhaDto campanha;	
	private Long idSocio;	
}