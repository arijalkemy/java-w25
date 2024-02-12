package bootcamp.poo2;

import java.util.ArrayList;
import java.util.List;

public class Distributor {
    public static void main(String[] args) {
        List<Products> productsList= new ArrayList<>();
        productsList.add( new Products("Generic",50));
        productsList.add(new Perishable("Yogurt Fresa",120,3));
        productsList.add( new Perishable("Yogurt Coco",120,2));
        productsList.add(new Perishable("Yogurt durazno",120,1));
        productsList.add( new Products("Generic",120));

        double total=0;
        for (Products products: productsList){
            System.out.println(products.toString());
            products.calculate(1);
            total += products.getPrice();
        }
        System.out.println("total = " + total);
    }
}
