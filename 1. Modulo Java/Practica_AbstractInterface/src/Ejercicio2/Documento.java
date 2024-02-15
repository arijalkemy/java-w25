package Ejercicio2;

public abstract class Documento implements IImprimible{


    //Se redefine el metodo imprimirTipoDoc que corresponde a la interfaz Imprimible
    @Override
    public void imprimirTipoDoc(){
        System.out.println("----------- " + getClass().getSimpleName().toUpperCase() + " ------------");
    }

    public abstract void imprimir();

}
