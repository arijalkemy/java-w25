public class Persona {
    private String nombre;
    private int edad;
    private String dni;
    private double peso;
    private double altura;

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

    public String getNombre() {
        return nombre;
    }

    public int calcularIMC() {
        double nom = this.peso;
        double denom = Math.pow(this.altura, 2);
        double imc = nom / denom;

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
