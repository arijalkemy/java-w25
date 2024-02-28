public class Main {
    public static void main(String[] args) {
        Persona personaVacio = new Persona();
        Persona personaMedio = new Persona("Daniel", 23, "091272");
        Persona personaCompleto = new Persona("Dago", 20, "100212", 90, 92);

        // Persona errorPersona = new Persona("Dev", 90);

        System.out.println("Es mayor de edad: " + personaCompleto.esMayorDeEdad());
        System.out.println("IMC");
        int imc = personaCompleto.calcularImc();
        if (imc == -1)
            System.out.println("Bajo peso");
        if (imc == 0)
            System.out.println("Peso saludable");
        if (imc == 1)
            System.out.println("Sobrepeso");
    }
}