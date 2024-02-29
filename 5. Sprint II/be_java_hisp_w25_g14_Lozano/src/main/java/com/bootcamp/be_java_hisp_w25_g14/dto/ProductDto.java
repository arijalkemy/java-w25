package com.bootcamp.be_java_hisp_w25_g14.dto;

import jakarta.validation.constraints.*;
import lombok.*;
import lombok.experimental.FieldDefaults;


@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductDto {

     @NotNull(message = "The product_id cannot be empty")
     @Min(value = 1, message = "the product_id cannot be 0 or negative")
     Integer product_id;

     @NotBlank(message = "The product_name cannot be empty")
     @Size(min = 1,max = 40, message = "the product_name is from 1 to 40 characters")
      @Pattern(regexp = "^[A-Za-z0-9ñÑ ]+$", message = "special characters are not allowed on product_name")
     String product_name;

     @NotBlank(message = "The type cannot be empty")
     @Size(min = 1,max = 15, message = "the type is from 1 to 15 characters")
     @Pattern(regexp = "^[A-Za-z0-9ñÑ ]+$", message = "special characters are not allowed on type")
     String type;

     @NotBlank(message = "The brand cannot be empty")
     @Size(min = 1,max = 25, message = "the brand is from 1 to 25 characters")
     @Pattern(regexp = "^[A-Za-z0-9ñÑ ]+$", message = "special characters are not allowed  on brand")
     String brand;

     @NotBlank(message = "The color cannot be empty")
     @Size(min = 1,max = 15, message = "the color is from 1 to 15 characters")
     @Pattern(regexp = "^[A-Za-z0-9ñÑ ]+$", message = "special characters are not allowed on color")
     String color;

     @Size(min = 1,max = 80, message = "the notes is from 1 to 80 characters")
     @Pattern(regexp = "^[A-Za-z0-9ñÑ ]+$", message = "special characters are not allowed on notes")
     String notes;


}
