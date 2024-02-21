package Ejercicio_IMC_Persona;

public class Main {
    public static void main(String[] args) {
        Persona person1 = new Persona();
        Persona person2 = new Persona("Matias", 28, "12345678");
        Persona person3 = new Persona("Juan Manuel", 27, "12345678", 65, 1.71);

        int opcIndiceMc = person3.calcularMC();

        switch(opcIndiceMc) {
            case -1:
                System.out.println(person3.getNombre() + ", de edad: " + person3.getEdad() + " años, tiene bajo peso.");
                break;
            case 0:
                System.out.println(person3.getNombre() + ", de edad: " + person3.getEdad() + " años, posee un peso saludable.");
                break;
            case 1:
                System.out.println(person3.getNombre() + ", de edad: " + person3.getEdad() + " años, tiene sobrepeso.");
                break;
        }
    }
}
