package entity;

public class Car {
    String brand;
    String color;
    double kilometres;

    public Car(String brand, String color, double kilometres) {
        this.brand = brand;
        this.color = color;
        this.kilometres = kilometres;
    }

    public String mostrarMarcaYColor() {
        String marcaYColor = "La marca del auto es: " + this.brand + ". El color del auto es: " + this.color;
        return marcaYColor;
    }
}
