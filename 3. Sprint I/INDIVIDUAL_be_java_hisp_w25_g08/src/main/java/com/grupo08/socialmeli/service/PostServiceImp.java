package com.grupo08.socialmeli.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

import com.grupo08.socialmeli.dto.PromoPostDto;
import com.grupo08.socialmeli.dto.response.ProductPromoCountDto;
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
        List<PostDto> listPostDtos = PostMapper.ListToDto(postRepository.getAll());
        return listPostDtos;
    }

    @Override
    public ExceptionDto insertPost(PostDto postDto){

        this.findExceptionsPostDto(postDto);
        
        Post post = PostMapper.fromDto(postDto);
        postRepository.insertPost(post);

        return new ExceptionDto("Todo Ok");
    }

    @Override
    public ExceptionDto insertPromoPost(PromoPostDto promoPostDto) {
        this.findExceptionsPromoPostDto(promoPostDto);
        if(!promoPostDto.isHas_promo() || promoPostDto.getDiscount() <= 0.0) throw new BadRequestException("El producto debe tener una promoción activa");

        Post post = PostMapper.fromPromoDto(promoPostDto);
        postRepository.insertPost(post);

        return new ExceptionDto("Insertado correctamente: "+ postRepository.getAll());
    }

    @Override
    public ProductPromoCountDto countPromoPost(int sellerId) {
        if(sellerRepository.findById(sellerId).isEmpty()) throw new NotFoundException("El usuario no existe");

        Seller seller = sellerRepository.findById(sellerId).get();
        long promoProductsCount = postRepository.getByIdUser(Long.valueOf(sellerId)).stream().filter(Post::isHasPromo).count();

        return new ProductPromoCountDto(sellerId,seller.getName(),promoProductsCount);
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
            postDto.getPrice() == null
        )
            throw new BadRequestException("Faltan datos");

        Optional<Seller> getSeller = sellerRepository.findById(postDto.getUserId());
        if (!getSeller.isPresent())
            throw new NotFoundException("No existe vendedor");

        try {
            LocalDate datetime = LocalDate.parse(postDto.getDate(), DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        } catch (Exception e) {
            throw new BadRequestException("Formato para la fecha no valido");
        }

        Optional<Post> getPostbyProduct = postRepository.getPostByProductId(postDto.getProduct().getProductId());

        if (!getPostbyProduct.isPresent())
            throw new AlreadyExistException("Ya existe un producto");
    }

    public void findExceptionsPromoPostDto(PromoPostDto promoPostDto) {

        if (
                promoPostDto.getUser_id() == null ||
                        promoPostDto.getDate() == null ||
                        promoPostDto.getProduct() == null ||
                        promoPostDto.getProduct().getProductId() == null ||
                        promoPostDto.getProduct().getProductName() == null ||
                        promoPostDto.getProduct().getType() == null ||
                        promoPostDto.getProduct().getBrand() == null ||
                        promoPostDto.getProduct().getColor() == null ||
                        promoPostDto.getProduct().getNotes() == null ||
                        promoPostDto.getCategory() == null ||
                        promoPostDto.getPrice() == null
        )
            throw new BadRequestException("Faltan datos: ");

        Optional<Seller> getSeller = sellerRepository.findById(promoPostDto.getUser_id());
        if (!getSeller.isPresent())
            throw new NotFoundException("No existe vendedor");

        try {
            LocalDate datetime = LocalDate.parse(promoPostDto.getDate(), DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        } catch (Exception e) {
            throw new BadRequestException("Formato para la fecha no valido");
        }

        Optional<Post> getPostbyProduct = postRepository.getPostByProductId(promoPostDto.getProduct().getProductId());

        if (getPostbyProduct.isPresent())
            throw new AlreadyExistException("Ya existe un producto");
    }
    
}
