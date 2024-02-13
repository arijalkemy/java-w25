import model.Persona;

public class Main {
    public static void main(String[] args) {

        Persona personaConstructorVacio = new Persona();
        Persona personaConstructorParcial = new Persona(
                "Julian",
                "40123456",
                23
        );
        Persona personaConstructorCompleto = new Persona(
                "Carlos",
                "12345678",
                1.76,
                70.1,
                15
        );

        /*
        Persona personaConstructorInvalido = new Persona ("Nombre", 40);

        No se puede crear un objeto que no tenga un constructor para los parámetros dados.
        */

        System.out.println(personaConstructorCompleto);

        if (personaConstructorCompleto.esMayorDeEdad())
            System.out.println("Es mayor de edad");
        else
            System.out.println("Es menor de edad");

        int IMC = personaConstructorCompleto.calcularIMC();

        System.out.print("Resultado IMC: ");
        if (IMC == -1) {
            System.out.print("Bajo peso");
        } else if (IMC == 0) {
            System.out.print("Peso saludable");
        } else {
            System.out.print("Sobrepeso");
        }
    }
}
