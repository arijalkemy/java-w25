import java.util.*;

public class Race {

    public static Scanner scanner = new Scanner(System.in);
    public static List<Category> categories = new ArrayList<>();
    public static List<Participant> participants = new ArrayList<>();
    public static List<Inscription> inscriptions = new ArrayList<>();

    public static void fillCategories() {
        categories.add(new Category(1, "Circuito chico", "2 km por selva y arroyos", 1300, 1500));
        categories.add(new Category(2, "Circuito medio", "5 km por selva, arroyos y barro", 2000, 2300));
        categories.add(new Category(3, "Circuito avanzado", "10 km por selva, arroyos, barro y escalada en piedra.", -1, 2800));
    }

    public static Participant getParticipant() {
        Participant participant = new Participant();
        System.out.println("Enter dni");
        participant.setDni(scanner.next());
        System.out.println("Enter name");
        participant.setName(scanner.next());
        System.out.println("Enter last name");
        participant.setLastName(scanner.next());
        System.out.println("Enter your age");
        participant.setAge(scanner.nextInt());
        System.out.println("Enter blood group");
        participant.setBloodGroup(scanner.next());
        System.out.println("Enter mobile phone");
        participant.setMobilePhone(scanner.next());
        System.out.println("Enter emergency phone");
        participant.setEmergencyPhone(scanner.next());
        return participant;
    }


    public static Category getCategory() {
        System.out.println("Choose category");
        for(int i = 0; i < categories.size(); i++){
            System.out.println(i+" "+categories.get(i).getName());
        }
        int id = scanner.nextInt();
        return categories.get(id);
    }

    public static void run() {
        Race.fillCategories();
        int option = -1;
        while(option != 0){
            System.out.println("Enter option");
            System.out.println("1. Add participant");
            System.out.println("2. Show inscriptions per category");
            System.out.println("3. Delete inscription of participant by dni");
            System.out.println("4. Calculate total");
            System.out.println("0. Exit");
            option = scanner.nextInt();
            switch (option){
                case 1:
                    Participant participant = getParticipant();
                    participants.add(participant);
                    Category category = getCategory();
                    inscriptions.add(new Inscription(category, participant));
                    break;
                case 2:
                    Category category1 = getCategory();
                    for (Inscription inscription : inscriptions) {
                        if (inscription.getCategory().getId() == category1.getId()) {
                            System.out.println(inscription.getId() + " Name: " + inscription.getParticipant().getName() + " Amount: " + inscription.getAmount());
                        }
                    }
                    break;
                case 3:
                    int index = -1;
                    System.out.println("Enter dni of participant");
                    String dni = scanner.next();
                    for (int i = 0; i < inscriptions.size(); i++) {
                        if (inscriptions.get(i).getParticipant().getDni().equals(dni) ) {
                            index = i;
                        }
                    }
                    if(index != -1){
                        Category categoryParticipant = inscriptions.get(index).getCategory();
                        inscriptions.remove(index);
                        for (Inscription inscription: inscriptions) {
                            if (inscription.getCategory().getId() == categoryParticipant.getId()) {
                                System.out.println(inscription.getId() + " Name: " + inscription.getParticipant().getName() + " Amount: " + inscription.getAmount());
                            }
                        }
                    }else
                        System.out.println("Error finding inscription");
                    break;
                case 4:
                    Map<Integer, Integer> dicSum = new HashMap<>();
                    for(Category categorysum: categories){
                        dicSum.put(categorysum.getId(), 0);
                    }
                    for(Inscription inscription: inscriptions){
                        int categoryId = inscription.getCategory().getId();
                        int currentAmount = inscription.getAmount();
                        dicSum.put(categoryId, dicSum.get(categoryId)+currentAmount);
                    }
                    int total = 0;
                    for(Category categorysum: categories){
                        int sumCurrent = dicSum.get(categorysum.getId());
                        System.out.println("Category: "+categorysum.getId()+" Sum: "+ sumCurrent);
                        total += sumCurrent;
                    }
                    System.out.println("Total: "+total);
                    break;
                default:
                    System.out.println("Option not found");
            }
        }
    }
}
