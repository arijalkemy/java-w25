package carrera;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Category> categories = new ArrayList<>();
        categories.add(new Category(0, "chico", "2 km por selva y arroyos."));
        categories.add(new Category(1, "medio", "5 km por selva, arroyos y barro."));
        categories.add(new Category(2, "avanzado", "10 km por selva, arroyos, barro y escalada en piedra."));

        List<Competidor> competidorList = new ArrayList<>();
        competidorList.add(new Competidor(1, "1", "Fabian", "Rodriguez", 18, "1", "1", "O+"));
        competidorList.add(new Competidor(2, "2", "test", "test", 15, "1", "1", "O+"));
        competidorList.add(new Competidor(3, "3", "prueba", "prueba", 25, "1", "1", "O+"));
        competidorList.add(new Competidor(0, "0", "prueba0", "prueba0", 25, "1", "1", "O+"));

        List<Inscription> inscriptionList = new ArrayList<>();
        inscriptionList.add(new Inscription(0,  categories.get(0),competidorList.get(0)));
        inscriptionList.add(new Inscription(1,  categories.get(1),competidorList.get(1)));
        inscriptionList.add(new Inscription(2,  categories.get(2),competidorList.get(2)));
        inscriptionList.add(new Inscription(3,  categories.get(2),competidorList.get(3)));

        calculateTotalAmount(inscriptionList);

}

    private static void calculateTotalAmount(List<Inscription> inscriptionList) {
        int totalAmount = 0;
        for (Inscription inscription : inscriptionList) {
            totalAmount += inscription.getMonto();
        }
        System.out.println("Total por todas las categorias: "+totalAmount);
    }

    private static void calculateAmountPerCategory(List<Inscription> inscriptionList) {
        List<Integer> prices = new ArrayList<>(List.of(0, 0, 0));
        inscriptionList.forEach(inscription -> {
            prices.set(Integer.parseInt(inscription.getCategory().getId()),inscription.getMonto()+prices.get(Integer.parseInt(inscription.getCategory().getId())));
        });
        System.out.println("Total por categoria: ");
        categoryList.forEach(category -> {
            System.out.println(category.getName()+": "+prices.get(Integer.parseInt(category.getId())));
        });
    }




}
