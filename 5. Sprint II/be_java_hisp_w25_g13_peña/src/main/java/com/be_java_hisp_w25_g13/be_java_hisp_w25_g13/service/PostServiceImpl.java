package com.be_java_hisp_w25_g13.be_java_hisp_w25_g13.service;

import com.be_java_hisp_w25_g13.be_java_hisp_w25_g13.dto.PostDTO;
import com.be_java_hisp_w25_g13.be_java_hisp_w25_g13.dto.SellerPostDTO;
import com.be_java_hisp_w25_g13.be_java_hisp_w25_g13.entity.Post;
import com.be_java_hisp_w25_g13.be_java_hisp_w25_g13.entity.Product;
import com.be_java_hisp_w25_g13.be_java_hisp_w25_g13.entity.Seller;
import com.be_java_hisp_w25_g13.be_java_hisp_w25_g13.entity.User;
import com.be_java_hisp_w25_g13.be_java_hisp_w25_g13.exception.AlreadyExistException;
import com.be_java_hisp_w25_g13.be_java_hisp_w25_g13.exception.BadRequestException;
import com.be_java_hisp_w25_g13.be_java_hisp_w25_g13.exception.NotFoundException;
import com.be_java_hisp_w25_g13.be_java_hisp_w25_g13.repository.IPostRepository;
import com.be_java_hisp_w25_g13.be_java_hisp_w25_g13.repository.IUserRepository;
import com.be_java_hisp_w25_g13.be_java_hisp_w25_g13.utils.Constants;
import com.be_java_hisp_w25_g13.be_java_hisp_w25_g13.utils.Mapper;
import com.be_java_hisp_w25_g13.be_java_hisp_w25_g13.utils.OrderBy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PostServiceImpl implements IPostService{
    @Autowired
    IPostRepository postRepository;
    @Autowired
    ProductServiceImpl productService;
    @Autowired
    IUserRepository userRepository;

    @Override
    public PostDTO addPost(PostDTO postDTO) {
        Post post= Mapper.mapPostDtoToPost(postDTO);

        Optional<Product> product=productService.getProductById(post.getProduct().getProductId());
        Optional<User> user = userRepository.getUserById(postDTO.getUserId());

        if(user.isEmpty()){
            throw new NotFoundException(Constants.USER_NOT_FOUND_ERROR_MESSAGE);
        }
        if((!(user.get() instanceof Seller))){
            throw new BadRequestException(Constants.USER_IS_NOT_SELLER_ERROR_MESSAGE);
        }
        if(product.isPresent()){
            throw new AlreadyExistException(Constants.PRODUCT_ALREADY_HAVE_POST_ERROR_MESSAGE);
        }

        postRepository.addPost(post);
        productService.addProduct(postDTO.getProduct());

        return postDTO;
    }

    @Override
    public List<PostDTO> getPosts(Integer idUsuario) {
        return null;
    }

    @Override
    public SellerPostDTO getPostPerSeller(Integer id, String orderBy) {
        Optional<User> user = userRepository.getUserById(id);
        if (user.isEmpty()){
            throw new NotFoundException(Constants.USER_NOT_FOUND_ERROR_MESSAGE);
        }
        LocalDate actualDate = LocalDate.now();
        List<Post> posts = new ArrayList<>();
        for (Seller seller:user.get().getFollowing()) {
            List<Post> postBySeller = postRepository
                .filterByUserIdAndBetweenDate(seller.getUserId(), actualDate.minusDays(14), actualDate);

            if (!postBySeller.isEmpty()) {
                posts.addAll(postBySeller);
            }
        }

        if (posts.isEmpty()) {
            throw new NotFoundException(Constants.FOLLOWED_DONT_HAVE_POSTS_ERROR_MESSAGE);
        }

        return new SellerPostDTO(id, orderPostList(posts, orderBy).stream().map(Mapper::mapPostToPost2DTO).toList());
    }
    public List<Post> orderPostList(List<Post> posts, String orderBy){

        return switch (orderBy) {
            case Constants.ORDER_DATE_ASC -> OrderBy.orderByDateAsc(posts);
            case Constants.ORDER_DATE_DESC -> OrderBy.orderByDateDes(posts);
            case Constants.NOT_ORDER -> posts;
            default ->
                throw new BadRequestException(
                    Constants.BAD_DATE_ORDER_TYPE_ERROR_MESSAGE
                );
        };
    }
}
