package com.example.bootcampsprint1g6.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PostCountResponseDTO {
    private Integer user_id;
    private String user_name;
    private Integer promo_products_count;
}
