package POOP1VIVO.objectoPersona;
public class Main {
    public static void main(String[] args) {
        Persona personaA=new Persona();
        Persona personaB=new Persona("Pepito", 20, "12345");
        Persona personaC=new Persona("David", 21, "12345", 70.1, 1.80);

        System.out.println("MCI "+ personaC.calcularIMC());
        System.out.println(personaC.toString());
    }
}