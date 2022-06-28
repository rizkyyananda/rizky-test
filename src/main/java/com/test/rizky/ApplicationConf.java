package com.test.rizky;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConf {
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
