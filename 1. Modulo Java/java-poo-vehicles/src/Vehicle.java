public class Vehicle {
    private String modelo;
    private String brand;
    private double price;

    public Vehicle(String modelo, String brand, double price) {
        this.modelo = modelo;
        this.brand = brand;
        this.price = price;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "modelo='" + modelo + '\'' +
                ", brand='" + brand + '\'' +
                ", price=" + price +
                '}';
    }
}
