package br.com.api.campanha.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="tbl_campanha_associado")
public class CampanhaAssociado {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_campanha_socio")
	private Long id_campanha_socio;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="id_campanha")
	private Campanha campanha;
	
	@Column(name="id_socio")
	private Long idSocio;
	
}