package org.bootcamp.javazoo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductDto {

    private Integer product_id;
    private String product_name;
    private String type;
    private String brand;
    private String color;
    private String notes;

}
