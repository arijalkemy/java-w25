import java.util.ArrayList;
import java.util.List;

public class Distributor {
    public static void main(String[] args) {
        List<Product> products = List.of(
                new Perishable("Banano", 1000, 3),
                new NoPerishable("Computador",15000000, "ELECTRONIC"),
                new Perishable("Pera", 1500, 2),
                new Perishable("Papaya", 5000, 1),
                new NoPerishable("USB",65000, "ELECTRONIC")
        );
        for (Product product: products){
            System.out.println(product);
            System.out.println(product.calculate(5));
        }
    }
}