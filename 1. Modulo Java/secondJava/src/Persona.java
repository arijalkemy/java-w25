public class Persona {
    String nombre;
    String dni;
    int edad;
    float altura;
    float peso;

    public Persona() {}
    public Persona(String nombre, String dni, int edad) {
        this.nombre = nombre;
        this.dni = dni;
        this.edad = edad;
    }
    public Persona(String nombre, String dni, int edad, float altura, float peso) {
        this.nombre = nombre;
        this.dni = dni;
        this.edad = edad;
        this.altura = altura;
        this.peso = peso;
    }

    public int calcularIMC() {
        float imc = peso / (altura * altura);
        if (imc > 25) {
            return 1;
        } else if (imc >= 20 && imc < 25) {
            return 0;
        } else {
            return -1;
        }
    }

    public boolean esMayorDeEdad() {
        return edad >= 18;
    }

    public String toString() {
        switch (this.calcularIMC()) {
            case -1:
                return "Persona [nombre=" + nombre + ", dni=" + dni + ", edad=" + edad + ((this.esMayorDeEdad()) ? ", es mayor de edad" : ", es menor de edad") +", altura=" + altura + ", peso=" + peso + ", IMC=Bajo peso]";
            case 0:
                return "Persona [nombre=" + nombre + ", dni=" + dni + ", edad=" + edad + ((this.esMayorDeEdad()) ? ", es mayor de edad" : ", es menor de edad") +", altura=" + altura + ", peso=" + peso + ", IMC=Peso normal]";
            default:
                return "Persona [nombre=" + nombre + ", dni=" + dni + ", edad=" + edad + ((this.esMayorDeEdad()) ? ", es mayor de edad" : ", es menor de edad") +", altura=" + altura + ", peso=" + peso + ", IMC=Sobrepeso]";
        }
    }
}
