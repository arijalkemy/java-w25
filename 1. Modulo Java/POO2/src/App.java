import java.util.Arrays;

public class App {
    public static void main(String[] args) throws Exception {
        
        Distributor distributor = new Distributor(
            Arrays.asList(
            new Perishable("Jamon", 200d, 10),
            new Perishable("Queso", 300d, 1),
            new Perishable("Pan", 50d, 2),
            new Perishable("Carne", 700d, 3),
            new Perishable("Pollo", 400d, 5),
            new NoPerishable("Detergente", 100d, "Limpieza"),
            new NoPerishable("Silla", 700d, "Hogar"),
            new NoPerishable("Botella Deportiva", 500d, "Sport"),
            new NoPerishable("Libro", 600d, "Entretenimiento"),
            new NoPerishable("Mesa", 1000d, "Hogar"))
        );

        // distributor.showProducts();
        distributor.sellProducts();
    }
}
