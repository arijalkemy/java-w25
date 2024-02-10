import java.util.*;

public class Main {

    static Categoria chico = new Categoria(2, 1500, 1300, "Selva y arroyos");
    static Categoria medio = new Categoria(5, 2300, 2000, "Selva, arroyos y barro");
    static Categoria largo = new Categoria(10, 2800, "Selva, arroyos, barro y escalada en piedra");

    static int numeroParticipante = 1;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("Inscripción de carreras");
            System.out.println("Menu:\n1. Inscripción individual\n2. Mostrar las inscripciones actuales\n3. Salir");
            System.out.print("Escoge una opción: ");
            choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    System.out.println("Inscripción individual");
                    option1(scanner);
                    break;
                case 2:
                    System.out.println("Mostrar las inscripciones actuales");
                    System.out.println("Circuitos:\n1. Chico \n2. Medio\n3. Largo");
                    System.out.print("Opción: ");
                    int opt = Integer.parseInt(scanner.nextLine());

                    switch (opt) {
                        case 1:
                            System.out.println("Circuito chico");
                            chico.getParticipantes();
                            break;
                        case 2:
                            System.out.println("Circuito medio");
                            medio.getParticipantes();
                            break;
                        case 3:
                            System.out.println("Circuito largo");
                            largo.getParticipantes();
                            break;
                        default:
                            System.out.println("Opción inválida. Volviendo al menú");
                            break;
                    }
                    break;
                case 3:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción inválida. Intenta de nuevo.");
                    break;
            }
        } while (choice != 3);

        scanner.close();

    }

    public static void option1(Scanner sc) {
        System.out.println("Crear participante y añadirlo");

        System.out.println("Nombre: ");
        String name = sc.nextLine();
        System.out.println("name " + name);
        System.out.println("Apellido: ");
        String lastName = sc.nextLine();
        System.out.println("Edad: ");
        int age = Integer.parseInt(sc.nextLine());
        System.out.println("Celular: ");
        String telephone = sc.nextLine();
        System.out.println("Teléfono de emergencia: ");
        String telephone1 = sc.nextLine();
        System.out.println("Tipo de sangre: ");
        String bloodType = sc.nextLine();

        Participante participante1 = new Participante(numeroParticipante++, 1, name, lastName, age, telephone, telephone1, bloodType);
        System.out.println("Que carrera querés inscribir: \n1. Chico \n2. Medio\n3. Largo");
        System.out.println("Opción: ");
        int option = Integer.parseInt(sc.nextLine());

        switch (option) {
            case 1:
                System.out.println("Circuito Chico");
                if (participante1.getEdad() > 18) {
                    System.out.println("Debe pagar en esta categoría: $" + chico.getPrecioMayor());
                } else {
                    System.out.println("Debe pagar en esta categoría: $" + chico.getPrecioMenor());
                }

                chico.addParticipante(participante1);
                break;
            case 2:
                System.out.println("Circuito Medio");
                if (participante1.getEdad() > 18) {
                    System.out.println("Debe pagar en esta categoría: $" + medio.getPrecioMayor());
                } else {
                    System.out.println("Debe pagar en esta categoría: $" + medio.getPrecioMenor());
                }
                medio.addParticipante(participante1);
                break;
            case 3:
                System.out.println("Circuito Largo");
                if (participante1.getEdad() > 18) {
                    System.out.println("Debe pagar en esta categoría: $" + largo.getPrecioMayor());
                    largo.addParticipante(participante1);
                } else {
                    System.out.println("No te puedes inscribir");
                }
                break;
            default:
                System.out.println("Opción incorrecta. Volviendo al menú principal....");
                break;
        }

    }

}
