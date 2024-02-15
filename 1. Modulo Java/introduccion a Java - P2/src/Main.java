/*
Estructuras Dinámicas
El objetivo de este ejercicio es que podamos afianzar y profundizar los conceptos de las diferentes estructuras
dinámicas (Collections, Mapas o Diccionarios).

Carrera de la Selva
Todos los años en la provincia de Misiones, al norte de Argentina se lleva a cabo un evento conocido como
“Carrera de la Selva”. El mismo se trata de una competición donde los mejores maratonistas y corredores de
Latinoamérica se reúnen para desafiar sus habilidades deportivas.

La competencia cuenta con 3 categorías dependiendo de su dificultad y de ellas se guarda una id, el nombre y
una breve descripción:

Circuito chico: 2 km por selva y arroyos.
Circuito medio: 5 km por selva, arroyos y barro.
Circuito avanzado: 10 km por selva, arroyos, barro y escalada en piedra.

Para poder conocer en qué categoría competirá cada participante se manejarán inscripciones. Cada inscripción
debe contar con un número de inscripción, una categoría, un participante y el monto a abonar por el participante.

Cada participante puede inscribirse únicamente a una categoría y necesita, para dicha inscripción, proporcionar
los siguientes datos: número de participante, dni, nombre, apellido, edad, celular, número de emergencia y grupo
sanguíneo.

Para concluir con la inscripción, se debe calcular el monto a abonar por cada participante. Para ello se tienen
en cuenta los siguientes valores:

- Inscripción Circuito chico: Menores de 18 años $1300. Mayores de 18 años $1500.
- Inscripción Circuito medio: Menores de 18 años $2000. Mayores de 18 años $2300.
- Inscripción Circuito Avanzado: No se permite inscripciones a menores de 18 años. Mayores de 18 años $2800

A partir de estos datos brindados, los organizadores de la carrera manifestaron que necesitan de una aplicación
que sea capaz de:

a) Crear 3 objetos de tipo categoría (uno por cada categoría) con sus respectivos datos.

b) Crear un nuevo participante e inscribirlo en una categoría. Calcular el monto de inscripción que
 deberá abonar (Por ejemplo: si el participante se inscribe a la categoría Circuito chico y tiene 21 años,
 el monto a abonar es de $1500).

c) Inscribir al azar algunos participantes en diferentes categorías (al menos uno en cada una).

d) Mostrar por pantalla todos los inscriptos a una determinada categoría con sus correspondientes datos y
 número de inscripción.

e) Desinscribir a un participante. Mostrar como queda la lista de inscriptos en la categoría donde se encontraba.

f) Calcular el monto total recaudado por cada categoría y el total de toda la carrera incluyendo todas las categorías.

* */

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // item a)
        SmallCircuit smallCircuit = new SmallCircuit();
        MediumCircuit mediumCircuit = new MediumCircuit();
        AdvancedCircuit advancedCircuit = new AdvancedCircuit();

        // item b)
        List<Participant> participants = new ArrayList<>();
        participants.add(new Participant(1, "12345678", "Juan", "Perez", 21, "555-1234", "555-5678", "O+"));
        participants.add(new Participant(2, "87654321", "Ana", "Lopez", 17, "555-4321", "555-8765", "A+"));
        participants.add(new Participant(3, "18273645", "Carlos", "Martinez", 30, "555-6789", "555-9876", "B+"));

        // item c)
        smallCircuit.registerParticipant(participants.get(0));
        mediumCircuit.registerParticipant(participants.get(1));
        advancedCircuit.registerParticipant(participants.get(2));

        // item d)
        System.out.println("Inscritos en el Circuito Chico:");
        smallCircuit.showParticipants();

        System.out.println("Inscritos en el Circuito Medio:");
        smallCircuit.showParticipants();

        System.out.println("Inscritos en el Circuito Avanzado:");
        smallCircuit.showParticipants();

        //item e)
        smallCircuit.unregisterParticipant(participants.get(0).getParticipantNumber());
        System.out.println("Inscritos en el Circuito Chico después de desinscribir a Juan:");
        smallCircuit.showParticipants();

        // item f)
        double totalSmall = smallCircuit.calculateTotalCollected();
        double totalMedium = mediumCircuit.calculateTotalCollected();
        double totalAdvanced = advancedCircuit.calculateTotalCollected();
        double grandTotal = totalSmall + totalMedium + totalAdvanced;

        System.out.println("Total recaudado Circuito Chico: $" + totalSmall);
        System.out.println("Total recaudado Circuito Medio: $" + totalMedium);
        System.out.println("Total recaudado Circuito Avanzado: $" + totalAdvanced);
        System.out.println("Total recaudado en toda la carrera: $" + grandTotal);
    }

}