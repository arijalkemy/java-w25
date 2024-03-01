package org.bootcamp.javazoo.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductDto {

    @NotNull (message = "The 'id' cannot be empty.")
    @Positive (message = "The 'id' must be greater than zero")
    private Integer product_id;

    @NotEmpty (message = "The 'name' cannot be empty.")
    @Size (max = 40, message = "The 'name' cannot exceed 40 characters.")
    @Pattern(regexp = "^[a-zA-Z0-9 ]+$", message = "The 'name' cannot have special characters (%, &, $, etc.)")
    private String product_name;

    @NotEmpty (message = "The 'type' cannot be empty.")
    @Size (max = 15, message = "The 'type' cannot exceed 15 characters.")
    @Pattern(regexp = "^[a-zA-Z0-9]+$", message = "The 'type' cannot have special characters (%, &, $, etc.) or spaces")
    private String type;

    @NotEmpty (message = "The 'brand' cannot be empty.")
    @Size (max = 25, message = "The 'brand' cannot exceed 25 characters.")
    @Pattern(regexp = "^[a-zA-Z0-9]+$", message = "The 'brand' cannot have special characters (%, &, $, etc.) or spaces")
    private String brand;

    @NotEmpty (message = "The 'color' cannot be empty.")
    @Size (max = 15, message = "The 'color' cannot exceed 15 characters.")
    @Pattern(regexp = "^[a-zA-Z0-9 ]+$", message = "The 'color' cannot have special characters (%, &, $, etc.) or spaces")
    private String color;

    @Size (max = 80, message = "The 'notes' cannot exceed 80 characters.")
    @Pattern(regexp = "^[a-zA-Z0-9 ]+$", message = "The 'notes' cannot have special characters (%, &, $, etc.)")
    private String notes;

}
