package com.example.be_java_hisp_w25_g10.services.posts;


import com.example.be_java_hisp_w25_g10.dtos.PostCreatedDto;
import com.example.be_java_hisp_w25_g10.dtos.PostDto;
import com.example.be_java_hisp_w25_g10.dtos.PostsDto;
import com.example.be_java_hisp_w25_g10.dtos.ProductDto;
import com.example.be_java_hisp_w25_g10.dtos.promos.PromoDto;
import com.example.be_java_hisp_w25_g10.dtos.promos.SummaryPromotionsDto;
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

    @Override
    public PromoDto createPromo(PromoDto dto) {
        Optional<User> user= this.repository.findUser(dto.user_id());
        if(user.isEmpty()){
            throw new BadRequestException("El usuario con id " + dto.user_id() + "no existe");
        }

        Post post = PostMapper.getPostFromPromDto(dto, user.get());
        this.repository.addPost(post);

        return PostMapper.getPromoDtoFromPost(post);
    }

    @Override
    public SummaryPromotionsDto getSummaryPromotions(int userId) {
        Optional<User> user = this.repository.findUser(userId);

        if (user.isEmpty()){
            throw new BadRequestException("El usuario con id" + userId + "no existe");
        }

        List<Post> posts = this.repository.getPromotionsPostsByUser(userId);

        if (posts.isEmpty()){
            throw new NotFoundException("El vendedor con id " + userId + "no tienes productos en promoción");
        }

        return new SummaryPromotionsDto(userId, user.get().getName(), posts.size());
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
