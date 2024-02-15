public class PracticaExcepiones {
    int a = 0;
    int b = 300;

    public void calcular() {
        try {
            System.out.println(b/a);
        } catch (ArithmeticException e) {
            System.out.println("Se ha producido un error");
        } finally {
            System.out.println("Programa finalizado");
        }
    }

    public void calcular2() {
        try {
            if (a == 0) {
                throw new IllegalArgumentException("No se puede dividir por cero");
            } else {
                System.out.println(b/a);
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e);

        } finally {
            System.out.println("Programa finalizado");
        }
    }
}
