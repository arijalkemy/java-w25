public class Main {
    public static void main(String[] args) {

        Persona persona1 = new Persona();
        Persona persona2 = new Persona("Pepito", 21, "321432");
        Persona persona3 = new Persona("Carlos", 16, "23423", 70,1.70);

        //Persona personaFail = new Persona("Roberto", 23);
        System.out.print("La persona tiene un IMC que indica: ");
        switch (persona3.calcularIMC()){
            case -1 -> System.out.println("Bajo peso");
            case 0 -> System.out.println("Peso saludable");
            case 1 -> System.out.println("Sobrepeso");
        }
        System.out.print("Además, debido a su edad se define que ");
        if (persona3.esMayorDeEdad()){
            System.out.println("es mayor de edad");
        } else {
            System.out.println("es menor de edad");
        }
        System.out.println(persona3);

    }
}