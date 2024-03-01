package org.socialmeli.service.implementation;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.socialmeli.dto.request.FollowedListReqDto;
import org.socialmeli.dto.request.PostReqDto;
import org.socialmeli.dto.response.FollowedListDto;
import org.socialmeli.dto.response.PostDto;
import org.socialmeli.dto.response.PostIdDto;
import org.socialmeli.dto.response.ProductDto;
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
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Service
public class PostsServiceImp implements IPostsService {
    PostRepositoryImp postRepositoryImp;
    VendorRepositoryImp vendorRepositoryImp;
    ClientRepositoryImp clientRepositoryImp;

    ObjectMapper mapper = new ObjectMapper();

    public PostsServiceImp(PostRepositoryImp postRepo, VendorRepositoryImp vendorRepo, ClientRepositoryImp clientRepo) {
        this.postRepositoryImp = postRepo;
        this.vendorRepositoryImp = vendorRepo;
        this.clientRepositoryImp = clientRepo;
    }

    @Override
    public FollowedListDto getFollowedList(FollowedListReqDto req) {
        Integer id = req.getUserId();
        String order = req.getOrder();
        // Busca cliente por ID:
        Client client = clientRepositoryImp.findOne(id);
        Vendor vendor = vendorRepositoryImp.findOne(id);
        List<Vendor> vendorList;

        if (client == null && vendor == null) {
            throw new NotFoundException("No se encontró ningun usuario en el sistema con el ID indicado.");
        }

        // Busca vendedores seguidos cliente:
        if (client != null) {
            vendorList = this.postRepositoryImp.getFollowedList(client, this.vendorRepositoryImp.findAll());
        } else {
            vendorList = this.postRepositoryImp.getFollowedList(vendor, this.vendorRepositoryImp.findAll());
        }
        List<PostDto> postDtoList = new ArrayList<>();
        if (vendorList.isEmpty()) {
            throw new NotFoundException("El usuario ingresado no sigue a ningun vendedor.");
        } else {
            // Busca posteos de vendedores que cumplan con los requisitos:
            for (Vendor v : vendorList) {
                for (Post p : postRepositoryImp.getPostsByUserId(v.getUserId())) {
                    if (p.getDate().isAfter(LocalDate.now().minusWeeks(2))) {
                        postDtoList.add(new PostDto(p.getPostId(), p.getUserId(), p.getDate(), new ProductDto(p.getProduct().getProductId(), p.getProduct().getProductName(), p.getProduct().getType(), p.getProduct().getBrand(), p.getProduct().getColor(), p.getProduct().getNotes()),
                                p.getCategory(), p.getPrice()));
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
        } else if (order.equals("date_desc")) {
            Collections.sort(postDtoList, Comparator.comparing(PostDto::getDate, Comparator.reverseOrder()));
        } else {
            throw new BadRequestException("Indicación de ordenamiento no válida. La misma tiene que ser \"date_asc\" o \"date_desc\"");
        }
        return new FollowedListDto(id, postDtoList);
    }

    @Override
    public PostIdDto savePost(PostReqDto postReqDto) {
        Vendor vendor = vendorRepositoryImp.findOne(postReqDto.getUserId());

        if (vendor.getUserId() == null) {
            throw new NotFoundException("No se encontró ningun usuario en el sistema con el ID indicado.");
        }

        Post post = new Post(
                postReqDto.getUserId(),
                postReqDto.getDate(),
                mapper.convertValue(postReqDto.getProduct(), Product.class),
                postReqDto.getCategory(),
                postReqDto.getPrice());
        Integer response = postRepositoryImp.save(post);
        return new PostIdDto(response);
    }
}
