package bootcamp;

public class Main {

    public static void main(String[] args) {
        Persona personaPorDefecto = new Persona();
        Persona personaBasico = new Persona("Pepito",18,"456789132");
        Persona personaCompleto = new Persona("juanito", 28, "123456",70.0,1.73);

        int imc = personaCompleto.calcularIMC();
        boolean mayorEdad = personaCompleto.esMayorDeEdad();

        System.out.println("imc: "+ imc+ " es mayor de edad: "+ mayorEdad);

        System.out.println(personaCompleto.toString());


        //Mensaje final
        String mensajeFinal = "Este es el último mensaje";

        //Código que arroja excepción


        try {
            int[] numeros = new int[5];
            numeros[5] = 10;
        }catch (IndexOutOfBoundsException e){
            System.out.println(e.getMessage());
        }finally {
            System.out.println(mensajeFinal);
        }



    }

}
