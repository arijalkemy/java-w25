package bootcamp.poo2;
import lombok.Data;
@Data
public class PracticaExcepciones {
    private int a=0;
    private int b=17;

    public void showDivAB(){
        try {
            System.out.println("b/a = " + b/a);
        }
        catch (ArithmeticException ex){
            System.out.println(" Unable to  div by 0 " );
        }
        finally {
            System.out.println(" End of running " );
        }
    }
    public void showDivABV2(){
        try {
            System.out.println("b/a = " + b/a);
        }
        catch (ArithmeticException ex){
            throw new IllegalArgumentException(" Unable to  div by 0 ");
        }
        finally {
            System.out.println(" End of running " );
        }
    }
}
