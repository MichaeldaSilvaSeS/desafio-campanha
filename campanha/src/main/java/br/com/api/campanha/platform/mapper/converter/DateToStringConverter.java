package br.com.api.campanha.platform.mapper.converter;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.modelmapper.Converter;
import org.modelmapper.spi.MappingContext;
import org.springframework.stereotype.Component;

import br.com.api.campanha.platform.mapper.config.ConverterConfigurerSupport;

@Component
public class DateToStringConverter extends ConverterConfigurerSupport<Date,String>{
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	
	@Override
	protected Converter<Date,String> converter() {
		return new Converter<Date,String>() {
			@Override
			public String convert(MappingContext<Date,String> context) {
				return sdf.format(context.getSource());
			}
		};
	}
}
