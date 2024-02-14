package bootcamp;


import bootcamp.domain.Persona;

public class Main
{
    public static void main( String[] args )
    {
        Persona personaVacia = new Persona();
        Persona personaParcial = new Persona("Renzo", 25, "41211589");
        Persona personaCompleta = new Persona("Renzo", 25, "41211589", 73.0, 1.76);

        // Constructor no existente
        //Persona personaError = new Persona("Renzo", 25);

        double imcPersonaCompleta = personaCompleta.calcularIMC();
        String mensajeImc = "";
        if (imcPersonaCompleta == -1) mensajeImc = "Bajo peso";
        else if (imcPersonaCompleta == 0) mensajeImc = "Peso saludable";
        else mensajeImc = "Sobrepeso";
        System.out.println("IMC de la persona: " + mensajeImc);
        boolean esMayorDeEdadPersonaCompleta = personaCompleta.esMayorDeEdad();
        String mensajeEsMayorDeEdad = esMayorDeEdadPersonaCompleta ? "Si" : "No";
        System.out.println("La persona es mayor de edad: " + mensajeEsMayorDeEdad);
        System.out.println(personaCompleta.toString());
    }
}
