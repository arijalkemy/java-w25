public class Persona {
    private String nombre;
    private String dni;
    private int edad;
    private double peso;
    private double altura;

    public Persona(String nombre, int edad, String dni) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
    }

    public Persona(){
    }

    public Persona(String nombre, String dni, int edad, double peso, double altura){
        this.nombre = nombre;
        this.dni = dni;
        this.edad = edad;
        this.peso = peso;
        this.altura = altura;
    }

    /**
     * calculates the imc of a person considering weight and height, formula: weight/height^2
     * @return imc (indice de masa corporal), -1 if x < 20, 0 if 20 <= x <=25, 1 if x > 25
     */
    public int calcularIMC(){
        /*
        si este valor menor que 20, la función debe retornar -1, si devuelve un número entre 20 y 25
        inclusive para los dos valores, el método debe retornar un 0, por último, si devuelve
        un número mayor que 25 debe retornar un 1.
         */
        //peso/(altura^2) - (peso expresado en kg y altura en mts)
        int imc = Math.toIntExact(Math.round(this.peso / (Math.pow(altura, 2))));
        if(imc < 20 ) return -1;
        if(imc >= 20 && imc <= 25) return 0;
        if(imc > 25) return 1;
        return 0;

    }

    public boolean esMayorDeEdad(){
        return this.edad >= 18;
    }

    public String toString() {
        return "Nombre: " + this.nombre +
                "\nDni: " + this.dni +
                "\nPeso: " + this.peso +
                "\nIMC: " + this.calcularIMC() +
                "\nMayor de Edad: " + (this.esMayorDeEdad() ? "Si" : "No");
    }

}
