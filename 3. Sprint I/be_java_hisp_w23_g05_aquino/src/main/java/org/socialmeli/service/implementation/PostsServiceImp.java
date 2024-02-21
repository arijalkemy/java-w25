package org.socialmeli.service.implementation;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.socialmeli.dto.request.FollowedListReqDto;
import org.socialmeli.dto.request.PostReqDto;
import org.socialmeli.dto.request.PromoPostReqDto;
import org.socialmeli.dto.request.UserIdDto;
import org.socialmeli.dto.response.*;
import org.socialmeli.entity.Client;
import org.socialmeli.entity.Post;
import org.socialmeli.entity.Product;
import org.socialmeli.entity.Vendor;
import org.socialmeli.exception.BadRequestException;
import org.socialmeli.exception.NotFoundException;
import org.socialmeli.repository.implementation.ClientRepositoryImp;
import org.socialmeli.repository.implementation.PostRepositoryImp;
import org.socialmeli.repository.implementation.VendorRepositoryImp;
import org.socialmeli.service.IPostsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;

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
                List<Post> filteredPosts = postRepositoryImp.findAll().stream()
                        .filter(p -> p.getUserId().equals(v.getUserId())
                                  && p.getDate().isAfter(LocalDate.now().minusWeeks(2)))
                        .toList();
                filteredPosts.forEach(p -> postDtoList.add(new PostDto(p.getPostId(),
                            p.getUserId(),
                            p.getDate(),
                            mapper.convertValue(p.getProduct(), ProductDto.class),
                            p.getCategory(),
                            p.getPrice(),
                            p.getHasPromo(),
                            p.getDiscount())
                ));
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
    public PostIdDto savePost(PostReqDto postReqDto) {
        Vendor vendor = new Vendor();
        for (Vendor c : this.vendorRepositoryImp.findAll()) {
            if (c.getUserId().equals(postReqDto.getUserId())) {
                vendor = c;
            }
        }
        if (vendor.getUserId() == null) {
            throw new NotFoundException("No se encontró ningun usuario en el sistema con el ID indicado.");
        }
        Post post = new Post(
                postReqDto.getUserId(),
                postReqDto.getDate(),
                postReqDto.getProduct(),
                postReqDto.getCategory(),
                postReqDto.getPrice());
        Integer response =  postRepositoryImp.save(post);
        return new PostIdDto(response);
    }

    @Override
    public PostIdDto savePromoPost(PromoPostReqDto postDto) {
        Integer vendorId = postDto.getUserId();
        Optional<Vendor> vendor = vendorRepositoryImp.findAll().stream()
                .filter(v -> v.getUserId().equals(vendorId))
                .findFirst();

        if (vendor.isEmpty())
            throw new BadRequestException("No se encontró ningun usuario en el sistema con el ID indicado.");

        Product product = mapper.convertValue(postDto.getProduct(), Product.class);
        Post post = new Post(
                postDto.getUserId(),
                postDto.getDate(),
                product,
                postDto.getCategory(),
                postDto.getPrice(),
                postDto.getHasPromo(),
                postDto.getDiscount()
        );

        return new PostIdDto(postRepositoryImp.save(post));
    }

    @Override
    public PromoProductsCount countPromoProductsFromVendor(UserIdDto userIdDto) {
        Integer userId = userIdDto.getUserId();

        Optional<Vendor> vendor = vendorRepositoryImp.findAll().stream().filter(v -> v.getUserId().equals(userId)).findFirst();
        if (vendor.isEmpty())
            throw new NotFoundException("No se encontró el vendedor con user_id " + userId);

        Integer totalPromoProducts = (int) postRepositoryImp.findAll().stream()
                .filter(post -> post.getUserId().equals(userId)
                        && post.getHasPromo())
                .count();

        return new PromoProductsCount(userId, vendor.get().getUserName(), totalPromoProducts);
    }


}
