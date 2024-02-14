package persona;

public class Persona {
    private String nombre;
    private int edad;
    private String dni;
    private int peso;
    private double altura;

    public Persona() {
    }

    public Persona(String nombre, int edad, String dni) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
    }

    public Persona(String nombre, int edad, String dni, int peso, double altura) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
        this.peso = peso;
        this.altura = altura;
    }

    public int calcularImc() {
        double imc = (peso / (Math.pow(altura, 2)));
        if (imc < 20) {
            return -1;
        }
        if (imc >= 20 && imc <= 25) {
            return 0;
        }
        return 1;
    }

    public boolean esMayorDeEdad() {
        return edad >= 18;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + "\nEdad: " + edad + "\nDni: " + dni + "\nPeso: " + peso + "\nAltura: " + altura
                + "\nImc: " + convertirImc(this.calcularImc()) + "\nEs mayor de edad: " + convertirBoolean(this.esMayorDeEdad());
    }

    private String convertirImc(int imc) {
        if (imc == -1) {
            return "Bajo peso";
        }
        return imc == 0 ? "Peso saludable" : "SobrePeso";
    }
    private String convertirBoolean(boolean booleano){
        return booleano ? "Si":"No";
    }
}
