package integracion.p1.general;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Items {
    private int id;
    private String name;
    private int quantity;
    private double price;

}
