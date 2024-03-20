package com.bootcamp.elasticSearch.util;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Mapper {
    static ModelMapper mapper = new ModelMapper();

    public static ModelMapper getMapper(){
        return mapper;
    }
}
