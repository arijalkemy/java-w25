package calorias.model;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Setter
@Getter
public class Dish {
    public ArrayList<Ingredient> ingredientList;
    public String name;

    public Dish(ArrayList<Ingredient> ingredientList, String name) {
        this.ingredientList = ingredientList;
        this.name = name;
    }

    public Dish() {
    }


}
