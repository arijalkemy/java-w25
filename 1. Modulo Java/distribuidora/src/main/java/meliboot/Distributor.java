package meliboot;

import java.util.List;

public class Distributor {
    public static void main(String[] args) {

        List<Product> products = List.of(
                new Product("Sal",23.00),
                new Product("Azucar",26.00),
                new NoPershable("Mango",33.23,"Fruto"),
                new NoPershable("Mora",53.23,"Fruto"),
                new Pershable("Arepa",21.33,2),
                new Pershable("Frijol",23.33,4)
        );

        for(Product product:products){
            System.out.println(String.format("Precio total de la venta de 5 %s is %.4f",product.getName(),product.toCalculate(5)));
        }
    }
}