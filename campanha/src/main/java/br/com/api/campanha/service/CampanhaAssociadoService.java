package br.com.api.campanha.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.api.campanha.model.CampanhaAssociado;
import br.com.api.campanha.repository.CampanhaAssociadoRepository;

@Service
public class CampanhaAssociadoService {
	
	@Autowired
	private CampanhaAssociadoRepository campanhaAssociadoRepository;

	@Transactional
    public void adiciona(CampanhaAssociado campanhaAssociado) {		
		campanhaAssociadoRepository.save(campanhaAssociado);
	}
    
	public boolean verificaSePossuiCampanha(Long idSocio){
		return campanhaAssociadoRepository.verificaSePossuiCampanha(idSocio);
	}
}