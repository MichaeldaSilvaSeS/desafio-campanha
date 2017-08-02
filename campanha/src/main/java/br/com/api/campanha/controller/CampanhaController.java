package br.com.api.campanha.controller;

import java.util.Collection;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.api.campanha.model.Campanha;
import br.com.api.campanha.platform.mapper.MapModel;
import br.com.api.campanha.platform.mapper.MapModel.Mapper;
import br.com.api.campanha.service.CampanhaService;
import br.com.api.campanha.transfer.CampanhaDto;
import io.swagger.annotations.ApiOperation;

@RequestMapping("/v1/campanha")
@RestController
public class CampanhaController {
	@Autowired
	private CampanhaService campanhaService;
	
	@Autowired
	@MapModel(Mapper.DTO_TO_MODEL)
	private ModelMapper mapperDtoToModel;
	
	@Autowired
	@MapModel(Mapper.MODEL_TO_DTO)
	private ModelMapper mapperModelToDto;

	@ApiOperation(value = "Adiciona uma campanha", produces = MediaType.APPLICATION_JSON_VALUE)
	@PostMapping(value="/", consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE })
    public void adiciona(@Valid @RequestBody CampanhaDto campanhaDto) {
		campanhaDto.setId_campanha(null);
		Campanha campanha = mapperDtoToModel.map(campanhaDto, Campanha.class);
		campanhaService.adiciona(campanha);
	}
	
	@ApiOperation(value = "Atualiza campanha", produces = MediaType.APPLICATION_JSON_VALUE)
    @PutMapping(value="/{idCampanha}", consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE })
    public void atualiza(@PathVariable Long idCampanha, @Valid @RequestBody CampanhaDto campanhaDto) {
    	campanhaDto.setId_campanha(idCampanha);
    	Campanha campanha = mapperDtoToModel.map(campanhaDto, Campanha.class);
    	campanhaService.atualiza(campanha);
    }
    
    @ApiOperation(value = "Remove campanha", produces = MediaType.APPLICATION_JSON_VALUE)
    @DeleteMapping(value="/{idCampanha}", consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE })
    public void remove(@PathVariable Long idCampanha) {
    	campanhaService.remove(idCampanha);
    }
    
    @ApiOperation(value = "Seleciona uma campanha", produces = MediaType.APPLICATION_JSON_VALUE)
	@GetMapping(value="/{idCampanha}", consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE })
    public void seleciona(@PathVariable Long idCampanha) {
    	campanhaService.seleciona(idCampanha);
    }
    
    @ApiOperation(value = "Lista campanhas validas", produces = MediaType.APPLICATION_JSON_VALUE)
	@GetMapping(value="/", consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE })
	public Collection<CampanhaDto> lista(){
    	return mapperDtoToModel.map(campanhaService.lista(), new TypeToken<Collection<CampanhaDto>>() {}.getType() );
	}
}
