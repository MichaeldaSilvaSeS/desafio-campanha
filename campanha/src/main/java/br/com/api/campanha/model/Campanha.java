package br.com.api.campanha.model;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Data
@Entity
@Table(name="tbl_campanha")
public class Campanha implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_campanha")
	private Long idCampanha;
	
	@Column(name="den_campanha")
	private String nomeDaCampanha;
	
	@Temporal(TemporalType.DATE)
	@Column(name="dt_inicio_vigencia")
	private Date inicioVigencia;
	
	@Temporal(TemporalType.DATE)
	@Column(name="dt_fim_vigencia")
	private Date fimVigencia;
	
	@Column(name="id_time_do_coracao")
	private Long idDoTimeDoCoracao;
	
	public void somaMaisUmDia(Calendar calendario){
		calendario.setTime(getFimVigencia());
		calendario.add(Calendar.DAY_OF_YEAR, 1);
		setFimVigencia(calendario.getTime());
	}
	
	public boolean ehMesmaDataDeFimDaVigencia(Campanha outraCampanha){
		return getFimVigencia().compareTo(outraCampanha.getFimVigencia()) == 0;
	}
}