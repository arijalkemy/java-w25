package AutosConsesionario.dto;

import AutosConsesionario.entity.Service;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DtoAuto {
    private int id;
    private String brand;
    private String model;
    private String manufacturingDate;
    private Integer numberOfKilometers;
    private Double price;
    private Service services;
}
