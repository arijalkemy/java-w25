//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Person personaConstructorVacio = new Person();
        Person personaConstructorParcial = new Person("Pepito", 20, "1000");
        Person personaConstructorCompleto = new Person(
                "Batman",
                16,
                "2000",
                70.0,
                1.80
        );

        // Esto falla :(
        // Persona test = new Persona("Test", 21);

        int imc = personaConstructorCompleto.calculateIMC();
        boolean esMayorDeEdad = personaConstructorCompleto.isAdult();

        if(esMayorDeEdad) { System.out.println("La persona es mayor de edad.");}
        else { System.out.println("La persona es menor de edad."); }
        System.out.printf("El estado de la persona es %s.\n", estadoNutricional(imc));
        System.out.printf("Info: %s.\n", personaConstructorCompleto.toString());
    }
    public static String estadoNutricional(int imc) {
        switch(imc) {
            case -1 -> {
                return "Bajo Peso";
            }
            case 0 -> {
                return "Peso Saludable";
            }
            case 1 -> {
                return "Sobrepeso";
            }
            default -> {
                return "Desconocido";
            }
        }
    }
}