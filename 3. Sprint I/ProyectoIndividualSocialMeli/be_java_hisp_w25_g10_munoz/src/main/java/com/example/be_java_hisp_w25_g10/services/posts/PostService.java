package com.example.be_java_hisp_w25_g10.services.posts;

import com.example.be_java_hisp_w25_g10.dtos.*;
import com.example.be_java_hisp_w25_g10.entities.Post;
import com.example.be_java_hisp_w25_g10.entities.Product;
import com.example.be_java_hisp_w25_g10.entities.User;
import com.example.be_java_hisp_w25_g10.exceptions.BadRequestException;
import com.example.be_java_hisp_w25_g10.exceptions.NotFoundException;
import com.example.be_java_hisp_w25_g10.repositories.IRepository;
import com.example.be_java_hisp_w25_g10.utils.PostMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.lang.Boolean.TRUE;

@Service
public class PostService implements IPostService {

    @Autowired
    IRepository repository;

    @Override
    public List<PostCreatedDto> getDiscountedPosts() {
        List<Post> posts = repository.getAllPosts();
        List<Post> discountedPosts = posts.stream()
                .filter(post -> post.getProduct().getHasPromo())
                .collect(Collectors.toList());
        return PostMapper.ListToDto(discountedPosts);
    }

    @Override
    public PostsDto getPostsFollowed(int userId, String sortOrder) {
        List<Post> posts = this.repository.getFollowedPosts(userId, sortOrder);
        List<PostDto> postsFollowed = new ArrayList<>();

        if (posts.isEmpty()) {
            throw new NotFoundException("No hay posts de los ultimos 20 dias de tus vendedores");
        }

        posts.forEach(p -> postsFollowed.add(new PostDto(
                p.getUser().getId(),
                p.getId(),
                p.getDate(),
                this.convertToProductDto(p.getProduct())
        )));

        postsFollowed.sort(Comparator.comparing(PostDto::date));

        return new PostsDto(userId, postsFollowed);
    }
    @Override
    public PostCreatedDto createPost(PostCreatedDto newPost){
        Post convertedPost;
        Optional<User> user= this.repository.findUser(newPost.user_id());
        if(user.isEmpty()){
            throw new BadRequestException("No existe vendedor");
        }

        convertedPost = PostMapper.fromDto(newPost, user.get());

        if (repository.validatePost(convertedPost.getUser().getId()) == TRUE){
            repository.addPost(convertedPost);
        }else{
            throw new BadRequestException("Ese vendedor no existe");
        }

        return PostMapper.toDto(convertedPost) ;
    }

    @Override
    public List<PostCreatedDto> verPosts() {
        List<Post> posts = repository.verPost();
        return PostMapper.ListToDto(posts);
    }


    private ProductDto convertToProductDto(Product product) {
        return new ProductDto(
                product.getId(),
                product.getName(),
                product.getType(),
                product.getBrand(),
                product.getColor(),
                product.getNotes(),
                product.getCategory(),
                product.getPrice(),
                product.getDiscount(),
                product.getHasPromo()
        );
    }

    public DiscountedPostsCountDto countDiscountedPosts(int userId) {
    User user = repository.findUser(userId).orElseThrow(() -> new NotFoundException("User not found"));
    int count = getDiscountedPosts().size();

    DiscountedPostsCountDto dto = new DiscountedPostsCountDto();
    dto.setUser_id(user.getId());
    dto.setUser_name(user.getName());
    dto.setPromo_products_count(count);

    return dto;
}


}
