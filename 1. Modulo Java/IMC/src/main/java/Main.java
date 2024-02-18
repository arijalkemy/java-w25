public class Main {
    public static void main(String[] args) {
        Persona personaSinParametros = new Persona();
        Persona personaPocosParametros = new Persona("Juan", 20, "12345678");
        Persona personaTodosLosParametros = new Persona("Carlos", 23, "87654321", 75, 1.8);

        System.out.println("\n----------------------------");
        System.out.println(personaTodosLosParametros.toString());

        System.out.println("\n----------------------------");
        if (personaTodosLosParametros.esMayorDeEdad()) {
            System.out.println("Es mayor de edad");
        }
        else {
            System.out.println("Es menor de edad");
        }

        System.out.println("\n----------------------------");
        switch (personaTodosLosParametros.calcularIMC()) {
            case -1:
                System.out.println("IMC: Bajo peso");
                break;
            case 0:
                System.out.println("IMC: Peso saludable");
                break;
            case 1:
                System.out.println("IMC: Sobrepeso");
                break;
        }
    }
}
