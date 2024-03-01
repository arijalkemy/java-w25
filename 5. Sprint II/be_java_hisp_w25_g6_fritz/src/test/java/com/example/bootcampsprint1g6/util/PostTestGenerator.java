package com.example.bootcampsprint1g6.util;

import com.example.bootcampsprint1g6.entity.Post;
import com.example.bootcampsprint1g6.entity.Product;
import com.example.bootcampsprint1g6.entity.Seller;

import java.time.LocalDate;

public class PostTestGenerator {

    static public Post getPostFromUserProductDate(Seller user, Product product, LocalDate date){
        return new Post(user, 0, date,product,123,23.4);
    }


}
