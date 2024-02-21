package com.example.concesionario.entities;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class Service {
    private Date date;
    private int kilometers;
    private String description;
}
