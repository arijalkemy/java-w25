package org.bootcamp.javazoo.service.impl;

import org.bootcamp.javazoo.dto.PostResponseDto;
import org.bootcamp.javazoo.dto.response.MessageDto;
import org.bootcamp.javazoo.entity.Seller;
import org.bootcamp.javazoo.helper.CollectionSorter;
import org.bootcamp.javazoo.helper.FilterListByWeeks;
import org.bootcamp.javazoo.helper.Mapper;
import org.bootcamp.javazoo.service.interfaces.IFindService;
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
    private final IFindService findService;

    public PostServiceImpl(IUserService userService, IPostRepository postRepository, IFindService findService) {
        this.userService = userService;
        this.postRepository = postRepository;
        this.findService = findService;

    }

    private List<PostResponseDto> getPostsBySeller(int userId, String order){
        List<Seller> sellers = userService.getUserFollowed(userId);
        return sellers.stream().flatMap(seller1 -> {
            if(!seller1.getPosts().isEmpty()){
                List<Post> postBySeller = FilterListByWeeks.filterPostsByWeeksAgo(2, seller1.getPosts().stream().map(postRepository::getById).toList());
                return postBySeller.stream()
                        .map(p -> Mapper.mapToPostDto(p, seller1.getId()));
            }
            return null;
        }).toList();
    }
    @Override
    public PostsFollowedUserDto getPostsBySellerOfUser(int userId, String order){
        List<PostResponseDto> postDtos = this.getPostsBySeller(userId, order);
        postDtos = CollectionSorter.sortPostDtoByDate(postDtos, order);
        return Mapper.mapToPostsFollowedUserDto(postDtos, userId);
    }
    @Override
    public MessageDto addNewPost(PostDto postDto) {
        Seller seller = findService.getSellerById(postDto.getUser_id());
        Post post = Mapper.convertDtoToPost(postDto, postRepository.getCounter());
        postRepository.addNewPost(post);
        seller.addPost(post.getId());
        return new MessageDto("The publication was created successfully");
    }
}
