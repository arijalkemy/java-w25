package com.example.showroom.dto.request;

import lombok.*;
import java.util.List;

@Getter
@Setter
@Builder
public class SaleReqDto {
    private String paymentMethod;
    List<ItemReqDto> clothes;
}
