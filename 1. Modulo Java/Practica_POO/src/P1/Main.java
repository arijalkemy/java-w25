package P1;

import P1.model.Persona;

public class Main {
    public static void main(String[] args) {
        Persona p1 = new Persona();
        Persona p2 = new Persona("Jhon Doe", "1234567", 26);
       // Persona p3 = new Persona("Adam Smith", 23); No se puede, no esta declarado el constructor para este caso

    }
}