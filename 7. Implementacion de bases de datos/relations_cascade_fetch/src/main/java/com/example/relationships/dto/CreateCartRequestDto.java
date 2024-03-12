package com.example.relationships.dto;

import com.example.relationships.model.Item;
import lombok.Data;

import java.util.Set;
@Data
public class CreateCartRequestDto {
    private Set<Item> items;
}
