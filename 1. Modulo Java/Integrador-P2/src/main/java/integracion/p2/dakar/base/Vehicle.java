package integracion.p2.dakar.base;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public abstract class Vehicle {
    private double speed;
    private double acceleration;
    private double turnAngle;
    private String patent;
    private  double weigth;
    private int wheels;


}
