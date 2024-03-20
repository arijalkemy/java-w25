package com.grupo08.socialmeli.service;

import com.grupo08.socialmeli.dto.ExceptionDto;
import com.grupo08.socialmeli.dto.request.PostPromoDto;
import com.grupo08.socialmeli.dto.response.PromosDto;
import com.grupo08.socialmeli.entity.Post;
import com.grupo08.socialmeli.entity.Seller;
import com.grupo08.socialmeli.exception.AlreadyExistException;
import com.grupo08.socialmeli.exception.BadRequestException;
import com.grupo08.socialmeli.exception.NotFoundException;
import com.grupo08.socialmeli.repository.IPostPromoRepo;
import com.grupo08.socialmeli.repository.ISellerRepository;
import com.grupo08.socialmeli.utils.PostMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class PostPromoServiceImpl implements IPostPromoService{
    @Autowired
    IPostPromoRepo iPostPromoRepo;

    @Autowired
    ISellerRepository sellerRepository;


    @Override
    public List<PostPromoDto> getAll() {
        return null;
    }

    @Override
    public ExceptionDto insertPostPromo(PostPromoDto postPromoDto) {
        this.findExceptionsPostPromoDto(postPromoDto);

        iPostPromoRepo.insertPost(postPromoDto);

        return new ExceptionDto("Todo Ok");

    }

    @Override
    public PromosDto getPromosBySeller(int userId) {
        Optional<Seller> getSeller = sellerRepository.findById(userId);
        if (getSeller.isEmpty())
            throw new NotFoundException("No existe vendedor");

        List<PostPromoDto> listPromos = iPostPromoRepo.getByIdUser(userId);

        return new PromosDto(userId, getSeller.get().getName(), listPromos.size());
    }

    @Override
    public void findExceptionsPostPromoDto(PostPromoDto postPromoDto) {

        if (
                postPromoDto.getUser_id()==0||
                        postPromoDto.getDate() == null ||
                        postPromoDto.getProduct() == null ||
                        postPromoDto.getProduct().getProductId() == null ||
                        postPromoDto.getProduct().getProductName() == null ||
                        postPromoDto.getProduct().getType() == null ||
                        postPromoDto.getProduct().getBrand() == null ||
                        postPromoDto.getProduct().getColor() == null ||
                        postPromoDto.getProduct().getNotes() == null ||
                        postPromoDto.getDiscount()==0.0 ||
                        postPromoDto.getCategory() == 0 ||
                        postPromoDto.getPrice() == 0.0
        )
            throw new BadRequestException("Faltan datos");

        Optional<Seller> getSeller = sellerRepository.findById(postPromoDto.getUser_id());
        if (getSeller.isEmpty())
            throw new NotFoundException("No existe vendedor");



        Optional<PostPromoDto> getPostbyProduct = iPostPromoRepo.getPostByProductId(postPromoDto.getProduct().getProductId());
        if (getPostbyProduct.isPresent()) throw new AlreadyExistException("Ya existe un producto");

    }
}
