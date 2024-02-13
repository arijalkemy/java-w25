public class Main {
    public static void main(String[] args) {

        PracticaExepciones calculo = new PracticaExepciones();

        try {
            calculo.calcular();

        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }

        finally {
            System.out.println(" Programa finalizado ");
        }


    }

}