package com.example.showroom.dto.response;

import com.example.showroom.model.Item;
import lombok.*;

import java.util.Set;
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class SaleClothesDto {

    private Set<Item> items;
}
