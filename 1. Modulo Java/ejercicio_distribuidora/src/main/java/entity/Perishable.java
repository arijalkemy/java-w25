package entity;

public class Perishable extends Product {
    private int daysToEspire;

    public Perishable(String name, double price, int daysToEspire) {
        super(name, price);
        this.daysToEspire = daysToEspire;
    }
    @Override
    public String toString() {
        return "Perishable{" +
                "daysToEspire=" + daysToEspire +
                '}';
    }

    public int getDaysToEspire() {
        return daysToEspire;
    }

    public void setDaysToEspire(int daysToEspire) {
        this.daysToEspire = daysToEspire;
    }

    @Override
    public double calculate(double amount) {
        double normalAmount = super.calculate(amount);
        return switch (daysToEspire) {
            case 1 -> normalAmount / 4;
            case 2 -> normalAmount / 3;
            case 3 -> normalAmount / 2;
            default -> normalAmount;
        };
    }
}