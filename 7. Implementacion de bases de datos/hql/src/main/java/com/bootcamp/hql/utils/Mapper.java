package com.bootcamp.hql.utils;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.modelmapper.ModelMapper;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Mapper {

    static final ModelMapper modelMapper = new ModelMapper();

    public static ModelMapper getMapper() {
        return modelMapper;
    }

}
