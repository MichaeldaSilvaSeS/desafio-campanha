package br.com.api.campanha.controller;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.api.campanha.model.CampanhaAssociado;
import br.com.api.campanha.platform.mapper.MapModel;
import br.com.api.campanha.platform.mapper.MapModel.Mapper;
import br.com.api.campanha.service.CampanhaAssociadoService;
import br.com.api.campanha.transfer.CampanhaAssociadoDto;
import br.com.api.campanha.transfer.PossuiCampanhasDto;
import io.swagger.annotations.ApiOperation;

@RequestMapping("/v1/associado")
@RestController
public class CampanhaAssociadoController {
	@Autowired
	private CampanhaAssociadoService campanhaAssociadoService;
	
	@Autowired
	@MapModel(Mapper.DTO_TO_MODEL)
	private ModelMapper mapperDtoToModel;
	
	@Autowired
	@MapModel(Mapper.MODEL_TO_DTO)
	private ModelMapper mapperModelToDto;

	@ApiOperation(value = "Salva associacao da campanha ao associado", produces = MediaType.APPLICATION_JSON_VALUE)
	@PostMapping(value="/", consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE })
    public void adiciona(@Valid @RequestBody CampanhaAssociadoDto campanhaAssociadoDto) {
		campanhaAssociadoDto.setId_campanha_socio(null);
		CampanhaAssociado campanhaAssociado = mapperDtoToModel.map(campanhaAssociadoDto, CampanhaAssociado.class);
		campanhaAssociadoService.adiciona(campanhaAssociado);
	}
    
	@ApiOperation(value = "Verifica campnha para socio", produces = MediaType.APPLICATION_JSON_VALUE)
	@GetMapping(value="/{idSocio}", consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE })
	public PossuiCampanhasDto verificaSePossuiCampanha(@PathVariable Long idSocio){
		PossuiCampanhasDto possuiCampanhasDto = new PossuiCampanhasDto();
		possuiCampanhasDto.setPossui_campanhas(campanhaAssociadoService.verificaSePossuiCampanha(idSocio));
		return possuiCampanhasDto;
	}
}
