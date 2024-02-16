public class PracticaExcepciones {
    int a = 0;
    int b = 300;
    public PracticaExcepciones() {
    }

    public int dividir() {
        try {
            if (this.a == 0) throw new IllegalArgumentException("No se puede dividir por zero");
            return  this.b / this.a;
        }
        catch (IllegalArgumentException e) {
            System.out.println(e);
            return 0;
        }
        finally {
            System.out.println("Programa finalizado");
            return 0;
        }
    }
}
