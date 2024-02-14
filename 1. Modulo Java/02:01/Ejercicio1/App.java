import clases.*;

public class App {
    public static void main(String[] args) throws Exception {
        Persona persona1 = new Persona();
        Persona persona2 = new Persona("Cristiano Ronaldo", "11222333", 37);
        Persona persona3 = new Persona("Lionel Messi", "44555666", 36, 72, 1.70);

        if (persona3.calcularIMC() == -1) {
            System.out.println("Bajo peso.");
        } else if (persona3.calcularIMC() == 0) {
            System.err.println("Peso saludable.");
        } else if (persona3.calcularIMC() == 1) {
            System.out.println("Sobrepeso.");
        }

        if (persona3.esMayorDeEdad()) {
            System.out.println("Es mayor de edad.");
        } else {
            System.out.println("Es menor de edad.");
        }

        System.out.println(persona3);
    }
}
