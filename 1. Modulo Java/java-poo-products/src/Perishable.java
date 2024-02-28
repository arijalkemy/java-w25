public class Perishable extends Product{
    private int daysToExpire;

    public Perishable(String name, double price, int daysToExpire) {
        super(name, price);
        this.daysToExpire = daysToExpire;
    }

    @Override
    public double calculate(int quantityProducts) {
        if(daysToExpire == 1)
            return super.calculate(quantityProducts)/4;
        else if(daysToExpire == 2)
            return super.calculate(quantityProducts)/3;
        else if(daysToExpire == 3)
            return super.calculate(quantityProducts)/2;
        else
            return super.calculate(quantityProducts);
    }

    @Override
    public String toString() {
        return "Perishable{" +
                "daysToExpire=" + daysToExpire +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
