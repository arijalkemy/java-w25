package main.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DishRequestDTO {

    private String name;
    private double weight;
}
