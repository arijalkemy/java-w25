package com.social.meli.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.social.meli.dto.response.ProductDto;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import java.time.LocalDate;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
public class PostDTO {
    @JsonProperty("user_id")
    @Positive(message = "El id debe ser un valor positivo")
    @NotNull(message = "El id de usuario no puede estar vacio")
    Integer userId;
    @NotNull(message = "La fecha no puede estar vacia")
    @JsonFormat(pattern = "dd-MM-yyyy")
    LocalDate date;
    @Valid ProductDto product;
    @NotNull(message = "La categoria no puede estar vacia")
    Integer category;
    @NotNull(message = "El precio de usuario no puede estar vacio")
    @Max(value = 10000000L, message = "El valor supera el valor maximo aceptado(10millones)")
    @Positive(message = "El precio debe ser positivo")
    Double price;


}
