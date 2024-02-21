package com.example.be_java_hisp_w25_g10.dtos;

import com.example.be_java_hisp_w25_g10.entities.Product;

import java.time.LocalDate;

public record PostCreatedDto(
    int user_id,

    String date,
    Product product,
    int category,
    double price

)
{}
