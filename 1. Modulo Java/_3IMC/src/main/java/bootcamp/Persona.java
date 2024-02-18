package bootcamp;

public class Persona {
    private String nombre;
    private int edad;
    private String dni;
    private double peso;
    private double altura;

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


    public int calcularIMC(){
        double imcCalculado=(this.peso/Math.pow(this.altura,2));

        int valorRetornar;

        if (imcCalculado < 20){
            valorRetornar = -1;
        } else if (imcCalculado > 25) {
            valorRetornar = 1;
        }else {
            valorRetornar = 0;
        }

        return valorRetornar;
    }


    public boolean esMayorDeEdad(){
        return this.edad >= 18;

    }

    /*public String toString() {
        String mensajeImc= "";

        if (this.calcularIMC() ==1){
                mensajeImc= "Sobrepeso";
        } else if (this.calcularIMC() < 0) {
            mensajeImc= "Bajo peso";
        }else{
            mensajeImc="Peso saludable";
        }

        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", dni='" + dni + '\'' +
                ", peso=" + peso +
                ", altura=" + altura +
                ",IMC="+mensajeImc+
                ", mayor de edad= "+ this.esMayorDeEdad()+
                '}';
    }*/


}
