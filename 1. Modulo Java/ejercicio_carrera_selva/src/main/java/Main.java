import entity.Category;
import entity.Competitor;
import entity.Inscription;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Category shortCircuit = new Category(1, "Circuito corto", "2 km por selva y arroyos.");
        Category middleCircuit = new Category(2, "Circuito medio", "5 km por selva, arroyos y barro.");
        Category advanceCircuit = new Category(3, "Circuito avanzado", "10 km por selva, arroyos, barro y escalada en piedra.");

        Competitor firstCompetitor = new Competitor("123", "1212341234", "Pedro", "Lopez", 18, 1212341234, 1212341234, "0+");
        Competitor secondCompetitor = new Competitor("124", "1212341235", "Juan", "Perez", 20, 1212341235, 1212341235, "0+");
        Competitor thirdCompetitor = new Competitor("125", "1212341236", "Maria", "Gonzalez", 19, 1212341236, 1212341236, "0+");
        Competitor fourthCompetitor = new Competitor("126", "1212341237", "Miguel", "Ohara", 19, 1212341236, 1212341236, "0+");
        Competitor fifthCompetitor = new Competitor("127", "1212341238", "Carla", "Rodriguez", 23, 1212341236, 1212341236, "0+");

        Inscription firstInscription = new Inscription(1234, shortCircuit, firstCompetitor);
        Inscription secondInscription = new Inscription(1235, shortCircuit, secondCompetitor);
        Inscription thirdInscription = new Inscription(1236, shortCircuit, thirdCompetitor);
        Inscription fourthInscription = new Inscription(1235, middleCircuit, fourthCompetitor);
        Inscription fifthInscription = new Inscription(1236, advanceCircuit, fifthCompetitor);

        List<Inscription> race = new ArrayList<>();

        addInscriptionSafely(race, firstInscription);
        addInscriptionSafely(race, secondInscription);
        addInscriptionSafely(race, thirdInscription);
        addInscriptionSafely(race, fourthInscription);
        addInscriptionSafely(race, fifthInscription);

        System.out.println("Inscripciones en la primera categoria:");
        race.stream().filter(inscription -> inscription.getCategory() == shortCircuit).forEach(System.out::println);

        race.remove(firstInscription);

        System.out.println("Elimino al primer competidor:");
        race.stream().filter(inscription -> inscription.getCategory() == shortCircuit).forEach(System.out::println);

        double shortCircuitTotal = race.stream()
                .filter(inscription -> inscription.getCategory().equals(shortCircuit))
                .mapToDouble(Inscription::getAmount)
                .sum();
        System.out.println("Total amount for short circuit category: " + shortCircuitTotal);

        double middleCircuitTotal = race.stream()
                .filter(inscription -> inscription.getCategory().equals(middleCircuit))
                .mapToDouble(Inscription::getAmount)
                .sum();
        System.out.println("Total amount for middle circuit category: " + middleCircuitTotal);

        double advanceCircuitTotal = race.stream()
                .filter(inscription -> inscription.getCategory().equals(advanceCircuit))
                .mapToDouble(Inscription::getAmount)
                .sum();
        System.out.println("Total amount for advance circuit category: " + advanceCircuitTotal);

        double totalAmount = race.stream()
                .mapToDouble(Inscription::getAmount)
                .sum();

        System.out.println("Total amount for all categories: " + totalAmount);
    }

    public static void addInscriptionSafely(List<Inscription> race, Inscription newInscription) {
        boolean isRegistered = race.stream().anyMatch(inscription ->
                inscription.getCompetitor().equals(newInscription.getCompetitor()));

        if(isRegistered) {
            throw new IllegalArgumentException("Competitor is already registered.");
        } else {
            race.add(newInscription);
        }
    }
}
