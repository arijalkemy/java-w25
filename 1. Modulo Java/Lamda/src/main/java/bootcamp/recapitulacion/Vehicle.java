package bootcamp.recapitulacion;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.StringBufferInputStream;

@Data
@AllArgsConstructor
public class Vehicle {
    private String branch;
    private String model;
    private double price;

}
