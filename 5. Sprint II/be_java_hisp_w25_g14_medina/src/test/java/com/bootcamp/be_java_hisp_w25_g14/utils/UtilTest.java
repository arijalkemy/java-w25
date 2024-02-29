package com.bootcamp.be_java_hisp_w25_g14.utils;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;

public class UtilTest {

    public static String getStringJson(Object object) throws JsonProcessingException {
        ObjectWriter objectWriter = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE,false)
                .writer();

        return  objectWriter.writeValueAsString(object);
    }

    private String parseObjetToJsonString(Object payload) throws JsonProcessingException {
        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE,false)
                .writer();
        return writer.writeValueAsString(payload);
    }
}
