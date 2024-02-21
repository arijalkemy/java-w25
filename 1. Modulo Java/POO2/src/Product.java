public abstract class Product {

    private String name;
    private Double price;
    
    public Product(String name, Double price) {
        this.name = name;
        this.price = price;
    }

    //Crear el método calcular() al cual vamos a pasarle un parámetro de tipo int llamado cantidadDeProductos; este método tiene que multiplicar el precio por la cantidad de productos pasados.
    protected Double calculate(Integer quantityOfProducts){
        return this.price*quantityOfProducts;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product [name=" + name + ", price=" + price + "]";
    }
}
