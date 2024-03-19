package main;

public class PracticaExcepciones {

    private int a;
    private int b;

    public PracticaExcepciones(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public void dividirPuntoUno() {
        int c;
        try{
            c = this.b / this.a;
            System.out.println("La división de b/a es: " + c);
        }catch (Exception e){
            System.out.println("El programa ha finalizado");
        }
    }

    public void dividirPuntoDos() {
        int c;
        try{
            if(this.a == 0){
                throw new IllegalArgumentException("No se puede dividir por cero");
            }else c = this.b / this.a;
        }catch (IllegalArgumentException e){
            e.printStackTrace();
        }
    }

}
