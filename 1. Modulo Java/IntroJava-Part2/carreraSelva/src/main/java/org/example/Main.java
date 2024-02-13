package org.example;
import java.util.*;

public class Main {
    protected static List<Category> categories;
    protected static List<Inscription> inscriptions;

    public static void main(String[] args) {
        categories = new ArrayList<>();
        categories.add(new Category(1,"Circuito chico","2km de Selva y arroyos"));
        categories.add(new Category(2,"Circuito medio","5km de Selva,arroyos y barro"));
        categories.add(new Category(3,"Circuito avanzado","10km deSelva,arroyos,barro y escalada en priedra"));

        List<Participant> participants = new ArrayList<>();
        participants.add(new Participant(1,666666,"Pepe", "Perez",23,123456,654321,"A-"));
        participants.add(new Participant(2,77777,"Juan", "Perez",18,123456,654321,"O+"));
        participants.add(new Participant(3,88888,"Carlos", "Perez",17,123456,654321,"O-"));
        participants.add(new Participant(4,12432,"Mengano", "Peña",27,123456,654321,"O-"));
        participants.add(new Participant(5,45325,"Zutano", "Parra",35,123456,654321,"O-"));
        participants.add(new Participant(6,65452,"Fulano", "Poveda",18,123456,654321,"O-"));

        inscriptions = new ArrayList<>();
        inscriptions.add(new Inscription(1,categories.get(0),participants.get(0)));
        inscriptions.add(new Inscription(2,categories.get(2),participants.get(1)));
        inscriptions.add(new Inscription(3,categories.get(1),participants.get(2)));
        inscriptions.add(new Inscription(3,categories.get(0),participants.get(3)));
        inscriptions.add(new Inscription(3,categories.get(2),participants.get(4)));
        inscriptions.add(new Inscription(3,categories.get(1),participants.get(5)));

        System.out.println("El monto a pagar por el participante con número de inscripción " + inscriptions.get(0).getParticipant().getPartNumber() + " es de: "  + inscriptions.get(0).getAmount());
        System.out.println("-------------------------------");
        printInscriptionsPerCategory(inscriptions);
        System.out.println("-------------------------------");
        unsubscribeParticipant(5);
        System.out.println("-------------------------------");
        getTotals();
    }

    private static void printInscriptionsPerCategory(List<Inscription> inscriptionList) {
        List<Inscription> shortCourseInscriptions = new ArrayList<>();
        List<Inscription> middleCourseInscriptions = new ArrayList<>();
        List<Inscription> advancedCourseInscriptions = new ArrayList<>();
        inscriptionList.forEach(inscription -> {
            if(inscription.getCategory().getId().equals(categories.get(0).getId())){
                shortCourseInscriptions.add(inscription);
            } else if (inscription.getCategory().getId().equals(categories.get(1).getId())) {
                middleCourseInscriptions.add(inscription);
            } else if (inscription.getCategory().getId().equals(categories.get(2).getId())) {
                advancedCourseInscriptions.add(inscription);
            }
        });
        System.out.println("Inscripciones al circuito corto");
        shortCourseInscriptions.forEach(inscription -> System.out.println("Participante con inscripcion #: "
                +inscription.getInscriptionNumber()+": "+inscription.getParticipant().toString()));
        System.out.println("Inscripciones al circuito medio");
        middleCourseInscriptions.forEach(inscription -> System.out.println("Participante con inscripcion #: "
                +inscription.getInscriptionNumber()+": "+inscription.getParticipant().toString()));
        System.out.println("Inscripciones al circuito avanzado");
        advancedCourseInscriptions.forEach(inscription -> System.out.println("Participante con inscripcion #: "
                +inscription.getInscriptionNumber()+": "+inscription.getParticipant().toString()));
    }

    private static void unsubscribeParticipant(int participantNumber){
        Category category = null;
        for (Inscription inscription : inscriptions){
            if (inscription.getParticipant().getPartNumber().equals(participantNumber)){
                inscriptions.remove(inscription);
                category = inscription.getCategory();
                break;
            }
        }
        System.out.println("El usuario con id " + participantNumber + " ha sido removido de la competencia");
        System.out.println("Ahora los inscritos a la categoría " + (category != null ? category.getName() : null) + " son:");
        Category finalCategory = category;
        inscriptions.forEach(inscription -> {
            if(inscription.getCategory().getId().equals(finalCategory.getId())){
                System.out.println("Participante con inscripcion #: "
                        +inscription.getInscriptionNumber()+": "+inscription.getParticipant().toString());
            }
        });
    }

    private static void getTotals (){
        final int[] totalShort = {0};
        final int[] totalMedium = {0};
        final int[] totalAdvanced = {0};
        inscriptions.forEach(inscription -> {
            if(inscription.getCategory().getId().equals(categories.get(0).getId())){
                totalShort[0] += inscription.getAmount();
            } else if (inscription.getCategory().getId().equals(categories.get(1).getId())) {
                totalMedium[0] += inscription.getAmount();
            } else if (inscription.getCategory().getId().equals(categories.get(2).getId())) {
                totalAdvanced[0] += inscription.getAmount();
            }
        });
        int totalAmount = totalShort[0] + totalMedium[0] + totalAdvanced[0];
        System.out.println("El moto recaudado por la categoría corta es: " + totalShort[0]);
        System.out.println("El moto recaudado por la categoría media es: " + totalMedium[0]);
        System.out.println("El moto recaudado por la categoría avanzada es: " + totalAdvanced[0]);
        System.out.println("El monto total en total de todas las carreras es: "+ totalAmount);
    }
}