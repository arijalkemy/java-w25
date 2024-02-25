package meliboot;

public class Pershable extends Product {
    private int daysToExpire;
    public Pershable(String name, Double price,int daysToExpire) {
        super(name, price);
        this.daysToExpire = daysToExpire;
    }
    public Double toCalculate(int quantityOfProducts){
        Double amountToPay = this.price*quantityOfProducts;
        Double amountToDiscount = this.daysToExpire == 1 ? amountToPay/4
                : this.daysToExpire == 2 ? amountToPay / 3 : amountToPay / 2;
        return amountToPay-amountToDiscount ;
    }

    @Override
    public String toString() {
        return "Pershable{" +
                "daysToExpire=" + daysToExpire +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    public int getDaysToExpire() {
        return daysToExpire;
    }

    public void setDaysToExpire(int daysToExpire) {
        this.daysToExpire = daysToExpire;
    }
}
