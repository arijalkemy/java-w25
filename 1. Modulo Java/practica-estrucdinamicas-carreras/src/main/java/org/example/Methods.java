package org.example;
import java.util.List;
import java.util.Scanner;

public class Methods {

    Scanner keyboard = new Scanner(System.in);

    public Methods(){

    }

    public Category seleccionarCircuito(){

        System.out.println("Seleccione el circuito que desea: \n1. Circuito chico. \n2. Circuito Medio\n3. Circuito Avanzado");
        int opc = keyboard.nextInt();
        switch (opc){
            case 1:{
                return createCircuitChico();
            }
            case 2:{
                return createCircuitMedio();
            }
            case 3:{
                return createCircuitAvanzado();
            }
            default: {
                System.out.println("Opcion no valida");
                System.exit(0);
            }
        }
        return new Category();
    }

    public int evaluateRegistration (Category category, Competitor competitor){
        if(category.getIdCircuit().equals("001")){
            if(competitor.getAge() < 18){
                return 1300;
            }else{
                return 1500;
            }
        }else if(category.getIdCircuit().equals("002")){
            if(competitor.getAge() < 18){
                return 2000;
            }else{
                return 2300;
            }
        }else if(category.getIdCircuit().equals("003") && competitor.getAge() > 18){
            return 2800;
        }
        return 0;
    }

    public Category createCircuitChico () {
        return (new Category("2 km por selva y arroyos.", "Chico", "001"));
    }

    public Category createCircuitMedio () {
        return (new Category("5 km por selva, arroyos y barro.", "Medio", "002"));
    }

    public Category createCircuitAvanzado () {
        return (new Category("10 km por selva, arroyos, barro y escalada en piedra.", "Avanzado", "003"));
    }

    public Competitor registerCompetitor (List<Inscripcion> lista){
        Competitor competitor = new Competitor();
        competitor.setCompetitorId(lista.size() + 100);
        System.out.println("INGRESE EL NOMBRE DEL PARTICIPANTE:");
        competitor.setFirstname(keyboard.nextLine());
        System.out.println("INGRESE EL APELLIDO DEL PARTICIPANTE:");
        competitor.setLastname(keyboard.nextLine());
        System.out.println("INGRESE EL DNI DEL PARTICIPANTE:");
        competitor.setDni(keyboard.nextInt());
        System.out.println("INGRESE LA EDAD DEL PARTICIPANTE:");
        competitor.setAge(keyboard.nextInt());
        System.out.println("INGRESE EL CELULAR DEL PARTICIPANTE:");
        competitor.setCellPhone(keyboard.nextInt());
        System.out.println("INGRESE UN NUMERO DE EMERGENCIA:");
        competitor.setEmergencyNumber(keyboard.nextInt());
        System.out.println("INGRESE EL TIPO DE SANDRE DEL PARTICIPANTE:");
        competitor.setBloodType(keyboard.nextLine());
        return competitor;
    }

}


