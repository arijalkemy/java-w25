package meliboot;

public class Report implements IPrinter{
    @Override
    public void Print() {
        System.out.println("Imprimiendo texto de n longitud y cantidad de paginas con su autor y revisor");
    }
}
