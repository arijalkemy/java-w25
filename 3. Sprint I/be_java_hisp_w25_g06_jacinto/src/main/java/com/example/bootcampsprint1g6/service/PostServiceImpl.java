package com.example.bootcampsprint1g6.service;

import com.example.bootcampsprint1g6.dto.PostListDTO;
import com.example.bootcampsprint1g6.dto.request.PostPromoRequestDTO;
import com.example.bootcampsprint1g6.dto.request.PostRequestDTO;
import com.example.bootcampsprint1g6.dto.response.PostPromoCountResponse;
import com.example.bootcampsprint1g6.dto.response.PostPromoListResponse;
import com.example.bootcampsprint1g6.dto.response.PostPromoResponseDTO;
import com.example.bootcampsprint1g6.dto.response.PostResponseDTO;
import com.example.bootcampsprint1g6.entity.PostPromo;
import com.example.bootcampsprint1g6.exception.BadRequestException;
import com.example.bootcampsprint1g6.exception.NotFoundException;
import com.example.bootcampsprint1g6.repository.IPostRepository;
import com.example.bootcampsprint1g6.repository.IUserRepository;
import com.example.bootcampsprint1g6.repository.PostRepositoryImpl;
import com.example.bootcampsprint1g6.repository.UserRepositoryImpl;
import com.example.bootcampsprint1g6.util.mapper.PostMapper;
import com.example.bootcampsprint1g6.util.validator.PostValidator;
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

    @Override
    public PostResponseDTO createPost(PostRequestDTO request){

        if (!PostValidator.validateRequestDTO(request))
            throw new BadRequestException("Datos incorrectos en la solicitud");

        Optional<User> user = userRepository.findById(request.getUserId());
        if (user.isEmpty())
            throw new NotFoundException("No se puede crear el post ya que el usuario con id " + request.getUserId() + " no existe.");
        if(! user.get().getClass().equals(Seller.class))
            throw new BadRequestException("El usuario no es un vendedor. No se puede concretar la operación.");

        Post postToCreate = PostMapper.getEntityInstance(request, (Seller) user.get());
        Post postCreated = postRepository.save(postToCreate);
        userRepository.addPostToUser(postCreated);
        return PostMapper.getResponseInstance(postCreated);
    }

    @Override
    public PostListDTO getLastPostsByFollowed(Integer userId, String order) {
        Optional<User> user = userRepository.findById(userId);
        if (user.isEmpty())
            throw new NotFoundException("No se puede crear el post ya que el usuario con id " + userId + " no existe.");
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
    public PostPromoResponseDTO createPostPromo(PostPromoRequestDTO request) {
        if (!request.getHasPromo())
            throw new IllegalArgumentException("El argumento has_promo debe ser true.");

        if (!PostValidator.validateRequestDTO(request))
            throw new BadRequestException("Datos incorrectos en la solicitud");

        Optional<User> user = userRepository.findById(request.getUserId());
        if (user.isEmpty())
            throw new NotFoundException("No se puede crear el post ya que el usuario con id " + request.getUserId() + " no existe.");
        if(! user.get().getClass().equals(Seller.class))
            throw new BadRequestException("El usuario a seguir no es un vendedor. No se puede concretar la operación.");

        PostPromo postToCreate = PostMapper.getEntityInstance(request, (Seller) user.get());
        PostPromo postCreated = (PostPromo) postRepository.save(postToCreate);
        userRepository.addPostToUser(postCreated);
        return (PostPromoResponseDTO) PostMapper.getResponseInstance(postCreated);
    }

    @Override
    public PostPromoCountResponse getAmountOfPostPromoOfSeller(Integer userId) {
        PostPromoListResponse listPromos = getListOfPostPromoOfSeller(userId);
        return PostPromoCountResponse.builder()
                .userId(userId)
                .userName(listPromos.getUserName())
                .amountOfPostPromo(listPromos.getPosts().size())
                .build();
    }

    @Override
    public PostPromoListResponse getListOfPostPromoOfSeller(Integer userId) {
        Optional<User> user = userRepository.findById(userId);
        if (user.isEmpty())
            throw new NotFoundException("No se puede crear el post ya que el usuario con id " + userId + " no existe.");

        List<Post> posts = postRepository.findByUserId(userId);
        List<PostPromo> postPromos = posts.stream().filter(p -> p.getClass().equals(PostPromo.class)).map(p -> (PostPromo) p).toList();

        return PostPromoListResponse.builder()
                .userId(userId)
                .userName(user.get().getUserName())
                .posts(postPromos.stream().map(p -> (PostPromoResponseDTO) PostMapper.getResponseInstance(p)).toList())
                .build();
    }

}
