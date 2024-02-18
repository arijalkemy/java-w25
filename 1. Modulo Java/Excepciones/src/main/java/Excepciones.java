public class Excepciones {
    int a;
    int b;

    public Excepciones(int a, int b) {
        this.a = a;
        this.b = b;
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
        }
    }
}