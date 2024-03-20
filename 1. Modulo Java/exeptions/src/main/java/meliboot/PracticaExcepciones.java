package meliboot;

public class PracticaExcepciones {
    private int a = 0;
    private int b = 300;

    public PracticaExcepciones(){
        try{
            var result = this.b/this.a;
        }catch (Exception e){
            throw new IllegalArgumentException("No se puede dividir por cero");
        }finally {
            System.out.println("Programa finalizado");
        }
    }

}