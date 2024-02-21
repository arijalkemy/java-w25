import java.util.Arrays;
import java.util.List;

import objects.Category;
import objects.Competitor;
import objects.Inscription;

public class App {
    public static void main(String[] args) throws Exception {
        Category smallCircuit = new Category(1, "Circuito Chico", "2 km por selva y arroyos.");
        Category mediumCircuit = new Category(2, "Circuito Medio", "5 km por selva, arroyos y barro.");
        Category advancedCircuit = new Category(3, "Circuito Avanzado", "10 km por selva, arroyos, barro y escalada en piedra.");
    
        Competitor competitor1 = new Competitor(1, 12345671, "Jose", "Ramirez", 35, 12345678, 87654321, "0+");
        Competitor competitor2 = new Competitor(2, 12345672, "Marcos", "Rodriguez", 25, 12345678, 87654321, "0+");
        Competitor competitor3 = new Competitor(3, 12345673, "Pepe", "Diaz", 45, 12345678, 87654321, "0+");
        Competitor competitor4 = new Competitor(4, 12345674, "Gonza", "Doe", 15, 12345678, 87654321, "0+");
        Competitor competitor5 = new Competitor(5, 12345675, "Raul", "Diaz", 30, 12345678, 87654321, "0+");

        List<Inscription> inscritpions = Arrays.asList(new Inscription(1L, advancedCircuit, competitor5));

        
    }
}
