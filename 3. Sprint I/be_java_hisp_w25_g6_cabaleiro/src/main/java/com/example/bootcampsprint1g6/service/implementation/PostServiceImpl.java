package com.example.bootcampsprint1g6.service.implementation;

import com.example.bootcampsprint1g6.dto.GenericResponseDTO;
import com.example.bootcampsprint1g6.dto.PostListDTO;
import com.example.bootcampsprint1g6.dto.request.PostRequestDTO;
import com.example.bootcampsprint1g6.dto.request.PromoPostRequestDTO;
import com.example.bootcampsprint1g6.dto.response.PostResponseDTO;
import com.example.bootcampsprint1g6.exception.BadRequestException;
import com.example.bootcampsprint1g6.exception.NotFoundException;
import com.example.bootcampsprint1g6.repository.IPostRepository;
import com.example.bootcampsprint1g6.repository.IUserRepository;
import com.example.bootcampsprint1g6.repository.implementation.PostRepositoryImpl;
import com.example.bootcampsprint1g6.repository.implementation.UserRepositoryImpl;
import com.example.bootcampsprint1g6.service.IPostService;
import com.example.bootcampsprint1g6.util.mapper.PostMapper;
import com.example.bootcampsprint1g6.util.validator.PostValidator;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import com.example.bootcampsprint1g6.entity.Post;
import com.example.bootcampsprint1g6.entity.User;
import com.example.bootcampsprint1g6.entity.Seller;

import java.time.LocalDate;
import java.util.*;

@Service
public class PostServiceImpl implements IPostService {

    private IPostRepository postRepository;
    private IUserRepository userRepository;
    public static final String DATE_ASC = "date_asc";
    public static final String DATE_DESC = "date_desc";

    public PostServiceImpl(PostRepositoryImpl postRepository, UserRepositoryImpl userRepository){
        this.postRepository = postRepository;
        this.userRepository = userRepository;
    }

    private Seller findSellerById(Integer id){
        Optional<User> user = userRepository.findById(id);
        if (user.isEmpty())
            throw new NotFoundException("No se puede realizar la operación ya que el usuario con id " + id + " no existe.");
        if(! user.get().getClass().equals(Seller.class))
            throw new BadRequestException("El usuario no es un vendedor. No se puede concretar la operación.");
        return (Seller) user.get();
    }

    @Override
    public PostResponseDTO createPromoPost(PromoPostRequestDTO request){

       if (!PostValidator.validatePromoRequestDTO(request))
            throw new BadRequestException("Datos incorrectos en la solicitud de un post con promo");

        Seller seller = findSellerById(request.getUserId());
        Post postToCreate = PostMapper.getEntityInstanceWithPromo(request, seller);
        Post postCreated = postRepository.save(postToCreate);
        userRepository.addPostToUser(postCreated);
        return PostMapper.getResponseInstance(postCreated);
    }
    @Override
    public PostResponseDTO createPost(PostRequestDTO request){
        if (!PostValidator.validateRequestDTO(request))
            throw new BadRequestException("Datos incorrectos en la solicitud");
        Seller seller = findSellerById(request.getUserId());
        Post postToCreate = PostMapper.getEntityInstance(request, seller);
        Post postCreated = postRepository.save(postToCreate);
        userRepository.addPostToUser(postCreated);
        return PostMapper.getResponseInstance(postCreated);
    }

    @Override
    public PostListDTO getLastPostsByFollowed(Integer userId, String order) {
        Optional<User> user = userRepository.findById(userId);
        if (user.isEmpty())
            throw new NotFoundException("Error. El usuario con id " + userId + " no existe.");
        List<Seller> userFollowed = user.get().getFollowed();
        List<Post> posts = new ArrayList<>();
        for (Seller seller : userFollowed) {
            LocalDate twoWeeksBeforeNow = LocalDate.now().minusWeeks(2);
            List<Post> lastPostsBySeller = seller.getPosts().stream().filter(p -> p.getDate().isAfter(twoWeeksBeforeNow)).toList();
            posts.addAll(lastPostsBySeller);
        }

        if(!DATE_ASC.equals(order) && !DATE_DESC.equals(order) && !Objects.equals(order, ""))
            throw new IllegalArgumentException("El parámetro de ordenamiento no es correcto");

        switch (order) {
            case DATE_ASC:
                posts.sort(Comparator.comparing(Post::getDate));break;
            case DATE_DESC:
                posts.sort(Comparator.comparing(Post::getDate).reversed()); break;
            default: break;
        }

        List<PostResponseDTO> postResponseDTOS = posts.stream().map(PostMapper::getResponseInstance).toList();
        return PostListDTO.builder().userId(userId).posts(postResponseDTOS).build();
    }

    @Override
    public List<PostResponseDTO> getPromoPost(Integer userId){
        Seller seller = findSellerById(userId);
        List<Post> posts = seller.getPosts().stream()
                                            .filter(post -> post.getPromo().isPresent())
                                            .toList();
        return PostMapper.getResponseInstances(posts);
    }

    @Override
    public GenericResponseDTO getAumountPromoPost(Integer userId){
        Seller seller = findSellerById(userId);
        Integer amount = seller.getPosts().stream()
                .filter(post -> post.getPromo().isPresent())
                .toList()
                .size();
        return new GenericResponseDTO(HttpStatus.OK.value(),
                                    "El vendedor tiene " + amount + " promo posts");
    }


}
