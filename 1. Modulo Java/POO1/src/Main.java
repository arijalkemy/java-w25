public class Main {
    public static void main(String[] args) {

        Persona persona1 = new Persona();
        Persona persona2 = new Persona("Pepito", 23, "12344");
        Persona persona3 = new Persona("Juanito", 13, "456778", 64.0, 1.70);

        int val  = persona3.calcularIMC();
        String mensaje;

        if (val == -1) mensaje = "Bajo peso";
        else if (val == 1) mensaje = "Sobrepeso";
        else mensaje = "Peso saludable";

        String tipoPeso = persona3.esMayorDeEdad() ? "Es mayor de edad" : "Es menor de edad";

        System.out.println("La persona: " + persona3.toString());
        System.out.println("Cuenta con los siguientes datos");
        System.out.println("Tipo de peso: " + mensaje);
        System.out.println("Tipo de edad: " + tipoPeso);
    }
}