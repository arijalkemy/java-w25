public class Persona {

    private String nombre;
    private Integer edad;
    private String dni;
    private Double peso;
    private Double altura;

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

    public int calcularIMC(){
        double imc = peso/(Math.pow(altura,2));
        if (imc<20) return -1;
        else if (imc >=20 && imc <= 25) return 0;
        else return 1;
    }

    public boolean esMayorDeEdad(){
        return edad >= 18;
    }

    @Override
    public String toString() {

        return  nombre +
                "\n edad=" + edad +
                "\n dni='" + dni + '\'' +
                "\n peso=" + peso +
                "\n altura=" + altura;
    }
}
