//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Persona persona1 = new Persona();
        Persona persona2 = new Persona("Juan", "12345678", 20);
        Persona persona3 = new Persona("Alberto", "11111111", 20, 1.80f, 80.0f);
//        Persona persona4 = new Persona(nombre: "Juan", edad: 21);
        System.out.println(persona1);
    }
}