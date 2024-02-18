package com.example.DEPORTESFINAL.Modelo;


import org.springframework.web.bind.annotation.ResponseBody;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data


public class Persona {
    private String Nombre;
    private String Apellido;
    private String Edad;

}
