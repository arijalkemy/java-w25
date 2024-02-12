package integracion.p1.agencia.base;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Booking {
    private int idBooking;
    private String description;
    private  double price;
}
