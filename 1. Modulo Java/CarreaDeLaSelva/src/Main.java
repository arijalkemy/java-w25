import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 3 objetos por cada categoria
        Categoria circuitoChico = new Categoria();
        Categoria circuitoMedio = new Categoria();
        Categoria circuitoAvanzado = new Categoria();

        //llenar la info de cada categoria

        circuitoChico.setId(1);
        circuitoChico.setNombre("Circuito chico.");
        circuitoChico.setDescripcion("2 km por selva y arroyos.");

        circuitoMedio.setId(2);
        circuitoMedio.setNombre("Circuito medio.");
        circuitoMedio.setDescripcion("5km por selva, arroyos y barro.");

        circuitoAvanzado.setId(3);
        circuitoAvanzado.setNombre("Circuito avanzado.");
        circuitoAvanzado.setDescripcion("10km por selva, arroyos, barro y escalada en piedra.");

        // crear nuevo participante e inscribirlo en una categoria.

        Participante participante1 = new Participante(
                1,10001,"Juan Manuel","Restrepo",22,
                302233332, 223232323, "a-"
        );

        //lista de participantes.
        List<Participante> participantes = new ArrayList<>();
        participantes.add(participante1);

        //lista de inscripciones
        List<Inscripcion> inscripciones = new ArrayList<>();

        boolean ejecucion = true;
        while(ejecucion){
            System.out.println("Elija una opcion:" +
                    "\n1. Crear participantes." +
                    "\n2. Inscribir participante." +
                    "\n3. Desinscribir participante." +
                    "\n4. Mostrar informacion de categoria." +
                    "\n5. Calcular monto total recaudado por categoria." +
                    "\n6. Salir");
            Scanner input = new Scanner(System.in);
            int eleccion = input.nextInt();

            switch (eleccion) {
                case 1:{
                    //TODO: realizar formulario de inscripcion de participantes.
                    participantes.add(new Participante(2,100021,"Juan","Restrepo",22,
                            302233332, 223232323, "a-"
                    ));
                    participantes.add(new Participante(3,103021,"Manuel","Restrepo",14,
                            302233332, 223232323, "a-"
                    ));
                    participantes.add(new Participante(4,10012021,"Manolo","Restrepo",70,
                            302233332, 223232323, "a-"
                    ));
                } break;
                case 2:{
                    System.out.println("Ingrese el numero de participante a inscribir.");
                    input = new Scanner(System.in);
                    int numeroParticipante = input.nextInt();
                    Optional<Participante> participante = participantes.stream().filter(parti -> parti.getNumeroParticipante() == numeroParticipante)
                            .findFirst();
                    if(participante.isEmpty()){
                        System.out.println("Participante no inscrito.");
                        break;
                    }
                    Optional<Inscripcion> inscripcion = inscripciones.stream()
                            .filter(aux -> aux.getParticipante().getNumeroParticipante() == numeroParticipante)
                            .findFirst();
                    if(inscripcion.isPresent()){
                        System.out.println("El participante se encuentra inscrito.");
                        break;
                    }
                    System.out.println("Elija la categoria:" +
                            "\n1. Circuito chico." +
                            "\n2. Circuito medio." +
                            "\n3. Circuito avanzado.");
                    input = new Scanner(System.in);
                    eleccion = input.nextInt();
                    Random random = new Random();
                    switch (eleccion){
                        case 1:{
                            double valorAPagar = calcularMontoAPagar(1,participante.get().getEdad());
                            inscripciones.add(new Inscripcion(
                                    random.nextInt(101), circuitoChico,participante.get(),valorAPagar
                            ));
                            System.out.println("El valor a pagar es: " + valorAPagar);
                        } break;
                        case 2:{
                            double valorAPagar = calcularMontoAPagar(2,participante.get().getEdad());
                            inscripciones.add(new Inscripcion(
                                    random.nextInt(101), circuitoMedio,participante.get(),valorAPagar
                            ));
                            System.out.println("El valor a pagar es: " + valorAPagar);
                        } break;
                        case 3:{
                            if(participante.get().getEdad()<18){
                                System.out.println("Participante no valido para esta categoria.");
                                break;
                            }
                            double valorAPagar = calcularMontoAPagar(3,participante.get().getEdad());
                            inscripciones.add(new Inscripcion(
                                    random.nextInt(101), circuitoAvanzado,participante.get(),valorAPagar
                            ));
                            System.out.println("El valor a pagar es: " + valorAPagar);
                        } break;
                        default: break;
                    }
                } break;
                case 3:{
                    System.out.println("Ingrese el numero de participante a desinscribir.");
                    input = new Scanner(System.in);
                    int numeroParticipante = input.nextInt();
                    Optional<Inscripcion> inscripcion = inscripciones.stream()
                            .filter(aux -> aux.getParticipante().getNumeroParticipante() == numeroParticipante)
                            .findFirst();
                    if(inscripcion.isPresent()){
                        inscripciones.remove(inscripcion.get());
                        System.out.println("Parcitipante desinscrito exitosamente!");
                    } else {
                        System.out.println("No hay ningun participante registrado con este numero.");
                    }
                } break;
                case 4:{
                    System.out.println("Elija la categoria:" +
                            "\n1. Circuito chico." +
                            "\n2. Circuito medio." +
                            "\n3. Circuito avanzado.");
                    input = new Scanner(System.in);
                    eleccion = input.nextInt();
                    int finalEleccion = eleccion;
                    List<Inscripcion> inscritosCategoria = inscripciones.stream().filter(inscripcion -> inscripcion.getCategoria().getId()== finalEleccion).toList();
                    for (Inscripcion insc: inscritosCategoria
                    ) {
                        System.out.println(insc.getParticipante().toString());
                    }
                } break;
                case 5:{
                    System.out.println("Elija la categoria:" +
                            "\n1. Circuito chico." +
                            "\n2. Circuito medio." +
                            "\n3. Circuito avanzado.");
                    input = new Scanner(System.in);
                    eleccion = input.nextInt();
                    int finalEleccion = eleccion;
                    List<Inscripcion> inscritosCategoria = inscripciones.stream().filter(inscripcion -> inscripcion.getCategoria().getId()== finalEleccion).toList();
                    double totalRecaudado = 0;
                    for (Inscripcion insc: inscritosCategoria
                    ) {
                        totalRecaudado += insc.getMontoAPagar();
                    }
                    System.out.println("El total recaudado es: "+totalRecaudado);
                } break;
                case 6:{
                    ejecucion = false;
                } break;
                default: ejecucion = false;
            }
        }
    }
    public static double calcularMontoAPagar(int idCategoria, int edad){
        double valorAPagar = 0;
        if(idCategoria==1){
            if(edad<18){
                valorAPagar = 1300;
            } else{
                valorAPagar = 1500;
            }
        }
        if(idCategoria==2){
            if(edad<18){
                valorAPagar = 2000;
            } else{
                valorAPagar = 2300;
            }
        }
        if(idCategoria==3){
            valorAPagar = 2800;
        }
        return valorAPagar;
    }
}
