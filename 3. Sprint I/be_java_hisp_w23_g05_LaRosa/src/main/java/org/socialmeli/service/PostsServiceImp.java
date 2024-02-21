package org.socialmeli.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.socialmeli.dto.request.FollowedListReqDto;
import org.socialmeli.dto.request.PostDiscountReqDto;
import org.socialmeli.dto.request.PostReqDto;
import org.socialmeli.dto.request.UserIdDto;
import org.socialmeli.dto.response.DiscountCountDto;
import org.socialmeli.dto.response.FollowedListDto;
import org.socialmeli.dto.response.PostDiscountResDto;
import org.socialmeli.dto.response.PostDto;
import org.socialmeli.dto.response.PostIdDto;
import org.socialmeli.dto.response.ProductDto;
import org.socialmeli.dto.response.PromoListResDto;
import org.socialmeli.entity.Client;
import org.socialmeli.entity.Post;
import org.socialmeli.entity.PostDiscount;
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
        if (client.getUserId() != null) {
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
                for (Post p : postRepositoryImp.findAll()) {
                    if (p.getUserId().intValue() == v.getUserId().intValue()) {
                        if (p.getDate().isAfter(LocalDate.now().minusWeeks(2))) {
                            postDtoList.add(new PostDto(p.getPostId(), p.getUserId(), p.getDate(),
                                    new ProductDto(p.getProduct().getProductId(), p.getProduct().getProductName(),
                                            p.getProduct().getType(), p.getProduct().getBrand(),
                                            p.getProduct().getColor(), p.getProduct().getNotes()),
                                    p.getCategory(), p.getPrice()));
                        }
                    }
                }
            }
        }
        if (postDtoList.isEmpty()) {
            throw new NotFoundException(
                    "No hay posteos realizados por los vendedores que sigue el usuario las últimas dos semanas.");
        }

        // Ordena el ArrayList de posteos:
        if (order.equals("date_asc")) {
            Collections.sort(postDtoList, Comparator.comparing(PostDto::getDate));
        } else if (order.equals("date_desc")) {
            Collections.sort(postDtoList, Comparator.comparing(PostDto::getDate, Comparator.reverseOrder()));
        } else {
            throw new BadRequestException(
                    "Indicación de ordenamiento no válida. La misma tiene que ser \"date_asc\" o \"date_desc\"");
        }
        return new FollowedListDto(id, postDtoList);
    }

    // US_0005
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
        Post post = new Post(postReqDto.getUserId(), postReqDto.getDate(), postReqDto.getProduct(),
                postReqDto.getCategory(), postReqDto.getPrice());
        Integer response = postRepositoryImp.save(post);
        return new PostIdDto(response);
    }

    // US_0010
    @Override
    public PostIdDto savePostDiscount(PostDiscountReqDto postDiscountReqDto) {
        Vendor vendor = new Vendor();
        for (Vendor c : this.vendorRepositoryImp.findAll()) {
            if (c.getUserId().equals(postDiscountReqDto.getUserId())) {
                vendor = c;
            }
        }
        if (vendor.getUserId() == null) {
            throw new NotFoundException("No se encontró ningun vendedor en el sistema con el ID indicado.");
        }
        PostDiscount postDiscount = new PostDiscount(postDiscountReqDto.getUserId(), postDiscountReqDto.getDate(),
                postDiscountReqDto.getProduct(), postDiscountReqDto.getCategory(), postDiscountReqDto.getPrice(),
                postDiscountReqDto.getHasPromo(), postDiscountReqDto.getDiscount());
        Integer response = postRepositoryImp.savePostDiscount(postDiscount);
        return new PostIdDto(response);
    }

    // US_0011
    @Override
    public DiscountCountDto vendorProductsDiscountCount(UserIdDto userId) {
        Vendor vendor = new Vendor();
        Integer total = 0;
        for (Vendor c : this.vendorRepositoryImp.findAll()) {
            if (c.getUserId().equals(userId.getUserId())) {
                vendor = c;
            }
        }
        if (vendor.getUserId() == null) {
            throw new NotFoundException("No se encontró ningun vendedor en el sistema con el ID indicado.");
        }
        for (Post p : postRepositoryImp.findAll()) {
            if (p.getUserId().equals(userId.getUserId())) {
                if (p instanceof PostDiscount) {
                    PostDiscount postDiscount = (PostDiscount) p;
                    if (postDiscount.getHasPromo() == true) {
                        total++;
                    }
                }
            }
        }
        return new DiscountCountDto(total);
    }

    // US_0012
    @Override
    public PromoListResDto vendorProductsDiscountList(UserIdDto userId) {
        Vendor vendor = new Vendor();
        List<PostDiscountResDto> promoList = new ArrayList<>();
        for (Vendor c : this.vendorRepositoryImp.findAll()) {
            if (c.getUserId().equals(userId.getUserId())) {
                vendor = c;
            }
        }
        if (vendor.getUserId() == null) {
            throw new NotFoundException("No se encontró ningun vendedor en el sistema con el ID indicado.");
        }

        for (Post p : postRepositoryImp.findAll()) {
            if (p.getUserId().equals(userId.getUserId())) {
                if (p instanceof PostDiscount) {
                    PostDiscount postDiscount = (PostDiscount) p;
                    if (postDiscount.getHasPromo() == true) {
                        promoList.add(new PostDiscountResDto(postDiscount));
                    }
                }
            }
        }

        if (promoList.isEmpty()) {
            throw new NotFoundException("El vendedor indicado no tiene productos en promoción.");

        }

        return new PromoListResDto(vendor.getUserId(), vendor.getUserName(), promoList);
    }
}
