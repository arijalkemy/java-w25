package com.breakingbytes.be_java_hisp_w25_g04.service;

import com.breakingbytes.be_java_hisp_w25_g04.dto.request.RequestPostDTO;
import com.breakingbytes.be_java_hisp_w25_g04.dto.response.FollowersCountDTO;
import com.breakingbytes.be_java_hisp_w25_g04.dto.response.LastPostsDTO;
import com.breakingbytes.be_java_hisp_w25_g04.dto.response.ResponsePostDTO;
import com.breakingbytes.be_java_hisp_w25_g04.entity.Post;
import com.breakingbytes.be_java_hisp_w25_g04.entity.Product;
import com.breakingbytes.be_java_hisp_w25_g04.entity.Seller;
import com.breakingbytes.be_java_hisp_w25_g04.entity.User;
import com.breakingbytes.be_java_hisp_w25_g04.exception.BadRequestException;
import com.breakingbytes.be_java_hisp_w25_g04.exception.NotFoundException;
import com.breakingbytes.be_java_hisp_w25_g04.repository.IPostRepository;
import com.breakingbytes.be_java_hisp_w25_g04.repository.IProductRepository;
import com.breakingbytes.be_java_hisp_w25_g04.repository.ISellerRepository;

import com.breakingbytes.be_java_hisp_w25_g04.repository.IUserRepository;
import com.breakingbytes.be_java_hisp_w25_g04.utils.Mapper;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.NamingConventions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;

@Service
public class SellerServiceImpl implements ISellerService{
    ISellerRepository sellerRepository;
    ModelMapper mapper = new ModelMapper();
    IPostRepository postRepository;
    IProductRepository productRepository;
    IUserRepository userRepository;

    public SellerServiceImpl(ISellerRepository sellerRepository, IPostRepository postRepository, IProductRepository productRepository, IUserRepository iUserRepository) {
        this.sellerRepository = sellerRepository;
        this.postRepository = postRepository;
        this.productRepository = productRepository;
        this.userRepository = iUserRepository;

        //Configuracion del mapper
        this.mapper.getConfiguration()
                .setFieldMatchingEnabled(true)
                .setFieldAccessLevel(org.modelmapper.config.Configuration.AccessLevel.PRIVATE)
                .setSourceNamingConvention(NamingConventions.JAVABEANS_MUTATOR);
    }

    @Override
    public void addPost(RequestPostDTO requestPostDTO) {
        Post post = mapper.map(requestPostDTO, Post.class);
        Optional<Seller> seller = sellerRepository.findById(requestPostDTO.getUserId());
        if (seller.isEmpty()) throw new NotFoundException("No se ha encontrado un vendedor con ese ID");
        Optional<Product> product = productRepository.findAll().stream()
                .filter(p -> Objects.equals(p.getId(), requestPostDTO.getProduct().getId()))
                .findFirst();
        if (product.isPresent()) throw new BadRequestException("Ya existe un producto con ese ID");
        sellerRepository.addPost(post, seller.get());
    }

    @Override
    public List<RequestPostDTO> findAllPosts() {
        return postRepository.findAll()
                .stream().map(p -> mapper.map(p, RequestPostDTO.class)).toList();
    }

    public Boolean quitFollower(Integer sellerIdInt, Integer userIdInt) {

        Optional<Seller> sellerOpt = sellerRepository.findById(sellerIdInt);
        if(sellerOpt.isEmpty()) {
            throw new NotFoundException("No se ha encontrado vendedor con id: " + sellerIdInt);
        }

        Seller seller = sellerOpt.get();
        List<User> sellerFollowers = seller.getFollowers();
        Optional<User> userUnfollowedOpt = sellerFollowers
                                                .stream()
                                                .filter(u -> Objects.equals(u.getId(), userIdInt))
                                                .findFirst();
        if(userUnfollowedOpt.isEmpty()) {
            throw new NotFoundException("El usuario no se encuentra entre los seguidores.");
        }

        User user = userUnfollowedOpt.get();
        sellerFollowers.remove(user);
        sellerRepository.setSellerFollowers(sellerIdInt, sellerFollowers);

        return true;
    }
    @Override
    public LastPostsDTO getPostOfVendorsFollowedByUser(Integer id, String order) {
        Optional<User> opt = this.userRepository.findById(id);
        if (opt.isEmpty()) throw new NotFoundException("No se encuentra el id buscado");
        User user = opt.get();
        List<ResponsePostDTO> posts = new ArrayList<>();
        for (Seller s : user.getFollowing()) {
            for (Post p : s.getPosts()) {
                if (!p.getDate().isBefore(LocalDate.now().minusWeeks(2))) {
                    ResponsePostDTO responsePostDTO = mapper.map(p, ResponsePostDTO.class);
                    responsePostDTO.setUserId(s.getId());
                    posts.add(responsePostDTO);
                }
            }
        }
        if (posts.isEmpty()) throw new NotFoundException("No hay publicaciones que cumplan con el requisito");
        ordenarPostsPorFecha(posts, order); // ordena la lista q se manda
        return new LastPostsDTO(user.getId(), posts);
    }

    /**
     *
     * @param posts = "Lista de posts DTO"
     * @param order = "Ordenamiento de posts", pueden ser de tipo date_asc, "date_desc" y ""
     */
    private void ordenarPostsPorFecha (List<ResponsePostDTO> posts, String order) {
        switch (order) {
            case "date_asc" -> posts.sort(Comparator.comparing(ResponsePostDTO::getDate));
            case "date_desc" -> posts.sort(Comparator.comparing(ResponsePostDTO::getDate).reversed());
            default -> {
                if (!order.isEmpty()) throw new BadRequestException("El tipo de ordenamiento por fecha es incorrecto");
            }
        }
    }

    @Override
    public FollowersCountDTO getCountFollowersOfSeller(Integer id){
        Optional<Seller> seller = sellerRepository.findById(id);
        if(seller.isEmpty()) throw new NotFoundException("ID de usuario invalido");
        return new FollowersCountDTO(seller.get().getId(), seller.get().getName(), seller.get().getFollowers().size());
    }
}
