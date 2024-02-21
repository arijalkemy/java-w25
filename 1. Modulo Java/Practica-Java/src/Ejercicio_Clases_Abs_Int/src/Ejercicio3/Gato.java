package Ejercicio_Clases_Abs_Int.src.Ejercicio3;

public class Gato extends Animal implements Carnivorable{
    @Override
    public void emitirSonido() {
        System.out.println("Miau");
    }

    @Override
    public void comerCarne() {
        System.out.println("Comiendo atun");
    }
}
