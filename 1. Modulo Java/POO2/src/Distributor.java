import java.util.List;

public class Distributor {
    
    private List<Product> products;
    //Crear una clase ejecutable llamada Distribuidora donde van a crear un array de productos, imprimir el precio total al vender 5 productos de cada tipo. Crear los elementos del array con los datos que quieras.
    public Distributor(List<Product> products){
        this.products = products;
    }

    public void sellProducts(){
        Double totalAmount = 0d;
        for(int i=0;i<this.products.size();i++){
            totalAmount += this.products.get(i).calculate(5);
            System.out.println("El precio a pagar por 5 "+this.products.get(i).getName()+" es: "+this.products.get(i).calculate(5));
        }
        System.out.println("Precio total de lo consumido: $"+totalAmount);
    }

    public void showProducts(){
        for(Product p:this.products){
            System.out.println(p.toString());
        }
    }
}
