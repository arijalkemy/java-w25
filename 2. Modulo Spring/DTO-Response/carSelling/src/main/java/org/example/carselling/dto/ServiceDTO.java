package org.example.carselling.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ServiceDTO {
    private Date date;
    private Double kilometers;
    private String descriptions;

}
