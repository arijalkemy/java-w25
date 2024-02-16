package com.mercadolibre.calculadoracalorias.dto;

public class DishResponseDTO extends DishDTO {
  private Integer calories;
  private IngredientDTO caloric;

  public DishResponseDTO(DishDTO dish) {
    this.setIngredients(dish.getIngredients());
    this.setName(dish.getName());
  }

  public DishResponseDTO() {
  }

  public Integer getCalories() {
    return calories;
  }

  public void setCalories(Integer calories) {
    this.calories = calories;
  }

  public IngredientDTO getCaloric() {
    return caloric;
  }

  public void setCaloric(IngredientDTO caloric) {
    this.caloric = caloric;
  }
}
