public class Persona {

    private String nombre;
    private int edad;
    private String dni;
    private double altura;
    private double peso;

    public Persona(String nombre, int edad, String dni, double altura, double peso) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
        this.altura = altura;
        this.peso = peso;
    }

    public Persona(String nombre, int edad, String dni) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
    }

    public Persona() {
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", dni='" + dni + '\'' +
                ", altura=" + altura +
                ", peso=" + peso +
                '}';
    }

    public int calcularIMC() {
        double result = 0;
        if (this.altura > 0 && this.peso > 0) {
            result = (this.peso / Math.pow(this.altura, 2));
            if(result < 20) {
                return -1;
            } else if (result >= 20 && result < 25) {
                return 0;
            } else {
                return 1;
            }
        }
        return -2;
    }

    public boolean esMayorDeEdad(){
        if (this.edad > 0) {
            return this.edad > 18;
        }else{
            System.out.println("La persona no tiene edad asignada");
            return false;
        }
    }
}
