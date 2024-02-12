package org.example;

public class Main {
    public static void main(String[] args) {
        Persona personaSinParam = new Persona();
        Persona personaSinAltPeso = new Persona("Miguel", 43, "24.432.213");
        Persona personaAllParam = new Persona("Lucio", 23, "43.212.343", 60.1, 1.60);

        //Persona personaError = new Persona("Wario", 43);
        //No se puede porque no hay constructor

        int IMC = personaAllParam.calcularIMC();
        boolean isAdult = personaAllParam.esMayorDeEdad();
        String textoIMC, textoAdulto;

        if (IMC < 0) {
            textoIMC = "Bajo peso";
        } else if (IMC == 0) {
            textoIMC = "Peso saludable";
        } else {
            textoIMC = "Sobrepeso";
        }

        if (isAdult)
            textoAdulto = "Sí";
        else
            textoAdulto = "No";


        System.out.println(personaAllParam.toString());
        System.out.println("Nivel de peso: " + textoIMC + ", ¿Es mayor de edad?: " + textoAdulto);
    }
}