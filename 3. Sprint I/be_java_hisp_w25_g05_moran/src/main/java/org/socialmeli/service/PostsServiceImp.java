package org.socialmeli.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.socialmeli.dto.request.FollowedListReqDto;
import org.socialmeli.dto.request.post.BasePostReqDto;
import org.socialmeli.dto.response.*;
import org.socialmeli.dto.response.post.PostDto;
import org.socialmeli.dto.response.post.PostIdDto;
import org.socialmeli.dto.response.post.PromoPostCountDto;
import org.socialmeli.entity.Client;
import org.socialmeli.entity.Post;
import org.socialmeli.entity.Vendor;
import org.socialmeli.exception.BadRequestException;
import org.socialmeli.exception.NotFoundException;
import org.socialmeli.repository.ClientRepositoryImp;
import org.socialmeli.repository.PostRepositoryImp;
import org.socialmeli.repository.VendorRepositoryImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Service
public class PostsServiceImp implements IPostsService {
    @Autowired
    PostRepositoryImp postRepositoryImp;

    @Autowired
    VendorRepositoryImp vendorRepositoryImp;

    @Autowired
    ClientRepositoryImp clientRepositoryImp;
    ObjectMapper mapper = new ObjectMapper();

    @Override
    public FollowedListDto getFollowedList(FollowedListReqDto req) {
        Integer id = req.getUserId();
        String order = req.getOrder();
        // Busca cliente por ID:
        Client client = new Client();
        Vendor vendor = new Vendor();
        List<Vendor> vendorList = new ArrayList<>();
        for (Client c : this.clientRepositoryImp.findAll()) {
            if (c.getUserId().intValue() == id.intValue()) {
                client = c;
            }
        }
        for (Vendor c : this.vendorRepositoryImp.findAll()) {
            if (c.getUserId().intValue() == id.intValue()) {
                vendor = c;
            }
        }
        if (client.getUserId() == null && vendor.getUserId() == null) {
            throw new NotFoundException("No se encontró ningun usuario en el sistema con el ID indicado.");
        }

        // Busca vendedores seguidos cliente:
        if(client.getUserId() != null){
            vendorList= this.postRepositoryImp.getFollowedList(client, this.vendorRepositoryImp.findAll());
        }else{
            vendorList= this.postRepositoryImp.getFollowedList(vendor, this.vendorRepositoryImp.findAll());
        }
        List<PostDto> postDtoList = new ArrayList<>();
        if (vendorList.isEmpty()) {
            throw new NotFoundException("El usuario ingresado no sigue a ningun vendedor.");
        } else {
            // Busca posteos de vendedores que cumplan con los requisitos:
            for (Vendor v : vendorList) {
                for (Post p : postRepositoryImp.findAll()) {
                    if (p.getUserId().intValue() == v.getUserId().intValue()) {
                        if (p.getDate().isAfter(LocalDate.now().minusWeeks(2))) {
                            postDtoList.add(new PostDto(p.getPostId(), p.getUserId(), p.getDate(), new ProductDto(p.getProduct().getProductId(), p.getProduct().getProductName(), p.getProduct().getType(), p.getProduct().getBrand(), p.getProduct().getColor(), p.getProduct().getNotes()),
                            p.getCategory(), p.getPrice()));
                        }
                    }
                }
            }
        }
        if (postDtoList.isEmpty()) {
            throw new NotFoundException("No hay posteos realizados por los vendedores que sigue el usuario las últimas dos semanas.");
        }
        
        // Ordena el ArrayList de posteos:
        if (order.equals("date_asc")) {
            Collections.sort(postDtoList, Comparator.comparing(PostDto::getDate));
        }
        else if (order.equals("date_desc")) {
            Collections.sort(postDtoList, Comparator.comparing(PostDto::getDate, Comparator.reverseOrder()));
        }
        else {
            throw new BadRequestException("Indicación de ordenamiento no válida. La misma tiene que ser \"date_asc\" o \"date_desc\"");
        }
        return new FollowedListDto(id, postDtoList);
    }

    @Override
    public PostIdDto savePost(BasePostReqDto postReqDto) {
        verifyUserExists(postReqDto.getUserId());
        Post post = postReqDto.sendToPostMapper();
        Integer response =  postRepositoryImp.save(post);
        return new PostIdDto(response);
    }

    @Override
    public PromoPostCountDto countPromoPosts(Integer userId) {
        Vendor vendor = vendorRepositoryImp.findOne(userId);

        if(vendor == null) throw new NotFoundException(String.format("No se encontró un usuario con id %d", userId));

        List<Post> posts = postRepositoryImp.findAll();
        Long promoPostsCount = posts.stream()
                .filter(p -> p.getUserId().equals(userId) && p.getHasPromo())
                .count();

        return new PromoPostCountDto(
                userId,
                vendor.getUserName(),
                promoPostsCount);
    }

    private void verifyUserExists(Integer userId) {
        List<Vendor> vendors = vendorRepositoryImp.findAll();
        vendors.stream()
                .filter(v -> v.getUserId().equals(userId))
                .findFirst()
                .orElseThrow(() -> new NotFoundException("No se encontró ningun usuario en el sistema con el ID indicado."));
    }
}
