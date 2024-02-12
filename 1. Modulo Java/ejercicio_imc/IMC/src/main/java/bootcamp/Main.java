package bootcamp;

public class Main {

    public static void main(String[] args) {
        Persona personaPorDefecto = new Persona();
        Persona personaBasico = new Persona("Pepito",18,"456789132");
        Persona personaCompleto = new Persona("juanito", 28, "123456",70.0,1.73);

        int imc = personaCompleto.calcularIMC();
        boolean mayorEdad = personaCompleto.esMayorDeEdad();

        System.out.println("imc: "+ imc+ " es mayor de edad: "+ mayorEdad);

        System.out.println(personaCompleto.toString());





    }

}
