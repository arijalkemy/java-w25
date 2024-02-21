package Ejercicio_Clases_Abs_Int.src.Ejercicio2;

public abstract class Documento implements IImprimible {
    public Documento() {
    }
    public abstract void imprimir();
    public void imprimirTipo() {
        imprimir();
    }
}
