package org.clase01_02_24.poo_p1;

public class Persona {
    String nombre;
    Integer edad;
    String dni;
    Double peso;
    Double altura;

    public Persona() {
    }

    public Persona(String nombre, Integer edad, String dni) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
    }

    public Persona(String nombre, Integer edad, String dni, Double peso, Double altura) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
        this.peso = peso;
        this.altura = altura;
    }

    public Integer calcularIMC() {
        double imc = (peso / Math.pow(altura, 2));
        if (imc < 20) {
            return -1;
        } else if (imc >= 20 && imc <=25) {
            return 0;
        } else {
            return 1;
        }
    }
    public Boolean esMayorDeEdad(){
        return edad >= 18;
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
