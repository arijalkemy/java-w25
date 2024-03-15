package com.example.showroom.dto.request;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ItemReqDto {
    private String clotheId;
    private Integer quantity;
}
