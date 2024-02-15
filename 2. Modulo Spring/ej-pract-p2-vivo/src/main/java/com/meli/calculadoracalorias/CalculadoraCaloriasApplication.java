package com.meli.calculadoracalorias;

import com.meli.calculadoracalorias.repository.IngredientRepositoryImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CalculadoraCaloriasApplication {

    public static void main(String[] args) {
        SpringApplication.run(CalculadoraCaloriasApplication.class, args);
        IngredientRepositoryImpl p = new IngredientRepositoryImpl();
    }

}
