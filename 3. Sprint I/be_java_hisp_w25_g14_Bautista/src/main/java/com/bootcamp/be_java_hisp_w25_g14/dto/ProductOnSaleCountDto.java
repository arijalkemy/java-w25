package com.bootcamp.be_java_hisp_w25_g14.dto;


import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductOnSaleCountDto {
    int user_id;
    String user_name;
    int product_count;
}
