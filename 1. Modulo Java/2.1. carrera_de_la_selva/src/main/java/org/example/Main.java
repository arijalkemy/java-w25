package org.example;
import java.util.ArrayList;
import java.util.List;

public class Main {
    protected static List<Category> categoryList;

    public static void main(String[] args) {
        categoryList = new ArrayList<>();
        categoryList.add(new Category("0", "Circuito chico", "2 km por selva y arroyos."));
        categoryList.add(new Category("1", "Circuito medio", "5 km por selva, arroyos y barro."));
        categoryList.add(new Category("2", "Circuito avanzado", "10 km por selva, arroyos, barro y escalada en piedra."));

        List<Competitor> competitorList = new ArrayList<>();
        competitorList.add(new Competitor("0", "Juan", "Perez", 25, "123456789", "987654321", "A+"));
        competitorList.add(new Competitor("1", "Jaime", "Solano", 21, "987654321", "1234563", "O+"));
        competitorList.add(new Competitor("2", "Maria", "Garzon", 23, "456327732", "2342342", "O+"));
        competitorList.add(new Competitor("3", "Daniela", "Salcedo", 25, "323423423", "2342342234", "O-"));

        List<Inscription> inscriptionList = new ArrayList<>();
        inscriptionList.add(new Inscription("0", competitorList.get(0), categoryList.get(0)));
        inscriptionList.add(new Inscription("1", competitorList.get(1), categoryList.get(1)));
        inscriptionList.add(new Inscription("2", competitorList.get(2), categoryList.get(2)));
        inscriptionList.add(new Inscription("3", competitorList.get(3), categoryList.get(0)));
        inscriptionList.add(new Inscription("3", competitorList.get(3), categoryList.get(1)));
        inscriptionList.add(new Inscription("3", competitorList.get(3), categoryList.get(2)));


        printInscriptionsPerCategory(inscriptionList);
        unsuscribeCompetitor(inscriptionList, "3");
        calculateAmountPerCategory(inscriptionList);
        calculateTotalAmount(inscriptionList);
    }
    private static void calculateTotalAmount(List<Inscription> inscriptionList) {
        int totalAmount = 0;
        for (Inscription inscription : inscriptionList) {
            totalAmount += inscription.getPrice();
        }
        System.out.println("Total por todas las categorias: "+totalAmount);
    }
    private static void calculateAmountPerCategory(List<Inscription> inscriptionList) {
        List<Integer> prices = new ArrayList<>(List.of(0, 0, 0));
            inscriptionList.forEach(inscription -> {
                    prices.set(Integer.parseInt(inscription.getCategory().getId()),inscription.getPrice()+prices.get(Integer.parseInt(inscription.getCategory().getId())));
            });
        System.out.println("Total por categoria: ");
        categoryList.forEach(category -> {
            System.out.println(category.getName()+": "+prices.get(Integer.parseInt(category.getId())));
        });
    }
    private static void unsuscribeCompetitor(List<Inscription> inscriptionList, String competitorId) {
        List<Inscription> inscriptionsToRemove = new ArrayList<>();
        for(Inscription inscription : inscriptionList) {
            if(inscription.getCompetitor().getId().equals(competitorId)) {
                inscriptionsToRemove.add(inscription);
            }
        }
        inscriptionList.removeIf(inscription -> inscription.getCompetitor().getId().equals(competitorId));
        System.out.println("Competidor con id "+competitorId+" desinscrito a todas las categorias");
        inscriptionsToRemove.forEach(inscription -> {
            printInscriptionsByCategoryId(inscriptionList, inscription.getCategory().getId());
        });
    }

    private static void printInscriptionsByCategoryId(List<Inscription> inscriptionList, String categoryId) {
        System.out.println("Inscripciones por categoria: "+ categoryList.get(Integer.parseInt(categoryId)).getName());
        inscriptionList.forEach(inscription -> {
            if(inscription.getCategory().getId().equals(categoryId)){
                System.out.println("Participante con inscripcion #: "
                        +inscription.getId()+": "+inscription.getCompetitor().toString());
            }
        });
    }
    private static void printInscriptionsPerCategory(List<Inscription> inscriptionList) {
        List<Inscription> shortCourseInscriptions = new ArrayList<>();
        List<Inscription> middleCourseInscriptions = new ArrayList<>();
        List<Inscription> advancedCourseInscriptions = new ArrayList<>();
        inscriptionList.forEach(inscription -> {
            if(inscription.getCategory().getId().equals(categoryList.get(0).getId())){
                shortCourseInscriptions.add(inscription);
            } else if (inscription.getCategory().getId().equals(categoryList.get(1).getId())) {
                middleCourseInscriptions.add(inscription);
            } else if (inscription.getCategory().getId().equals(categoryList.get(2).getId())) {
                advancedCourseInscriptions.add(inscription);
            }
        });
        System.out.println("Inscripciones al circuito corto");
        shortCourseInscriptions.forEach(inscription -> System.out.println("Participante con inscripcion #: "
                +inscription.getId()+": "+inscription.getCompetitor().toString()));
        System.out.println("Inscripciones al circuito medio");
        middleCourseInscriptions.forEach(inscription -> System.out.println("Participante con inscripcion #: "
                +inscription.getId()+": "+inscription.getCompetitor().toString()));
        System.out.println("Inscripciones al circuito avanzado");
        advancedCourseInscriptions.forEach(inscription -> System.out.println("Participante con inscripcion #: "
                +inscription.getId()+": "+inscription.getCompetitor().toString()));
    }

}