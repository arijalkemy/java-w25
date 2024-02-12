package org.example;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        List<Competitor> competitors = new ArrayList<>();
        List<Registration> registrations = new ArrayList<>();
        Map<Integer,Category> categoryMap = new HashMap<>();

        Category shortCircuit = new Category(1,"Circuito chico","2 km por selva y arroyos.");
        Category mediumCircuit = new Category(2, "Circuito medio","5 km por selva, arroyos y barro.");
        Category advancedCircuit = new Category(3, "Circuito avanzado","5 km por selva, arroyos y barro.");

        categoryMap.put(1,shortCircuit);
        categoryMap.put(2,mediumCircuit);
        categoryMap.put(3,advancedCircuit);

        competitors.add(new Competitor(1,"123456789","Pablo","Araugo",23,"3225563526","3241247654","O+"));
        competitors.add(new Competitor(2,"987654321","Alejandra","Gutierrez",17,"3225563526","3241247654","O-"));
        competitors.add(new Competitor(3,"456123789","Juan","Varela",25,"3225563526","3241247654","A+"));
        competitors.add(new Competitor(4,"789123456","Diego","Gomez",18,"3225563526","3241247654","O+"));
        competitors.add(new Competitor(5,"123789456","Maria","Torres",22,"3225563526","3241247654","O+"));
        competitors.add(new Competitor(6,"654987312","Carmen","Puentes",17,"3225563526","3241247654","B+"));

        int opcion=0;
        while(opcion != 6){
            //CONSOLE
            System.out.println("------------------------------------------------------------");
            System.out.println("Bienvenido a la aplicación de registros de Carrera de la selva");
            System.out.println("1. Crear un nuevo participante e inscribirlo en una categoria.");
            System.out.println("2. Inscribir al azar.");
            System.out.println("3. Mostrar participantes inscritos.");
            System.out.println("4. Desinscribir participante.");
            System.out.println("5. Mostrar monto recaudado por categoria y monto de toda la carrera.");
            System.out.println("6. Salir.");
            System.out.println("Digite una opción: ");

            Scanner scn = new Scanner(System.in);
            Scanner scnInt = new Scanner(System.in);
            Scanner scnString = new Scanner(System.in);
            Random rnd = new Random();
            Category category1 = null;
            opcion = scn.nextInt();

            switch (opcion){
                case 1 :
                    System.out.println("-----Crear participante");
                    Competitor competitor = new Competitor();
                    System.out.print("Ingrese Id:");
                    competitor.setId(scnInt.nextInt());
                    System.out.print("Ingrese DNI:");
                    competitor.setDni(scnString.nextLine());
                    System.out.print("Ingrese Nombre:");
                    competitor.setName(scnString.nextLine());
                    System.out.print("Ingrese Apellido:");
                    competitor.setLastName(scnString.nextLine());
                    System.out.print("Ingrese Edad:");
                    competitor.setAge(scnInt.nextInt());
                    System.out.print("Ingrese Celular:");
                    competitor.setPhone(scnString.nextLine());
                    System.out.print("Ingrese Contacto emergencia:");
                    competitor.setEmergencyNumber(scnString.nextLine());
                    System.out.print("Ingrese Tipo sangre:");
                    competitor.setRh(scnString.nextLine());
                    competitors.add(competitor);
                    System.out.println("-----Categoría circuito chico: 1");
                    System.out.println("-----Categoría circuito medio: 2");
                    System.out.println("-----Categoría circuito avanzado: 3");
                    System.out.println("-----Inscribir en categoria:");
                    category1 = switch (scnInt.nextInt()) {
                        case 1 -> shortCircuit;
                        case 2 -> mediumCircuit;
                        case 3 -> advancedCircuit;
                        default -> shortCircuit;
                    };
                    int idRegistro = 1;
                    if(!(registrations.isEmpty())){
                        idRegistro = registrations.get(registrations.size()-1).getRegistrationNumber()+1;
                    }
                    registrations.add(new Registration(idRegistro, category1,competitor));
                    break;
                case 2:
                    System.out.println("Inscripción al azar");
                    int numberToRegister = rnd.nextInt(competitors.size()-3+1)+3;
                    int idRegistro2 = 1;

                    for(int i=0; i<numberToRegister; i++){
                        if(!(registrations.isEmpty())){
                            idRegistro2 = registrations.get(registrations.size()-1).getRegistrationNumber()+1;
                        }

                        while(true){
                            Category categoryR = categoryMap.get(rnd.nextInt(3)+1);
                            Competitor competitorR = competitors.get(rnd.nextInt(competitors.size()-1)+1);
                            if(!(categoryR.getName().equals("Circuito avanzado")&&competitorR.getAge()<18)){
                                registrations.add(new Registration(idRegistro2,categoryR,competitorR));
                                break;
                            }
                        }


                    }
                    break;
                case 3:
                    System.out.println("Categoria a mostrar | 1 chico | 2 Mediano | 3 Avanzado");
                    category1 = categoryMap.get(scnInt.nextInt());
                    showRegistrationsByCategry(category1,registrations);
                    break;
                case 4:
                    System.out.println("Desinscribir participante Id: ");
                    int idCompetitor = scnInt.nextInt();
                    registrations.removeIf(registration -> registration.getCompetitor().getId() == idCompetitor);
                    break;
                case 5:
                    int raceAmount = 0;
                    int raceAmountCShort = 0;
                    int raceAmountMedium = 0;
                    int raceAmountAdvance = 0;
                    for(Registration registration : registrations){
                        raceAmount += registration.getPayment();
                        if(registration.getCategory().getName().equals("Circuito chico"))
                            raceAmountCShort += registration.getPayment();
                        if(registration.getCategory().getName().equals("Circuito medio"))
                            raceAmountMedium += registration.getPayment();
                        if(registration.getCategory().getName().equals("Circuito avanzado"))
                            raceAmountAdvance += registration.getPayment();
                    }
                    System.out.println("Monto total recaudado para la carrera: "+ raceAmount);
                    System.out.println("Monto total recaudado para el circuito chico: "+ raceAmountCShort);
                    System.out.println("Monto total recaudado para el circuito medio: "+ raceAmountMedium);
                    System.out.println("Monto total recaudado para el circuito avanzado: "+ raceAmountAdvance);

                    break;
                case 6:
                    break;
                case 7:
                    showRegistrations(registrations);
                    break;
                default:
                    System.out.println("No existe la opción");
                    break;
            }
        }

    }
    public static void showRegistrationsByCategry(Category category, List<Registration> registrations){
        for(Registration registration : registrations){
            Category categoryCompetitor = registration.getCategory();
            if(category.getName().equals(categoryCompetitor.getName())){
                Competitor competitor = registration.getCompetitor();
                System.out.println("Participante: "+competitor.getName()+" "+competitor.getLastName()+" | Categoría: "+categoryCompetitor.getName()
                        +" | Número de inscripción: "+registration.getRegistrationNumber()+" | Pago: "+registration.getPayment());
            }
        }
        
    }
    public static void showRegistrations(List<Registration> registrations){
        for(Registration registration : registrations){
            Category categoryCompetitor = registration.getCategory();
                Competitor competitor = registration.getCompetitor();
                System.out.println("Participante: "+competitor.getName()+" "+competitor.getLastName()+" | Categoría: "+categoryCompetitor.getName()
                        +" | Número de inscripción: "+registration.getRegistrationNumber()+" | Pago: "+registration.getPayment());

        }

    }
}