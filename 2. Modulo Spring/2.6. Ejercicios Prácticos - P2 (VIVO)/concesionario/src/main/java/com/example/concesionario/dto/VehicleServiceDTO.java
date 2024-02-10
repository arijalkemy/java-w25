package com.example.concesionario.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@Data
public class VehicleServiceDTO {
    String date;
    String kilometers;
    String descriptions;
}
