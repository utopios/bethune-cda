package com.brody.ebankingbackend.mappers;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperTools {
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
