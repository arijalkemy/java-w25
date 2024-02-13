package model;

public class Persona {
    private String nombre, dni;
    private double peso, altura;
    private int edad;

    public Persona() {}

    public Persona(String nombre, String dni, int edad) {
        this.nombre = nombre;
        this.dni = dni;
        this.edad = edad;
    }

    public Persona(String nombre, String dni, double peso, double altura, int edad) {
        this.nombre = nombre;
        this.dni = dni;
        this.peso = peso;
        this.altura = altura;
        this.edad = edad;
    }

    public int calcularIMC(){
        double res = this.peso / (Math.pow(this.altura, 2));

        if (res < 20){
            return -1;
        } else if (res <= 25) {
            return 0;
        } else {
            return 1;
        }
    }
    public boolean esMayorDeEdad(){
        return this.edad > 18;
    }

    @Override
    public String toString() {
        return "nombre='" + nombre + '\'' +
                ", dni='" + dni + '\'' +
                ", edad=" + edad +
                ", peso=" + peso +
                ", altura=" + altura;
    }

}
