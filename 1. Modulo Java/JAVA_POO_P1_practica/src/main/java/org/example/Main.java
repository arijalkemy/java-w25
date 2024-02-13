package org.example;


public class Main {
    public static void main(String[] args) {
        Persona personaConstructorVacio = new Persona();
        Persona personaConstructorParcial = new Persona("Pepito", 20, "1000");
        Persona personaConstructorCompleto = new Persona(
                "Batman",
                16,
                "2000",
                70.0,
                1.80
        );

        int imc = personaConstructorCompleto.calcularIMC();
        boolean esMayorDeEdad = personaConstructorCompleto.esMayorDeEdad();

        if(esMayorDeEdad) { System.out.println("La persona es mayor de edad.");}
        else { System.out.println("La persona es menor de edad."); }
        System.out.printf("El estado de la persona es %s.\n", estadoNutricional(imc));
        System.out.printf("Info: %s.\n", personaConstructorCompleto.toString());
    }

    public static String estadoNutricional(int imc) {
        switch(imc) {
            case -1:
                return "Bajo Peso";
            case 0:
                return "Peso Saludable";
            case 1:
                return "Sobrepeso";
            default:
                return "Desconocido";
        }
    }
}

class Persona {
    String nombre;
    int edad;
    String dni;
    double peso;
    double altura;

    public Persona() {}

    public Persona(String nombre, int edad, String dni) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
    }

    public Persona(String nombre, int edad, String dni, double peso, double altura) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
        this.peso = peso;
        this.altura = altura;
    }

    public int calcularIMC() {
        double num = this.peso;
        double denom = Math.pow(this.altura, 2);
        double imc = num / denom;

        if(imc < 20) {
            return -1;
        }

        if(imc >= 20 && imc <= 25) {
            return 0;
        }

        return 1;
    }

    public boolean esMayorDeEdad() {
        return this.edad >= 18;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", dni='" + dni + '\'' +
                ", peso=" + peso +
                ", altura=" + altura +
                '}';
    }
}