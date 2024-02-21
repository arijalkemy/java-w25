package Ejercicio_Clases_Abs_Int.src.Ejercicio3;

public class Perro extends Animal implements Carnivorable{
    @Override
    public void emitirSonido() {
        System.out.println("Guau");
    }

    @Override
    public void comerCarne() {
        System.out.println("comiendo carne");
    }
}
