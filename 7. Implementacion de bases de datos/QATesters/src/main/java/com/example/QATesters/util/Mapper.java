package com.example.QATesters.util;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.modelmapper.ModelMapper;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Configuration
public class Mapper {
    private static ModelMapper modelMapper = new ModelMapper();

    @Bean
    public static ModelMapper getMapper(){
        return modelMapper;
    }
}
