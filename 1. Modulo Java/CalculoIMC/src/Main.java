public class Main {
    public static void main(String[] args) {
        Persona persona1 = new Persona();
        Persona manu = new Persona("Manuel",22,"10120101");
        Persona juanMa = new Persona("Juan Manuel",22,"1212121",60,1.80F);

        int imc = juanMa.calcularIMC();
        if(imc == -1) System.out.println(juanMa.nombre+"! estas bajo de peso, ponete a hacer ejercicio.");
        if(imc == 0) System.out.println(juanMa.nombre+"! estas muy bien, sigue así!");
        if(imc == 1) System.out.println(juanMa.nombre+"! cuidado, estas en sobrepeso!");

        boolean esMayor = juanMa.esMayorDeEdad();
        if(esMayor) System.out.println(juanMa.nombre+" es mayor de edad.");
        if (!esMayor) System.out.println(juanMa.nombre+" es menor de edad.");

        System.out.println(juanMa.toString());
    }
}
