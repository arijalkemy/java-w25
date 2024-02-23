package com.grupo08.socialmeli.repository;

import com.grupo08.socialmeli.dto.request.PostPromoDto;
import com.grupo08.socialmeli.entity.Product;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Repository
public class PostPromoRepoImpl implements IPostPromoRepo{

    List<PostPromoDto> listPromo= new ArrayList<PostPromoDto>(){{
        add(new PostPromoDto(
                1, LocalDate.of(2024,2,20),
                new Product(124,
                    "Silla Gamer",
                    "Gamer",
                    "Racer",
                    "Red & Black",
                    "Special Edition"
                ),
                1,
                1000,
                true,
                1.45
                ));
    }};
    @Override
    public void insertPost(PostPromoDto postPromoDto) {
        listPromo.add(postPromoDto);
        System.out.println("Insertado post promo");
    }

    @Override
    public List<PostPromoDto> getAll() {
        return listPromo;
    }

    @Override
    public Optional<PostPromoDto> getPostByProductId(int productId) {
        return listPromo.stream().filter(postPromoDto -> postPromoDto.getProduct().getProductId()==productId).findFirst();
    }

    @Override
    public List<PostPromoDto> getByIdUser(int idUser) {
        return listPromo.stream().filter(p->p.getUser_id()==idUser).toList();
    }
}
