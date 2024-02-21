package Ejercicio_IMC_Persona;

public class Persona {
    private String nombre;
    private int edad;
    private String dni;
    private double peso;
    private double altura;

    public Persona(String nombre, int edad, String dni, double peso, double altura) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
        this.peso = peso;
        this.altura = altura;
    }

    public Persona(String nombre, int edad, String dni) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
    }

    public Persona() {

    }

    public int calcularMC() {
        // peso/(altura^2) - (peso expresado en kg y altura en mts)
        double indiceMC = this.peso / Math.pow(this.peso, 2);
        if(indiceMC < 20)
            return -1;
        else if(indiceMC >= 20 && indiceMC <= 25)
            return 0;
        else
            return 1;
    }

    public boolean esMayorDeEdad() {
        return this.edad >= 18;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    @Override
    public String toString() {
        return "Persona: " + nombre + '\'' +
                ", edad: " + edad +
                ", dni: '" + dni + '\'' +
                ", peso: " + peso +
                ", altura: " + altura;
    }
}
