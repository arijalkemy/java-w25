package bootcamp.poo2;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@AllArgsConstructor
public class Products {
    private String name;
    private double price;

    @Override
    public String toString() {
        return "Products{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    public void calculate(int quantity){
        System.out.println("total price = " + this.price * quantity);
    }

}
