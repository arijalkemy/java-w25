package Ejercicio_Excepciones.src;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        PracticaExcepciones prueba = new PracticaExcepciones(0,300);

        try{
            if(prueba.getA() == 0) {
                throw new IllegalArgumentException("No se puede dividir entre cero");
            }
            int resultado = prueba.getB() / prueba.getA();
        }
        catch (IllegalArgumentException e){
            System.out.println("Se ha producido un error " + e.getMessage());
        }
        finally {
            System.out.println("Programa finalizado");
        }
    }
}