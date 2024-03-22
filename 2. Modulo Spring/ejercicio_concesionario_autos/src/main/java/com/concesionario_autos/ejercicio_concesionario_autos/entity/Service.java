package com.concesionario_autos.ejercicio_concesionario_autos.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Service {
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;
    private Long Kilometers;
    private String description;
}
