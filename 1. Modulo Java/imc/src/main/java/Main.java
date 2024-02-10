import org.w3c.dom.ls.LSOutput;

public class Main {



    public static void main(String[] args) {

        Persona persona1 = new Persona();
        Persona persona2 = new Persona("Juan","33343234",24,57.0,1.7);
        Persona persona3 = new Persona("Carlos",20,"54222121");

        //persona2.calcularIMC();
        System.out.println(persona2.toString());
        switch (persona2.calcularIMC()){
            case -1 -> System.out.println("Bajo Peso");
            case 0 -> System.out.println("Peso Saludable");
            case 1 -> System.out.println("Sobrepeso");

        }
    }





}


