import java.util.List;

public class MainPooP1 {
    public static void main(String[] args) {

        Persona persona1 = new Persona();
        Persona persona2 = new Persona("Jonathan", 25, "falseDni1");
        Persona persona3 = new Persona("Daniel", 24, "falseDni2", 1.78, 65);


        int imcPersona1 = persona1.calcularIMC();
        int imcPersona2 = persona2.calcularIMC();
        int imcPersona3 = persona3.calcularIMC();

        List<Persona> personas = List.of(persona1, persona2, persona3);

        for (Persona persona : personas) {
            switch (persona.calcularIMC()){
                case -2 -> System.out.printf("\nLa %s no tiene peso o altura asignada", persona);
                case -1 -> System.out.printf("\nLa %s tiene bajo peso", persona);
                case 0 -> System.out.printf("\nLa %s tiene peso saludable", persona);
                case 1 -> System.out.printf("\nLa %s tiene sobre peso", persona);
            }
        }
    }
}