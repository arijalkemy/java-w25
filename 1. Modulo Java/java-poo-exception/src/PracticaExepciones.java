public class PracticaExepciones {
    public int a;
    public int b;

    public PracticaExepciones(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public double calcularWithTryCatch() {
        try {
            return (double) this.b / this.a;
        } catch (Exception e) {
            System.out.println("Se ha producido un error");
        } finally {
            System.out.println("Programa finalizado");
        }
        return 0;
    }

    public double calcularWithException() {
        if (this.a == 0)
            throw new IllegalArgumentException("No se puede dividir por 0");
        return (double) this.b / this.a;
    }


}