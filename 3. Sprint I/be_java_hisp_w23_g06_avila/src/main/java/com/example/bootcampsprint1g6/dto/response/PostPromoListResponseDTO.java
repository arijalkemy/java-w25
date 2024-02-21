package com.example.bootcampsprint1g6.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostPromoListResponseDTO {
    private Integer user_id;
    private String user_name;
    private List<PostPromoResponseDTO> posts;
}