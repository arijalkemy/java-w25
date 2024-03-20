public class Persona {
    String nombre;
    int edad;
    String dni;
    double peso;
    double altura;

    double mci;

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

    public int getIMC(){
        this.mci = this.altura <0 ? 0 :this.peso / this.altura*this.altura;
        if (mci < 20){
            return -1;
        }
        else if (mci>=20 && mci <= 25) {
            return  0;
        }
        else{
            return 1;
        }
    }

    public boolean esMayorDeEdad(){
        return this.edad>18;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", dni='" + dni + '\'' +
                ", peso=" + peso +
                ", altura=" + altura +
                ", mci=" + mci +
                '}';
    }
}
