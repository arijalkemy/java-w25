package main;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner tecla = new Scanner(System.in);

        List<Object> categoriaCircuitoChico = new LinkedList<>();
        List<Object> categoriaCircuitoMedio = new LinkedList<>();
        List<Object> categoriaCircuitoAvanzado = new LinkedList<>();

        categoriaCircuitoChico.add(0, "1");
        categoriaCircuitoChico.add(1, "Circuito Chico");
        categoriaCircuitoChico.add(2, "2 km por selva y arroyos");

        categoriaCircuitoMedio.add(0, "2");
        categoriaCircuitoMedio.add(1, "Circuito Medio");
        categoriaCircuitoMedio.add(2, "5 km por selva - arroyos y barro");

        categoriaCircuitoAvanzado.add(0, "3");
        categoriaCircuitoAvanzado.add(1, "Circuito Avanzado");
        categoriaCircuitoAvanzado.add(2, "10 km por selva - arroyos - barro y escalada en piedra");

        System.out.println("DATOS DE LAS CATEGORIAS: " + categoriaCircuitoChico + " - " + categoriaCircuitoMedio + " - " + categoriaCircuitoAvanzado);
        System.out.println(" ");

        Map<Integer, List<Object>> incritosCircuitoChico = new HashMap<>();
        Map<Integer, List<Object>> incritosCircuitoMedio = new HashMap<>();
        Map<Integer, List<Object>> incritosCircuitoAvanzado = new HashMap<>();

        boolean programa = true;
        while (programa) {
            System.out.println("******************* MENU *******************");
            System.out.println("----------------------------------------------------");
            System.out.println("Escoja una de las siguientes opciones: ");
            System.out.println("1. Inscribir a un participante");
            System.out.println("2. Ver todos los inscritos en una categoria");
            System.out.println("3. Desinscribir a un participante");
            System.out.println("4. Monto total recaudado por cada categoria y el total de toda la carrera");
            System.out.println("5. Salir");
            int opcionMenu = tecla.nextInt();

            if (opcionMenu == 5){
                programa = false;
                break;
            }

            List<Object> infoParticipante = new ArrayList<>();

                if (opcionMenu == 1) {

                    System.out.println("**** REALIZAR INSCRIPCION ****");

                    System.out.println("Ingrese numero de inscripcion (DNI): ");
                    int dni = tecla.nextInt();

                    System.out.println("Nombre: ");
                    String nombre = tecla.next();

                    System.out.println("Apellido: ");
                    String apellido = tecla.next();

                    System.out.println("Edad: ");
                    int edad = tecla.nextInt();

                    int categoriaAparticipar = 0;
                    int montoAPagar = 0;

                    if (edad < 18) {
                        boolean bandera = true;
                        while (bandera) {
                            System.out.println("Solo puedes participar en los circuitos: 1. circuito chico 2. circuito medio ");
                            System.out.println("Ingresa el numero del circuito al que deseas inscribirte: ");
                            categoriaAparticipar = tecla.nextInt();
                            if (categoriaAparticipar == 1 || categoriaAparticipar == 2) {
                                bandera = false;
                            }

                        }

                    } else {
                        System.out.println("Puedes participar en los circuitos: 1. circuito chico 2. circuito medio 3. circuito avanzado ");
                        System.out.println("Ingresa el numero del circuito al que deseas inscribirte: ");
                        categoriaAparticipar = tecla.nextInt();
                    }

                    if (categoriaAparticipar == 1) {
                        if (edad < 18) {
                            montoAPagar = 1300;
                            System.out.println("El monto a pagar es: $" + montoAPagar);
                        } else {
                            montoAPagar = 1500;
                            System.out.println("El monto a pagar es: $" + montoAPagar);
                        }
                    } else {
                        if (categoriaAparticipar == 2) {
                            if (edad < 18) {
                                montoAPagar = 2000;
                                System.out.println("El monto a pagar es: $" + montoAPagar);
                            } else {
                                montoAPagar = 2300;
                                System.out.println("El monto a pagar es: $" + montoAPagar);
                            }
                        } else {
                            montoAPagar = 2800;
                            System.out.println("El monto a pagar es: $" + montoAPagar);
                        }
                    }
                    System.out.println("Celular: ");
                    String celular = tecla.next();

                    System.out.println("Numero de emergencia: ");
                    String celEmergencia = tecla.next();

                    System.out.println("Grupo sanguineo: ");
                    String rh = tecla.next();

                    infoParticipante.add(categoriaAparticipar);
                    infoParticipante.add(nombre);
                    infoParticipante.add(apellido);
                    infoParticipante.add(edad);
                    infoParticipante.add(montoAPagar);
                    infoParticipante.add(celular);
                    infoParticipante.add(celEmergencia);
                    infoParticipante.add(rh);

                    if (categoriaAparticipar == 1) {
                        incritosCircuitoChico.put(dni, infoParticipante);
                        System.out.println("**** Quedaste inscrito en el circuito chico ****");
                    } else {
                        if (categoriaAparticipar == 2) {
                            incritosCircuitoMedio.put(dni, infoParticipante);
                            System.out.println("**** Quedaste inscrito en el circuito medio ****");
                        } else {
                            incritosCircuitoAvanzado.put(dni, infoParticipante);
                            System.out.println("**** Quedaste inscrito en el circuito avanzado ****");
                        }
                    }
                }
             else {
                if (opcionMenu == 2) {
                    System.out.println("De cual categoria desea ver los participantes? 1. circuito Chico 2. Circuito Medio 3. Circuito Avanzado: ");
                    int opcionCategoriaAVer = tecla.nextInt();
                    if (opcionCategoriaAVer == 1) {
                        System.out.println("PARTICIPANTES INSCRITOS AL CIRCUITO CHICO " + incritosCircuitoChico);
                    } else {
                        if (opcionCategoriaAVer == 2) {
                            System.out.println("PARTICIPANTES INSCRITOS AL CIRCUITO MEDIO " + incritosCircuitoMedio);
                        } else {
                            System.out.println("PARTICIPANTES INSCRITOS AL CIRCUITO AVANZADO " + incritosCircuitoAvanzado);
                        }
                    }
                } else {
                    if (opcionMenu == 3) {
                        System.out.println("A que categoria pertenece el participante que desea desinscribir: 1. circuito Chico 2. Circuito Medio 3. Circuito Avanzado: ");
                        int desinscribir = tecla.nextInt();

                        if (desinscribir == 1) {
                            System.out.println("Ingrese el dni del participante a eliminar: ");
                            int dniRemove = tecla.nextInt();
                            List<Object> eliminado = incritosCircuitoChico.remove(dniRemove);

                            if (eliminado != null) {
                                System.out.println("Participante eliminado: " + eliminado);
                            } else {
                                System.out.println("No se encontró ningún participante con el dni " + dniRemove);
                            }

                            // Imprimir el diccionario actualizado
                            System.out.println("Listado actualizado: " + incritosCircuitoChico);

                        } else {
                            if (desinscribir == 2) {
                                System.out.println("Ingrese el dni del participante a eliminar: ");
                                int dniRemove = tecla.nextInt();
                                List<Object> eliminado = incritosCircuitoMedio.remove(dniRemove);

                                if (eliminado != null) {
                                    System.out.println("Participante eliminado: " + eliminado);
                                } else {
                                    System.out.println("No se encontró ningún participante con el dni " + dniRemove);
                                }
                                // Imprimir el diccionario actualizado
                                System.out.println("Listado actualizado: " + incritosCircuitoMedio);
                            } else {
                                System.out.println("Ingrese el dni del participante a eliminar: ");
                                int dniRemove = tecla.nextInt();
                                List<Object> eliminado = incritosCircuitoAvanzado.remove(dniRemove);

                                if (eliminado != null) {
                                    System.out.println("Participante eliminado: " + eliminado);
                                } else {
                                    System.out.println("No se encontró ningún participante con el dni " + dniRemove);
                                }
                                // Imprimir el diccionario actualizado
                                System.out.println("Listado actualizado: " + incritosCircuitoAvanzado);
                            }
                        }
                    } else {
                        int sumaTotalChico = 0;
                        int sumaTotalMedio = 0;
                        int sumaTotalAvanzado = 0;
                        int sumaTotal = 0;

                        for (Map.Entry<Integer, List<Object>> montoTotal : incritosCircuitoChico.entrySet()) {
                            List<Object> valores = montoTotal.getValue();
                            int montoCircuito = 0;
                            Object montoCircuitoObjeto = valores.get(4);
                            if (montoCircuitoObjeto instanceof Integer) {
                                montoCircuito = (int) montoCircuitoObjeto;
                            }
                            sumaTotalChico = sumaTotalChico + montoCircuito;
                        }
                        System.out.println("Monto total recaudado de la categoria chico: " + sumaTotalChico);

                        for (Map.Entry<Integer, List<Object>> montoTotal : incritosCircuitoMedio.entrySet()) {
                            List<Object> valores = montoTotal.getValue();
                            int montoCircuito = 0;
                            Object montoCircuitoObjeto = valores.get(4);
                            if (montoCircuitoObjeto instanceof Integer) {
                                montoCircuito = (int) montoCircuitoObjeto;
                            }
                            sumaTotalMedio = sumaTotalMedio + montoCircuito;
                        }
                        System.out.println("Monto total recaudado de la categoria medio: " + sumaTotalMedio);

                        for (Map.Entry<Integer, List<Object>> montoTotal : incritosCircuitoAvanzado.entrySet()) {
                            List<Object> valores = montoTotal.getValue();
                            int montoCircuito = 0;
                            Object montoCircuitoObjeto = valores.get(4);
                            if (montoCircuitoObjeto instanceof Integer) {
                                montoCircuito = (int) montoCircuitoObjeto;
                            }
                            sumaTotalAvanzado = sumaTotalAvanzado + montoCircuito;

                        }
                        System.out.println("Monto total recaudado de la categoria avanzado: " + sumaTotalAvanzado);

                        sumaTotal = sumaTotalChico + sumaTotalMedio + sumaTotalAvanzado;
                        System.out.println("Monto total recaudado en la carrera: " + sumaTotal);

                    }

                }


            }


        }
    }
}
