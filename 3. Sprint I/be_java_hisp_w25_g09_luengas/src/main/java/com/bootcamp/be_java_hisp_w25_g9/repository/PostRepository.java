package com.bootcamp.be_java_hisp_w25_g9.repository;

import com.bootcamp.be_java_hisp_w25_g9.model.Post;
import com.bootcamp.be_java_hisp_w25_g9.model.Product;
import com.bootcamp.be_java_hisp_w25_g9.repository.interfaces.IPostRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Repository
public class PostRepository implements IPostRepository {

    List<Post> postList = new ArrayList<>();
    public PostRepository(){
        loadPostList();
    }

    public void addPost(Post post){
        postList.add(post);
    }

    public List<Post> findAll(){
        return postList;
    }

    public void loadPostList(){
        ArrayList<Product> productList = new ArrayList<>();
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

        LocalDate currentDate = LocalDate.now();
        int postIdCounter = 1;
        for (Product product : productList) {
            Random rand = new Random();
            postList.add(new Post(postIdCounter++, rand.nextInt(25, 50), rand.nextInt(40), currentDate, product, rand.nextDouble(50.00), false, 0.0));
        }
        postList.add(new Post(postIdCounter++, 29, 25, LocalDate.of(2024,02,10), productList.get(1), 78.0, false, 0.0));
        postList.add(new Post(postIdCounter++, 29, 25,  currentDate, productList.get(1), 78.0, false, 0.0));
        postList.add(new Post(postIdCounter++, 29, 25, LocalDate.of(2024,02,14), productList.get(1), 78.0, false, 0.0));
        postList.add(new Post(postIdCounter++, 29, 25, LocalDate.of(2024,01,10), productList.get(1), 78.0, false, 0.0));
        postList.add(new Post(postIdCounter++, 30, 25, LocalDate.of(2024,02,14), productList.get(1), 78.0, false, 0.0));
    }

}
