package com.bootcamp.be_java_hisp_w25_g14.utils;

import com.bootcamp.be_java_hisp_w25_g14.dto.PostDto;
import com.bootcamp.be_java_hisp_w25_g14.dto.ProductDto;

public class ObjectFactory {
    public static PostDto generatePostDto(Integer postId, Integer userId, String date){
        return new PostDto(postId,userId,date,new ProductDto(654,"MacBook Pro", "Office", "Apple", "Silver", "M1"),100,12000.0);
    }
}
