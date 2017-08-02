package br.com.api.campanha.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.api.campanha.exception.CampanhaNaoExiste;
import br.com.api.campanha.model.Campanha;
import br.com.api.campanha.repository.CampanhaRepository;

@Service
public class CampanhaService {
	
	@Autowired
	private CampanhaRepository campanhaRepository;
	
	@Transactional
    public void adiciona(Campanha campanha) {
		if(campanhaRepository.verificarSeExisteNoPeriodo(campanha.getInicioVigencia(),campanha.getFimVigencia())){
			List<Campanha> campanhasNoPeriodo = new ArrayList<Campanha>(campanhaRepository.listarNoPeriodo(campanha.getInicioVigencia(),campanha.getFimVigencia()));
			Calendar calendario = Calendar.getInstance();
			for(Campanha campanhaNoPeriodo: campanhasNoPeriodo)
				campanhaNoPeriodo.somaMaisUmDia(calendario);
			
			for(int indexCampanha = 0; indexCampanha < campanhasNoPeriodo.size(); indexCampanha++){
				Campanha campanhaNoPeriodo = campanhasNoPeriodo.get(indexCampanha);
				for(int indexOutraCampanha = indexCampanha + 1; indexOutraCampanha < campanhasNoPeriodo.size(); indexOutraCampanha++){
					Campanha outraCampanhaNoPeriodo = campanhasNoPeriodo.get(indexOutraCampanha);
					if(campanhaNoPeriodo.ehMesmaDataDeFimDaVigencia(outraCampanhaNoPeriodo))
						outraCampanhaNoPeriodo.somaMaisUmDia(calendario);
				}
			}
			campanhaRepository.save(campanhasNoPeriodo);
		}
		campanhaRepository.save(campanha);
	}
	
    @Transactional
    public void atualiza(Campanha campanha) {    	
    	if(!campanhaRepository.verificarSeExiste(campanha.getIdCampanha()))
    		throw new CampanhaNaoExiste();
    	
    	campanhaRepository.save(campanha);		
    }

    @Transactional
    public void remove(Long idCampanha) {
    	if(!campanhaRepository.verificarSeExiste(idCampanha))
			throw new CampanhaNaoExiste();
    	
    	campanhaRepository.delete(idCampanha);
    }
    
    public Campanha seleciona(Long idCampanha) {    	
    	if(!campanhaRepository.verificarSeExiste(idCampanha))
    		throw new CampanhaNaoExiste();
    	
    	return campanhaRepository.findOne(idCampanha);
    }
    
	public Collection<Campanha> lista(){
		return campanhaRepository.listar(new Date());
	}
}