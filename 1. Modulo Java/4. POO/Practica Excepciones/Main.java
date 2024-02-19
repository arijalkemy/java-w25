public class Main {
    public static void main(String[] args) {
        PracticaExcepcion practica = new PracticaExcepcion();

        try{
            int res = practica.b / practica.a;
        }
        catch (Exception e){
            System.out.println("Se ha producido un error");
            throw new IllegalArgumentException("No se puede dividir por cero");
        } finally{
            System.out.println("Programa finalizado");
        }

    }
}