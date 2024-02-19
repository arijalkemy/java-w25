package com.example.be_java_hisp_w25_g01.repository.impl;

import com.example.be_java_hisp_w25_g01.entity.Product;
import com.example.be_java_hisp_w25_g01.repository.IProductRepository;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Repository
public class ProductRepositoryImpl implements IProductRepository {
    private List<Product> listOfProducts = List.of(
            new Product(1,"Silla Gamer", "Gamer", "Razer", "Red & Black", "Special Edition"),
            new Product(2, "Mouse inalámbrico", "Oficina", "LG", "Black", "Bateria Incluida"),
            new Product(3,"Auriculares Gamer", "Gamer", "Razer", "Black & Red & RGB", "C Microfono"),
            new Product(4, "Notbook Dell 4", "Oficina", "DELL", "Grey", "I7"),
            new Product(62,"Headset RGB Inalámbrico", "Gamer", "Razer", "Green with RGB", "Sin batería")
    );

    public List<Product> getAll(){
        return listOfProducts;
    };
    public Optional<Product> findById(Integer id){
        return listOfProducts.stream()
                .filter(p-> id.equals(p.getProductId()))
                .findFirst();
    };


}
