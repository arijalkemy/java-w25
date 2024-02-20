package main.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@AllArgsConstructor
@Data
public class Dish {
    private String name;
    private double weight;
    private List<Food> foods;
}
