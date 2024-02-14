public class Main {
    public static void main(String[] args) {
        PracticaExcepciones prueba = new PracticaExcepciones(0,300);

        try{
            if(prueba.getA()==0) {
                throw new IllegalArgumentException("no se puede dividir por cero");
            }
            int c = prueba.getB()/ prueba.getA();
        }
        catch (Exception e) {
            System.out.println("Se ha producido un error - "+e.getMessage());
        }
        finally {
            System.out.println("Programa Finalizado");
        }
    }
}
