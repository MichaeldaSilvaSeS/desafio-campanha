package br.com.api.campanha.repository;

import java.util.Collection;
import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.api.campanha.model.Campanha;

@Repository
public interface CampanhaRepository extends JpaRepository<Campanha, Long>{
	@Query("SELECT c FROM Campanha c WHERE c.fimVigencia >= :dataDaConsulta ")
	public Collection<Campanha> listar(@Param("dataDaConsulta") Date dataDaConsulta);
	//ORDER BY c.fimVigencia ASC
	@Query("SELECT c FROM Campanha c "
			+ "WHERE :inicioVigencia BETWEEN c.inicioVigencia and c.fimVigencia "
			+ "OR :fimVigencia BETWEEN c.inicioVigencia and c.fimVigencia "
			+ "ORDER BY c.fimVigencia ASC ")
	public Collection<Campanha> listarNoPeriodo(@Param("inicioVigencia") Date inicioVigencia, @Param("fimVigencia") Date fimVigencia);

	//ORDER BY c.fimVigencia ASC
	@Query("SELECT CASE WHEN COUNT(c.idCampanha) > 0 THEN true ELSE false END "
			+ "FROM Campanha c "
			+ "WHERE ( ( :inicioVigencia BETWEEN c.inicioVigencia and c.fimVigencia) "
			+ "OR ( :fimVigencia BETWEEN c.inicioVigencia and c.fimVigencia) ) ")
	public boolean verificarSeExisteNoPeriodo(@Param("inicioVigencia") Date inicioVigencia, @Param("fimVigencia") Date fimVigencia);
	
	@Query("SELECT CASE WHEN COUNT(c.idCampanha) > 0 THEN true ELSE false END "
			+ "FROM Campanha c WHERE c.idCampanha = :idCampanha ")
	public boolean verificarSeExiste(@Param("idCampanha") Long idCampanha);
}
