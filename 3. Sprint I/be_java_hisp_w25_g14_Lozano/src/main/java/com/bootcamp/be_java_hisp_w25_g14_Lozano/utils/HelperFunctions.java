package com.bootcamp.be_java_hisp_w25_g14_Lozano.utils;

import com.bootcamp.be_java_hisp_w25_g14_Lozano.dto.PostDto;

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
}
