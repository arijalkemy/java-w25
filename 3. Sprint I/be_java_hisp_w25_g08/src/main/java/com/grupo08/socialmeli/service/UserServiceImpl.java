package com.grupo08.socialmeli.service;

import com.grupo08.socialmeli.dto.response.*;
import com.grupo08.socialmeli.dto.PostDto;
import com.grupo08.socialmeli.entity.Buyer;
import com.grupo08.socialmeli.entity.Post;
import com.grupo08.socialmeli.entity.Seller;
import com.grupo08.socialmeli.entity.User;
import com.grupo08.socialmeli.exception.BadRequestException;
import com.grupo08.socialmeli.exception.NotFoundException;
import com.grupo08.socialmeli.repository.IBuyerRepository;
import com.grupo08.socialmeli.repository.IPostRepository;
import com.grupo08.socialmeli.repository.ISellerRepository;
import com.grupo08.socialmeli.utils.PostMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements IUserService {

    IBuyerRepository buyerRepository;
    ISellerRepository sellerRepository;
    IPostRepository postRepository;

    public UserServiceImpl(IBuyerRepository buyerRepository, ISellerRepository sellerRepository, IPostRepository iPostRepository) {
        this.buyerRepository = buyerRepository;
        this.sellerRepository = sellerRepository;
        this.postRepository= iPostRepository;
    }

    @Override
    public FollowDto follow(int idBuyer, int idSeller) {

        Optional<Buyer> buyer = buyerRepository.findById(idBuyer);

        Optional<Seller> seller = sellerRepository.findById(idSeller);

        if(buyer.isEmpty()) throw new NotFoundException("No se encuentra comprador con ese ID.");

        if(seller.isEmpty()) throw new NotFoundException("No hay vendedor con ese ID.");

        Optional<Seller> sellerToRemove = buyer.get().getFollowing().stream()
                .filter(s -> s.getId() == idSeller)
                .findFirst();

        if (sellerToRemove.isPresent()) {
            throw new BadRequestException("No puedes seguir un vendedor que ya sigues.");
        }
        
        buyer.get().addFollowingSeller(seller.get());
        seller.get().addFollower(buyer.get());

        return new FollowDto(idSeller, seller.get().getName());
    }

    public FollowersDto getFollowers(int idSeller,String order) {
        Optional<Seller> seller = sellerRepository.findById(idSeller);

        if(seller.isEmpty()) throw new NotFoundException("No hay vendedor con ese ID.");

        List<User> followers = seller.get().getFollowers();

        if(!Objects.equals(order, "default")){
            switch (order){
                case "name_asc":
                    followers = followers.stream()
                            .sorted(Comparator.comparing(User::getName))
                            .collect(Collectors.toList());;
                    break;
                case  "name_desc":
                    followers = followers.stream()
                            .sorted(Comparator.comparing(User::getName).reversed())
                            .collect(Collectors.toList());;
                    break;
                default:
                    throw new BadRequestException("Parametro de orden no valido");

            }
        }



        FollowersDto followersDto = new FollowersDto(
                seller.get().getId(),
                seller.get().getName(),
                followers.stream().map(this::convertFollowerDto).collect(Collectors.toList())
        );
        return followersDto;
    }

    private FollowDto convertFollowerDto(User user){
        return new FollowDto(user.getId(), user.getName());
    }

    @Override
    public void unfollow(int idBuyer, int idSeller) {

        Optional<Buyer> buyer = buyerRepository.findById(idBuyer);

        Optional<Seller> seller = sellerRepository.findById(idSeller);

        if(buyer.isEmpty()) throw new NotFoundException("No se encuentra comprador con ese ID.");

        if(seller.isEmpty()) throw new NotFoundException("No hay vendedor con ese ID.");

        buyer.get().unFollowSeller(seller.get());
        seller.get().removeFollower(buyer.get());

    }

    @Override
    public FollowedDTO getFollowedSellers(int userId, String order) {
        Optional<Buyer> user = this.buyerRepository.findById(userId);
        if(user.isEmpty()){
            throw new NotFoundException("El usuario con el id:"+userId+" no se encontró");
        }

        if(!(user.get() instanceof Buyer)){
            throw new BadRequestException("El usuario con el id:"+userId+" no es un comprador");
        }
        Buyer buyer = user.get();


        FollowedDTO buyerResponseDTO = new FollowedDTO();
        buyerResponseDTO.setUser_id(buyer.getId());
        buyerResponseDTO.setUser_name(buyer.getName());

        List<Seller> followedSellers = new ArrayList<>();

        if(order!=null){
            if(order.equalsIgnoreCase("name_asc")){
                followedSellers = buyer.getFollowing().stream()
                        .sorted(Comparator.comparing(User::getName)).toList();
            }else if(order.equalsIgnoreCase("name_desc")){
                followedSellers = buyer.getFollowing().stream()
                        .sorted(Comparator.comparing(User::getName).reversed()).toList();
            }else{
                throw new BadRequestException("El valor del parámetro order no es correcto");
            }
        }else{
            followedSellers = buyer.getFollowing();

        }


        List<FollowDto> followedSellersDTO = new ArrayList<>();

        for(Seller seller: followedSellers){
            followedSellersDTO.add(new FollowDto(seller.getId(),seller.getName()));
        }

        buyerResponseDTO.setFollowed(followedSellersDTO);

        return buyerResponseDTO;
    }

    @Override
    public FollowedDTO getFollowedSellers(int userId) {
        return null;
    }

    @Override
    public FollowersCountDto countSellerFollowers(int userId) {
        //vars
        Optional<Seller> seller = sellerRepository.findById(userId);

        //validate: el usuario obtenido existe y es vendedor
        if(seller.isEmpty()) throw new NotFoundException("El usuario no existe");
        //validacion comentada dado repeticion de id entre compradores y vendedores
        //if(buyerRepository.findById(userId).isPresent()) throw new BadRequestException("El id ingresado debe ser de un vendedor: se obtuvo comprador");

        //return
        return new FollowersCountDto(userId, seller.get().getName(), seller.get().getFollowers().size());
    }

    @Override
    public FollowingPostDto postSortDate(Long idUser, String order) {
        if(order.equalsIgnoreCase("date_desc")) {
            return new FollowingPostDto(idUser,postSortWeeks(idUser).getPost().stream().sorted(Comparator.comparing(PostDto::getDate).reversed())
                    .collect(Collectors.toList()));
        }else if(order.equalsIgnoreCase("date_asc")){
            return new FollowingPostDto(idUser,postSortWeeks(idUser).getPost().stream().sorted(Comparator.comparing(PostDto::getDate))
                    .collect(Collectors.toList()));
        }else{
            throw new BadRequestException("El valor del parámetro order no es correcto");
        }
    }

    @Override
    public FollowingPostDto postSortWeeks(Long idUser) {
        FollowedDTO vendedoresSeguidos= getFollowedSellers((int) idUser.longValue(),null);
        List<Integer> listaDeIdsDeVendedores=vendedoresSeguidos.getFollowed().stream().map(FollowDto::getUser_id).toList();
        System.out.println(listaDeIdsDeVendedores);
        List<Post> listaDePost= new ArrayList<>();
        for(Integer id:listaDeIdsDeVendedores  ){
            listaDePost.addAll(postRepository.getByIdUser((long)id));
        }
        LocalDate now= LocalDate.now();
        LocalDate afterweeks=LocalDate.now().minusWeeks(2);

        List<Post>listaFiltrada=listaDePost.stream().filter(x->x.getDate().isBefore(now.plusDays(1))&&x.getDate().isAfter(afterweeks.minusDays(1))).toList();

        return new FollowingPostDto(idUser,PostMapper.ListToDto(listaFiltrada));
    }
}
