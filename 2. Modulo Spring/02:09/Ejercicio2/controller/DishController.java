package main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import main.dto.FoodDTO;
import main.service.DishService;

@RestController
@RequestMapping("/dish")
public class DishController {
    @Autowired
    private DishService dishService;

    // 1
    @GetMapping("getTotalCalories/{dish}/{calories}")
    @ResponseBody
    public ResponseEntity<Integer> getTotalCalories(@PathVariable String dish, @PathVariable Integer calories) {
        Integer total = dishService.getTotalCalories(dish, calories);
        if (total > 0) {
            return new ResponseEntity<>(total, HttpStatusCode.valueOf(200));
        }
        return new ResponseEntity<>(0, HttpStatusCode.valueOf(404));
    }

    // 2
    @GetMapping("getFoodList/{dish}/{calories}")
    @ResponseBody
    public ResponseEntity<List<FoodDTO>> getFoodList(@PathVariable String dish, @PathVariable Integer calories) {
        List<FoodDTO> foodList = dishService.getFoodList(dish, calories);
        if (foodList.size() > 0) {
            return new ResponseEntity<>(foodList, HttpStatusCode.valueOf(200));
        }
        return new ResponseEntity<>(foodList, HttpStatusCode.valueOf(404));
    }

    // 3
    @GetMapping("getMostCaloricFood/{dish}/{calories}")
    @ResponseBody
    public ResponseEntity<FoodDTO> getMostCaloricFood(@PathVariable String dish, @PathVariable Integer calories) {
        FoodDTO food = dishService.getMostCaloricFood(dish, calories);
        if (food.getName() != null) {
            return new ResponseEntity<>(food, HttpStatusCode.valueOf(200));
        }
        return new ResponseEntity<>(food, HttpStatusCode.valueOf(404));
    }
}
