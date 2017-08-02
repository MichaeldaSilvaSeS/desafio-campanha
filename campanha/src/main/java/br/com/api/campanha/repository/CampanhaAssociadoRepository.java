package br.com.api.campanha.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.api.campanha.model.CampanhaAssociado;

@Repository
public interface CampanhaAssociadoRepository extends JpaRepository<CampanhaAssociado, Long> {
	@Query("SELECT CASE WHEN COUNT(ca.id_campanha_socio) > 0 THEN true ELSE false END "
			+ "FROM CampanhaAssociado ca JOIN ca.campanha c WHERE ca.idSocio = :idSocio ")
	public boolean verificaSePossuiCampanha(@Param("idSocio") Long idSocio);
}
