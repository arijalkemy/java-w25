package src.main.java.org.example;

public class Persona {
    String nombre;
    int edad;
    String dni;
    double peso;
    double altura;

    public Persona() {
    }

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

    public int calcularIMC(){
        double imc = peso / (altura * altura);
        if (imc < 20) {
            System.out.println("Su IMC es: " + imc);
            return -1;
        }
        else {
            if (imc >= 20 && imc <= 25){
                System.out.println("Su IMC es: " + imc);
                return 0;
            }
            else {
                System.out.println("Su IMC es: " + imc);
                return 1;
            }
        }
    }
    public boolean esMayorDeEdad(){
        if (edad < 18){
            return false;
        }
        else {
            return true;
        }
    }

    @Override
    public String toString() {
        return "Persona: " + nombre + " con edad de " + edad + " anios, con dni " + dni + " con peso " + peso + "kg y altura " + altura + " metros.";

    }
}
