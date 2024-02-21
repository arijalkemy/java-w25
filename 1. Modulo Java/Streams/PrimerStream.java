package Streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PrimerStream {
    public static void main(String[] args) {
        ArrayList<Carro> carros = new ArrayList<>() {{
            add(new Carro("Ford", "Fiesta", 1990));
            add(new Carro("Nissan", "Tiida", 2020));
            add(new Carro("Mazda", "6", 2024));
            add(new Carro("Toyota", "Corolla", 1985));
        }};

        List<Carro> carrosNuevos = carros.stream()
                                        .filter(carro -> carro.año > 2000)
                                        .collect(Collectors.toList());
        System.out.println(carrosNuevos);
        
    }
}
