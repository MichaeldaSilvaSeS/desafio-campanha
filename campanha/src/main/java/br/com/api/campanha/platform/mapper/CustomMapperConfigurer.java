package br.com.api.campanha.platform.mapper;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration.AccessLevel;
import org.modelmapper.convention.MatchingStrategies;
import org.modelmapper.convention.NameTokenizers;
import org.modelmapper.convention.NameTransformers;
import org.modelmapper.convention.NamingConventions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import br.com.api.campanha.platform.mapper.MapModel.Mapper;
import br.com.api.campanha.platform.mapper.config.ModelMapperConfigurer;

@Component
public class CustomMapperConfigurer {
	
    @Autowired(required = false)
    private List<ModelMapperConfigurer> configurers;

    @Bean
    @MapModel(Mapper.DTO_TO_MODEL)
	public ModelMapper ModelToDto(){
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration()
			.setSourceNamingConvention(NamingConventions.JAVABEANS_ACCESSOR)
	     	.setSourceNameTransformer(NameTransformers.JAVABEANS_ACCESSOR)
	     	.setSourceNameTokenizer(NameTokenizers.UNDERSCORE)
	     	
			.setDestinationNamingConvention(NamingConventions.JAVABEANS_ACCESSOR)
	     	.setDestinationNameTransformer(NameTransformers.JAVABEANS_ACCESSOR)
	     	.setDestinationNameTokenizer(NameTokenizers.CAMEL_CASE)
     	;
        configure(modelMapper);
		return modelMapper;
	}
	
    @Bean
    @MapModel(Mapper.MODEL_TO_DTO)
	public ModelMapper dtoToModel(){
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration()
			.setSourceNamingConvention(NamingConventions.JAVABEANS_ACCESSOR)
	     	.setSourceNameTransformer(NameTransformers.JAVABEANS_ACCESSOR)
	     	.setSourceNameTokenizer(NameTokenizers.CAMEL_CASE)
	     	
			.setDestinationNamingConvention(NamingConventions.JAVABEANS_ACCESSOR)
	     	.setDestinationNameTransformer(NameTransformers.JAVABEANS_ACCESSOR)
	     	.setDestinationNameTokenizer(NameTokenizers.UNDERSCORE)
	     ;
        configure(modelMapper);
		return modelMapper;
	}
    
    private void configure(ModelMapper modelMapper){
        if (configurers != null) {
            for (ModelMapperConfigurer modelMapperConfigurer : configurers) {
                modelMapperConfigurer.configure(modelMapper);
            }
        }
        modelMapper.getConfiguration()	     	
	     	.setFieldAccessLevel(AccessLevel.PRIVATE)
	     	.setFieldMatchingEnabled(true)
	     	.setMatchingStrategy(MatchingStrategies.STANDARD)     	
	     	.setImplicitMappingEnabled(true)
	     	.setFullTypeMatchingRequired(false)
	     	.setSkipNullEnabled(true);        
    }
 }