package com.example.be_java_hisp_w25_g10.entities;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Positive(message = "No puedes agregar un valor negativo")
    private int id;
    @NotBlank (message ="No puedes agregar un valor Vacio" )
    @Size(max = 15, message = "No puedes agregar un valor mayor a 15 caracteres")
    private String name;
    @NotBlank (message ="No puedes agregar un valor Vacio" )
    @Size(max = 15, message = "No puedes agregar un valor mayor a 15 caracteres")
    private String lastname;
    @NotBlank (message ="No puedes agregar un valor Vacio" )
    private RolEnum role;
}
