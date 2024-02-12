package integracion.p1.general;

import lombok.Data;

import java.util.List;
@Data
public class Ticket {
    private Client client;
    private List<Items> itemsList;
    private double price;

    public Ticket(Client client, List<Items> itemsList) {
        this.client = client;
        this.itemsList = itemsList;

        this.price = itemsList.stream().mapToDouble(x-> x.getPrice()*x.getQuantity()).sum();
    }
}
