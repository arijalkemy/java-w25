package com.sfritz.concesionariaautos.entities;


import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Service {

    private Date date;
    private Integer kilometers;
    private String description;
}
