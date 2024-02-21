package com.sfritz.concesionariaautos.dtos;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ServiceDto {

    private Date date;
    private Integer kilometers;
    private String description;
}
