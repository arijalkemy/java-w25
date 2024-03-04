package com.example.be_java_hisp_w25_g10.services.posts;

import com.example.be_java_hisp_w25_g10.dtos.PostCreatedDto;
import com.example.be_java_hisp_w25_g10.dtos.PostDto;
import com.example.be_java_hisp_w25_g10.dtos.PostsDto;
import com.example.be_java_hisp_w25_g10.dtos.ProductDto;
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

import static java.lang.Boolean.TRUE;

@Service
public class PostService implements IPostService {

    @Autowired
    IRepository repository;

    @Override
    public PostsDto getPostsFollowed(int userId,String sortOrder) {
        List<Post> posts = this.repository.getFollowedPosts(userId);
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


        if ("date_desc".equals(sortOrder)) {
            postsFollowed.sort(Comparator.comparing(PostDto::date).reversed());
        } else if ("date_asc".equals(sortOrder)) {
            postsFollowed.sort(Comparator.comparing(PostDto::date));
        } else {
            throw new BadRequestException("El tipo de ordenamiento especificado no es válido");
        }

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
                product.getPrice()
        );
    }
}
