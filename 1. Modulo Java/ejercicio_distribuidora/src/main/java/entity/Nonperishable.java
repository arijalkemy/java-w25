package entity;

public class Nonperishable extends Product{
    private String type;

    public Nonperishable(String name, double price, String type) {
        super(name, price);
        this.type = type;
    }
    @Override
    public String toString() {
        return "Nonperishable{" +
                "type='" + type + '\'' +
                '}';
    }

    @Override
    public double calculate(double amount) {
        return super.calculate(amount);
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}