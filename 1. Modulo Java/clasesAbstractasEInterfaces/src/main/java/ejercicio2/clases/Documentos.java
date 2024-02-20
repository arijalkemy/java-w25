package ejercicio2.clases;

public abstract class Documentos implements Imprimible {

    public Documentos() {
    }

    public abstract void imprimir();


    public void imprimirTipo(){
        System.out.println("----------- " + getClass().getSimpleName().toUpperCase() + " ------------");
    }
}
