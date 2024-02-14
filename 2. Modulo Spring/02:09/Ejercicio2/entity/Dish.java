package main.entity;

import java.util.List;

import lombok.Data;

@Data
public class Dish {
    private String name;
    private Integer weight;
    private List<Food> foodList;

    public Dish(List<Food> foodList, String name) {
        this.name = name;
        this.foodList = foodList;
        this.weight = this.foodList.size() * 100;
    }
}
