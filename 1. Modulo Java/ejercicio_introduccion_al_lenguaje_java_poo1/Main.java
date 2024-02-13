//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Persona fulano = new Persona("fulano", 15, "44208598");
        Persona personaSinIdentidad = new Persona();
        // Persona personaConErrorConstructor = new Persona ("persona", 15);
        System.out.println(fulano.calcularIMC());
        System.out.println(fulano.esMayorDeEdad());
        System.out.println(fulano.toString());
    }


}