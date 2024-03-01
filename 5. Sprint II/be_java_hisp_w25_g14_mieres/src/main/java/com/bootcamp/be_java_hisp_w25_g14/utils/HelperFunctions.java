package com.bootcamp.be_java_hisp_w25_g14.utils;

import com.bootcamp.be_java_hisp_w25_g14.dto.MessageDto;
import com.bootcamp.be_java_hisp_w25_g14.dto.PostDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Comparator;
import java.util.List;

public class HelperFunctions {
    public static List<PostDto> sortPostsByDateAscending(List<PostDto> list){
        list.sort(Comparator.comparing(PostDto::getDate));
        return list;
    }

    public static List<PostDto> sortPostsByDateDescending(List<PostDto> list){
        list.sort(Comparator.comparing(PostDto::getDate, Comparator.reverseOrder()));
        return list;
    }

    public static String serializeObject(Object obj) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString( obj );
    }
}
