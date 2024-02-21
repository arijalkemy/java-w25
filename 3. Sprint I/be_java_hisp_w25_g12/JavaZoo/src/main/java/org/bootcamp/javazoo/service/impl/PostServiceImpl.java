package org.bootcamp.javazoo.service.impl;

import org.bootcamp.javazoo.dto.PostResponseDto;
import org.bootcamp.javazoo.dto.response.MessageDto;
import org.bootcamp.javazoo.entity.Seller;
import org.bootcamp.javazoo.exception.NotFoundException;
import org.bootcamp.javazoo.helper.Mapper;
import org.bootcamp.javazoo.service.interfaces.ISellerService;
import org.springframework.stereotype.Service;
import org.bootcamp.javazoo.dto.PostDto;
import org.bootcamp.javazoo.dto.response.PostsFollowedUserDto;
import org.bootcamp.javazoo.entity.Post;
import org.bootcamp.javazoo.exception.BadRequestException;
import org.bootcamp.javazoo.repository.interfaces.IPostRepository;
import org.bootcamp.javazoo.service.interfaces.IPostService;

import java.time.LocalDate;
import java.util.List;

import org.bootcamp.javazoo.service.interfaces.IUserService;

import java.util.Comparator;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements IPostService {
    private final IUserService userService;
    private final IPostRepository postRepository;
    private final ISellerService sellerService;

    public PostServiceImpl(IUserService userService, IPostRepository postRepository, ISellerService sellerService) {
        this.userService = userService;
        this.postRepository = postRepository;
        this.sellerService = sellerService;

    }

    public List<PostResponseDto> sortPostDto(List<PostResponseDto> posts, String order){
        if(order.equals("date_asc")){
            return posts.stream()
                    .sorted(Comparator.comparing(PostResponseDto::getDate))
                    .collect(Collectors.toList());

        } else if (order.equals("date_desc")) {
            return posts.stream()
                    .sorted(Comparator.comparing(PostResponseDto::getDate).reversed())
                    .collect(Collectors.toList());
        } else {
            throw new BadRequestException("'order' parameter in endpoint path is invalid");
        }
    }
    @Override
    public List<PostResponseDto> getPostsBySeller(int userId, String order){
        List<Seller> sellers = userService.getUserFollowed(userId);
        if(sellers.isEmpty()) throw new NotFoundException("the user does not follow any seller");
        return sellers.stream().flatMap(seller1 -> {
            if(!seller1.getPosts().isEmpty()){
                List<Post> postBySeller = filterPostsByWeeksAgo(2, seller1.getPosts().stream().map(postRepository::getById).toList());
                return postBySeller.stream()
                        .map(p -> Mapper.mapToPostDto(p, seller1.getId()));
            }
            return null;
        }).toList();
    }
    @Override
    public PostsFollowedUserDto getPostsBySellerOfUser(int userId, String order){
        List<PostResponseDto> postDtos = getPostsBySeller(userId, order);
        if(!(order == null)){
            postDtos = sortPostDto(postDtos, order);
        }
        return Mapper.mapToPostsFollowedUserDto(postDtos, userId);
    }
    public List<Post> filterPostsByWeeksAgo(int weeks, List<Post> posts){
        LocalDate weeksAgo = LocalDate.now().minusWeeks(weeks);
        return posts.stream()
                .filter(post -> post.getDate().isAfter(weeksAgo))
                .collect(Collectors.toList());
    }
    @Override
    public MessageDto addNewPost(PostDto postDto) {
        Seller seller = sellerService.getById(postDto.getUser_id());
        if(seller == null) {
            throw new NotFoundException("Seller not found");
        }
        Post post = Mapper.convertDtoToPost(postDto, postRepository.getCounter());
        postRepository.addNewPost(post);
        seller.addPost(post.getId());
        return new MessageDto("The publication was created successfully");
    }
}
