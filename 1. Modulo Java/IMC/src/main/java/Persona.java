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

    public int calcularIMC() {
        double imc = peso / (Math.pow(altura, 2));
        if (imc < 20) return -1;
        if (imc >= 20 && imc <= 25) return 0;
        return 1;
    }

    public boolean esMayorDeEdad() {
        return edad >= 18;
    }

    @Override
    public String toString() {
        return String.format("Nombre: %s\nEdad: %d\nDNI: %s\nPeso: %.2f\nAltura : %.2f", nombre, edad, dni, peso, altura);
    }
}
