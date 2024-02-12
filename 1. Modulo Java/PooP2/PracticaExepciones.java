public class PracticaExepciones {

    private int a;
    private int b;

    public PracticaExepciones() {
        this.a = 0;
        this.b = 300;
    }

    public double calcular(){

        if (this.a == 0 ){
            throw new IllegalArgumentException(" No se puede dividir por cero ");

        }

        return this.b / this.a;

    }



}
