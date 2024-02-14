import entity.Nonperishable;
import entity.Perishable;
import entity.Product;

import java.util.ArrayList;
import java.util.List;

public class Distributor {
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();

        Product milk = new Product("Milk", 2.99);

        Perishable lettuce = new Perishable("Lettuce", 1.49, 2);

        Nonperishable cannedSoup = new Nonperishable("Canned Soup", 1.29, "Canned Goods");

        products.add(milk);

        products.add(lettuce);

        products.add(cannedSoup);

        double totalPrice = products.stream().mapToDouble(product -> product.calculate(5)).sum();

        System.out.println("El monto total es de: " + totalPrice);
    }
}
