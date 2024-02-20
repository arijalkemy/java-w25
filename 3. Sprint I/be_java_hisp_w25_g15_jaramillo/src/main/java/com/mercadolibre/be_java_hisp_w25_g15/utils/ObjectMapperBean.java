package com.mercadolibre.be_java_hisp_w25_g15.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.Getter;
import org.springframework.stereotype.Component;

@Component
@Getter
public class ObjectMapperBean {
    private final ObjectMapper mapper;


    public ObjectMapperBean() {
        this.mapper = new ObjectMapper();
        JavaTimeModule javaTimeModule = new JavaTimeModule();
        mapper.registerModule(javaTimeModule);
    }

}
