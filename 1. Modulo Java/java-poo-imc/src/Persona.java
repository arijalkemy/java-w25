public class Persona {

    String nombre;
    int edad;
    String dni;
    double peso;
    double altura;

    public Persona() {
    }

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

    public int calcularImc() {
        double value = this.peso/Math.pow((this.altura/100),2);
        if( value < 20)
            return -1;
        else if(value >= 20 && value <=25)
            return 0;
        else
            return 1;
    }
    public boolean esMayorDeEdad(){
        return this.edad >= 18;
    }
}
