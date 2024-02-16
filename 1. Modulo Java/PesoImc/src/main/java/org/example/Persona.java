package org.example;

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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public int calcularIMC(){
        /*
        si el es menor que 20, debe retornar -1, si devuelve un valor entre 20 y 25
        inclusive para los dos valores  debe retornar un 0 y si devuelve
        un número mayor que 25 debe retornar un 1.
         */
        int imc = Math.toIntExact(Math.round(this.peso / (Math.pow(altura, 2))));
        if(imc < 20 ) return -1;
        if(imc >= 20 && imc <= 25) return 0;
        if(imc > 25) return 1;
        return 0;

    }

    public void esMayorDeEdad() {
        if(edad >= 18) {
            System.out.println(true);
        } else {
            System.out.println(false);
        }
    }


    public void imprimirDatosPersona() {
        System.out.println("Los datos de la persona son: " +
                "nombre '" + nombre + '\'' +
                ", edad " + edad +
                ", dni '" + dni + '\'' +
                ", peso " + peso +
                ", altura " + altura );
    }
}
