package org.example.carselling.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@AllArgsConstructor
@Data
public class Services {

    private Date date;
    private double kilometers;
    private String descriptions;
}
