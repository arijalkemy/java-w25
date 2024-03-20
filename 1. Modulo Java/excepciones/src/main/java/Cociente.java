public class Cociente {

    private int a = 0;
    private int b = 300;
    public void calcularCociente(){
        try {
            System.out.println(b/a);
        }catch (ArithmeticException e){
            throw new IllegalArgumentException("No se puede dividir por cero");
        }finally {
            System.out.println("Programa finalizado");
        }
    }

}
