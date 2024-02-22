package com.grupo08.socialmeli.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.grupo08.socialmeli.dto.response.CountPromoPostDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grupo08.socialmeli.dto.ExceptionDto;
import com.grupo08.socialmeli.dto.PostDto;
import com.grupo08.socialmeli.entity.Post;
import com.grupo08.socialmeli.entity.Seller;
import com.grupo08.socialmeli.exception.AlreadyExistException;
import com.grupo08.socialmeli.exception.BadRequestException;
import com.grupo08.socialmeli.exception.NotFoundException;
import com.grupo08.socialmeli.repository.IPostRepository;
import com.grupo08.socialmeli.repository.ISellerRepository;
import com.grupo08.socialmeli.utils.PostMapper;

@Service
public class PostServiceImp implements IPostService {

    @Autowired
    IPostRepository postRepository;

    @Autowired
    ISellerRepository sellerRepository;

    @Override
    public List<PostDto> getAll() {
        return PostMapper.ListToDto(postRepository.getAll());
    }

    @Override
    public ExceptionDto insertPost(PostDto postDto){

        this.findExceptionsPostDto(postDto);

        Post post = PostMapper.fromDto(postDto);
        postRepository.insertPost(post);

        return new ExceptionDto("Todo Ok");
    }

    @Override
    public void findExceptionsPostDto(PostDto postDto) {

        if (
            postDto.getUserId() == null ||
            postDto.getDate() == null ||
            postDto.getProduct() == null ||
            postDto.getProduct().getProductId() == null ||
            postDto.getProduct().getProductName() == null ||
            postDto.getProduct().getType() == null ||
            postDto.getProduct().getBrand() == null ||
            postDto.getProduct().getColor() == null ||
            postDto.getProduct().getNotes() == null ||
            postDto.getCategory() == null ||
            postDto.getPrice() == null ||
            postDto.getHasPromo() == null ||
            postDto.getDiscount() == null
        )
            throw new BadRequestException("Faltan datos");

        Optional<Seller> getSeller = sellerRepository.findById(postDto.getUserId());
        if (getSeller.isEmpty())
            throw new NotFoundException("No existe vendedor");

        try {
            LocalDate datetime = LocalDate.parse(postDto.getDate(), DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        } catch (Exception e) {
            throw new BadRequestException("Formato para la fecha no valido");
        }

        Optional<Post> getPostByProduct = postRepository.getPostByProductId(postDto.getProduct().getProductId());

        if (getPostByProduct.isPresent())
            throw new AlreadyExistException("Ya existe un producto");
    }

    @Override
    public CountPromoPostDto countPosts(int userId) {
        Optional<Seller> seller = sellerRepository.findById(userId);
        if(seller.isEmpty()) throw new NotFoundException("No existe el usuario.");

        return new CountPromoPostDto(userId, seller.get().getName(), postRepository.getByIdUser((long) userId).stream().filter(Post::isHasPromo).toList().size());
    }

}
