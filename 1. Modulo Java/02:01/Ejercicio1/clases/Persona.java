package clases;

public class Persona {
    String nombre;
    String dni;
    int edad;
    double peso; // kg
    double altura; // metros

    public Persona() {
    }

    public Persona(String nombre, String dni, int edad) {
        this.nombre = nombre;
        this.dni = dni;
        this.edad = edad;
    }

    public Persona(String nombre, String dni, int edad, double peso, double altura) {
        this.nombre = nombre;
        this.dni = dni;
        this.edad = edad;
        this.peso = peso;
        this.altura = altura;
    }

    public int calcularIMC() {
        if (this.peso / Math.pow(this.altura, 2) < 20) {
            return -1;
        } else if (this.peso / Math.pow(this.altura, 2) > 25) {
            return 1;
        } else {
            return 0;
        }
    }

    public boolean esMayorDeEdad() {
        return this.edad >= 18;
    }

    @Override
    public String toString() {
        return "Persona [nombre=" + nombre + ", dni=" + dni + ", edad=" + edad + ", peso=" + peso + ", altura=" + altura
                + "]";
    }

}
