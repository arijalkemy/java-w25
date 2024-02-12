package bootcamp.poo2;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Perishable extends  Products{
    private int dayToExpire;

    public Perishable(String name, double price, int dayToExpire) {
        super(name, price);
        this.dayToExpire = dayToExpire;
    }

    @Override
    public String toString() {
        return "Perishable{" +
                "name="+ super.getName() +" price="+ super.getPrice() +
                " dayToExpire=" + this.dayToExpire +
                '}';
    }

    @Override
    public void calculate(int quantity){
        switch (this.dayToExpire){
            case 1->super.setPrice(super.getPrice()/4);
            case 2->super.setPrice(super.getPrice()/3);
            case 3->super.setPrice(super.getPrice()/2);

        }
       super.calculate(quantity);

    }
}
