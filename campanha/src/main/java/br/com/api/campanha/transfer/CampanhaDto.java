package br.com.api.campanha.transfer;

import java.util.Date;

import lombok.Data;

@Data
public class CampanhaDto {
	private Long id_campanha;
	private String nome_da_campanha;
	private Date inicio_vigencia;
	private Date fim_vigencia;
	private Long id_time_do_coracao;
}