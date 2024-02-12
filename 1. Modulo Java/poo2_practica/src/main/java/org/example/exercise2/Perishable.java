package org.example.exercise2;

public class Perishable extends Product{
    private int daysToExpire;

    public Perishable(String nombre, double precio, int daysToExpire) {
        super(nombre, precio);
        this.daysToExpire = daysToExpire;
    }

    @Override
    public String toString() {
        return "Perishable{" +
                "daysToExpire=" + daysToExpire +
                ", name='" + getName() + '\'' +
                ", price=" + getPrice() +
                '}';
    }

    public int getDaysToExpire() {
        return daysToExpire;
    }

    public void setDaysToExpire(int daysToExpire) {
        this.daysToExpire = daysToExpire;
    }

    @Override
    public double calculate(int productQuantity) {
        int factorToReduce=1;
        if(this.daysToExpire == 3){
            factorToReduce = 2;
        } else if(this.daysToExpire == 2){
            factorToReduce = 3;
        } else if(this.daysToExpire == 1){
            factorToReduce = 4;
        }
        return super.calculate(productQuantity)/factorToReduce;
    }
}
