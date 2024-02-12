package bootcamp.poo2;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NonPerishable extends  Products{
    private String type;

    public NonPerishable(String name, double price, String type) {
        super(name, price);
        this.type = type;
    }

    @Override
    public String toString() {
        return "Perishable{" +
                "name="+ super.getName() +" price="+ super.getPrice() +
                " dayToExpire=" + this.type +
                '}';
    }


}
