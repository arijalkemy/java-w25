package entity;

public class Vehicle {
    private String model;
    private String brand;
    private Integer cost;

    public Vehicle(String model, String brand, Integer cost) {
        this.model = model;
        this.brand = brand;
        this.cost = cost;
    }

    public String getModel() {
        return model;
    }

    public String getBrand() {
        return brand;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "model='" + model + '\'' +
                ", brand='" + brand + '\'' +
                ", cost=" + cost +
                '}';
    }

    public Integer getCost() {
        return cost;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }
}
