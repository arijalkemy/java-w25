package bootcamp.domain;

public class Persona {

    String nombre;
    Integer edad;
    String dni;
    Double peso;
    Double altura;

    public Persona(){}

    public Persona(String nombre, Integer edad, String dni, Double peso, Double altura) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
        this.peso = peso;
        this.altura = altura;
    }

    public Persona(String nombre, Integer edad, String dni) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
    }

    public double calcularIMC() {
        double imc = peso/(Math.pow(altura, 2));
        if (imc < 20) return -1;
        else if (imc >= 20 && imc <= 25) return 0;
        return 1;
    }

    public boolean esMayorDeEdad() {
        return edad >= 18;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + '\n' +
                "Edad: " + edad + '\n' +
                "Dni: " + dni + '\n' +
                "Peso: " + peso + " kg" + '\n' +
                "Altura: " + altura + " m";
    }
}
