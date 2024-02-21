package org.socialmeli.repository;

import lombok.Data;
import org.socialmeli.entity.Post;
import org.socialmeli.entity.Product;
import org.socialmeli.entity.User;
import org.socialmeli.entity.Vendor;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@Repository
public class PostRepositoryImp implements IRepository<Post> {
    private List<Post> posts = new ArrayList<>();
    private VendorRepositoryImp vendorRepositoryImp;
    
    public PostRepositoryImp(VendorRepositoryImp vendorRepositoryImp) {
        this.vendorRepositoryImp = vendorRepositoryImp;
        Product product1 = new Product(1, "Camiseta", "Ropa", "Nike", "Blanco", "Con logo");
        Product product2 = new Product(2, "Zapatos", "Calzado", "Adidas", "Negro", "N/A");
        Product product3 = new Product(3, "Bolso", "Accesorio", "Puma", "Rojo", "Cuero");
        Post post1 = new Post(vendorRepositoryImp.findAll().get(0).getUserId(), LocalDate.of(2023, 3, 20), product1, 1, 35.99);
        Post post2 = new Post(vendorRepositoryImp.findAll().get(0).getUserId(), LocalDate.of(2024, 2, 15), product2, 2, 79.99);
        Post post3 = new Post(vendorRepositoryImp.findAll().get(0).getUserId(), LocalDate.now(), product3, 1, 49.99);
        this.save(post1);
        this.save(post2);
        this.save(post3);
    }

    private Integer autoIncrementId() {
        Post.postIdCounter ++;
        return Post.postIdCounter;
    }

    public List<Post> findAll() {
        return posts;
    }

    public Integer save(Post post) {
        post.setPostId(autoIncrementId());
        posts.add(post);
        return post.getPostId();
    }

    public Post findOne(Integer id) {
        return posts.stream()
                .filter(client -> client.getPostId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public void deleteOne(Integer id) {
        posts.removeIf(c -> c.getPostId().equals(id));
    }

    public List<Vendor> getFollowedList(User client, List<Vendor> vendorList) {
        List<Vendor> auxListVendors = new ArrayList<>();
        for (Vendor vendor: vendorList) {
            for (int i=0; i<client.getFollowing().size(); i++) {
                if (vendor.getUserId().intValue() == client.getFollowing().get(i).getUserId()) {
                    auxListVendors.add(vendor);
                }
            }
        }
        return auxListVendors;
    }
}
