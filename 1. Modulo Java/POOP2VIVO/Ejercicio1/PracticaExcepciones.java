package POOP2VIVO.Ejercicio1;
public class PracticaExcepciones {
    public static void main(String[] args) {
        int a = 0;
        int b = 300;

        try {
            int c = b / a;
            System.out.println(c);
        } catch (Exception e) {
            System.out.println("Se ha producido un error");
        }finally{
            System.out.println("Programa finalizado");
        }

        // ahora throws iLLegalArgumentException con el mensaje "No se puede dividir por cero"
        try{
            if (a == 0) {
                throw new IllegalArgumentException("No se puede dividir por cero");
            }else{
                int c = b / a;
                System.out.println(c);
            }
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}