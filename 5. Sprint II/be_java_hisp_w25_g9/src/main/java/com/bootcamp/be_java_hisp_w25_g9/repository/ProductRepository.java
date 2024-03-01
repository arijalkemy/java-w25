package com.bootcamp.be_java_hisp_w25_g9.repository;

import com.bootcamp.be_java_hisp_w25_g9.model.Product;
import com.bootcamp.be_java_hisp_w25_g9.repository.interfaces.IProductRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository implements IProductRepository {

    List<Product> productList = new ArrayList<>();

    public ProductRepository(){
        loadProductList();
    }

    @Override
    public void addProduct(Product product){
        productList.add(product);
    }

    @Override
    public List<Product> findAll(){
        return productList;
    }

    @Override
    public Product getProductById(int id) {
        return productList.stream().filter(x -> x.getProductId() == id).findFirst().orElse(null);
    }

    public void loadProductList(){
        productList.add(new Product(1, "Camisa", "Ropa", "Marca A", "Azul", "Algodón"));
        productList.add(new Product(2, "Pantalón", "Ropa", "Marca B", "Negro", "Poliéster"));
        productList.add(new Product(3, "Zapatos", "Calzado", "Marca C", "Blanco", "Cuero"));
        productList.add(new Product(4, "Gorra", "Accesorio", "Marca D", "Rojo", "Algodón"));
        productList.add(new Product(5, "Bufanda", "Accesorio", "Marca E", "Verde", "Lana"));
        productList.add(new Product(6, "Vestido", "Ropa", "Marca F", "Blanco", "Seda"));
        productList.add(new Product(7, "Pantalones cortos", "Ropa", "Marca G", "Gris", "Algodón"));
        productList.add(new Product(8, "Botas", "Calzado", "Marca H", "Marrón", "Cuero"));
        productList.add(new Product(9, "Sombrero", "Accesorio", "Marca I", "Negro", "Poliéster"));
        productList.add(new Product(10, "Bolso", "Accesorio", "Marca J", "Azul", "Cuero"));
        productList.add(new Product(11, "Chaqueta", "Ropa", "Marca K", "Negro", "Algodón"));
        productList.add(new Product(12, "Falda", "Ropa", "Marca L", "Rojo", "Poliéster"));
        productList.add(new Product(13, "Sandalias", "Calzado", "Marca M", "Blanco", "Cuero"));
        productList.add(new Product(14, "Cinturón", "Accesorio", "Marca N", "Marrón", "Cuero"));
        productList.add(new Product(15, "Collar", "Accesorio", "Marca O", "Dorado", "Metal"));
    }
}
