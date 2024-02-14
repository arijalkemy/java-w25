import entity.Car;

public class Main {
    public static void main(String[] args) {
        Car herbie = new Car("Volkswagen", "White", 65426);
        System.out.println(herbie.mostrarMarcaYColor());
    }
}
