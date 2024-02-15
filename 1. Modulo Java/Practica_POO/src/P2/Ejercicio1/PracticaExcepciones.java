package P2.Ejercicio1;

public class PracticaExcepciones
{
    private int a = 0;
    private int b = 300;

    public double calcular(){
        double cociente = 0.0;
        try {
            cociente = b/a;
        }catch (Exception e){
            System.out.println("Se ha producido un error");
        }finally {
            System.out.println("Programa Finalizado");
        }
        return cociente;
    }

    public double calcularModificado(){
        double cociente = 0.0;
        if(a == 0) throw new IllegalArgumentException("No se puede dividir por cero");
        cociente = (b / a) * 1.0;
        return cociente;
    }
}
