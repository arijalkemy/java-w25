public class App {
    public static void main(String[] args) throws Exception {
        PracticaExcepciones pracExcep = new PracticaExcepciones(0, 300);
        try {
            pracExcep.calcularCociente();
        } catch (Exception e) {
            // System.out.println("Se ha producido un error");
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Programa finalizado");
        }
    }
}
