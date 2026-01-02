package com.vkstech.elasticsearch;

import com.vkstech.elasticsearch.converter.LongToLocalDateConverter;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.support.ConfigurableConversionService;
import org.springframework.core.convert.support.DefaultConversionService;
import org.springframework.context.annotation.Bean;

@Configuration
public class ConversionConfig {

    @Bean
    public ConfigurableConversionService conversionService() {
        ConfigurableConversionService conversionService = new DefaultConversionService();
        conversionService.addConverter(new LongToLocalDateConverter());
        return conversionService;
    }
}

