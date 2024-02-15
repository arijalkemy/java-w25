/*
Inicia creando una clase Vehículo con los atributos modelo, marca y costo. Luego crea una clase garaje
con los atributos id o identificador único y una lista de vehículos. Crea además los constructores de las clases
y los métodos Setter y Getter.
*/

public class Vehicle {
    private String model;
    private String brand;
    private double cost;

    public Vehicle(String brand, String model, double cost) {
        this.model = model;
        this.brand = brand;
        this.cost = cost;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }
}
