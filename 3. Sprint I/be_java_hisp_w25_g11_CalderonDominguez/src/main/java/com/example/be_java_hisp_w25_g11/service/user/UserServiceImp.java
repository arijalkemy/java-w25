package com.example.be_java_hisp_w25_g11.service.user;

import com.example.be_java_hisp_w25_g11.dto.UserDTO;
import com.example.be_java_hisp_w25_g11.dto.commons.enums.EnumNameOrganizer;
import com.example.be_java_hisp_w25_g11.dto.response.*;
import com.example.be_java_hisp_w25_g11.entity.Buyer;
import com.example.be_java_hisp_w25_g11.entity.Seller;
import com.example.be_java_hisp_w25_g11.exception.BadRequestException;
import com.example.be_java_hisp_w25_g11.exception.NotFoundException;
import org.modelmapper.ModelMapper;
import com.example.be_java_hisp_w25_g11.repository.buyer.IBuyerRepository;
import com.example.be_java_hisp_w25_g11.repository.seller.ISellerRepository;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class UserServiceImp implements IUserService {
    private final IBuyerRepository buyerRepository;
    private final ISellerRepository sellerRepository;
    private final ModelMapper modelMapper;

    public UserServiceImp(
        IBuyerRepository buyerRepository,
        ISellerRepository sellerRepository,
        ModelMapper modelMapper
    ) {
        this.buyerRepository = buyerRepository;
        this.sellerRepository = sellerRepository;
        this.modelMapper = modelMapper;
    }



    @Override
    public SuccessDTO follow(Integer userId, Integer userIdToFollow) {
        Object user = getUser(userId);
        Object userToFollow = getUser(userIdToFollow);

        if (!(userToFollow instanceof Seller)) {
            throw new BadRequestException("El usuario a seguir debe ser un vendedor.");
        }

        if (userId.equals(userIdToFollow)) {
            throw new BadRequestException("El usuario no se puede seguir a si mismo.");
        }

        if (user instanceof Buyer) {
            if (((Buyer) user).getFollowed().contains(userIdToFollow)) {
                throw new BadRequestException("El comprador con id="+userId+" ya sigue al vendedor con id="+userIdToFollow+".");
            }
            ((Buyer) user).getFollowed().add(userIdToFollow);
            ((Seller) userToFollow).getFollowers().add(userId);
        } else if (user instanceof Seller) {
            if (((Seller) user).getFollowed().contains(userIdToFollow)) {
                throw new BadRequestException("El vendedor con id="+userId+" ya sigue al vendedor con id="+userIdToFollow+".");
            }
            ((Seller) user).getFollowed().add(userIdToFollow);
            ((Seller) userToFollow).getFollowers().add(userId);
        } else {
            throw new BadRequestException("El usuario con id="+userId+" no es ni comprador ni vendedor.");
        }
        return new SuccessDTO("El usuario con id="+userId+" ahora sigue al vendedor con id="+userIdToFollow+".");
    }

    @Override
    public FollowerCountDTO followersSellersCount(Integer sellerId) {
        Optional<Seller> seller = sellerRepository.get(sellerId);
        if(seller.isEmpty()){
            if(buyerRepository.get(sellerId).isPresent()){
                throw new BadRequestException("Un comprador no puede tener seguidores.");
            }
            throw new NotFoundException("El vendedor con id="+sellerId+" no existe.");
        }
        int followersCount = seller.get().getFollowers().size();
        return new FollowerCountDTO (sellerId, seller.get().getName(), followersCount);
    }

    @Override
    public FollowerDTO userFollowSellers(Integer sellerId) {
        Optional<Seller> seller = sellerRepository.get(sellerId);
        if(seller.isEmpty()){
            if(buyerRepository.get(sellerId).isPresent()){
                throw new BadRequestException("Un comprador no puede tener seguidores.");
            }
            throw new NotFoundException("El vendedor con id="+sellerId+" no existe.");
        }

        List<UserDTO> followers = seller.get().getFollowers()
                .stream()
                .map(followerId ->{
                    if (buyerRepository.existing(followerId)
                    ) {
                        return buyerRepository.get(followerId);
                    }
                    else{
                        return sellerRepository.get(followerId);
                    }
                })
                .map(u -> modelMapper.map(u.get(), UserDTO.class))
                .toList();
        return new FollowerDTO(sellerId,seller.get().getName(),followers);
    }

    @Override
    public SuccessDTO unfollow(Integer userId, Integer sellerIdToUnfollow) {
        Object user = getUser(userId);
        Object userToUnfollow = getUser(sellerIdToUnfollow);

        if (!(userToUnfollow instanceof Seller)) {
            throw new BadRequestException("El usuario a dejar de seguir debe ser un vendedor.");
        }

        if (user instanceof Buyer) {
            if (!((Buyer) user).getFollowed().contains(sellerIdToUnfollow)) {
                throw new BadRequestException("El comprador con id="+userId+" no sigue al vendedor con id="+sellerIdToUnfollow+".");
            }
            ((Buyer) user).getFollowed().remove(sellerIdToUnfollow);
            ((Seller) userToUnfollow).getFollowers().remove(userId);
        } else if (user instanceof Seller) {
            if (!((Seller) user).getFollowed().contains(sellerIdToUnfollow)) {
                throw new BadRequestException("El vendedor con id="+userId+" no sigue al vendedor con id="+sellerIdToUnfollow+".");
            }
            ((Seller) user).getFollowed().remove(sellerIdToUnfollow);
            ((Seller) userToUnfollow).getFollowers().remove(userId);
        } else {
            throw new BadRequestException("El usuario con id="+userId+" no es ni comprador ni vendedor.");
        }
        return new SuccessDTO("El usuario con id="+userId+" ha dejado de seguir al vendedor con id="+sellerIdToUnfollow+".");
    }



    private List<UserDTO> getSocialListHelper(Set<Integer> output) {
        return output
                .stream()
                .map(v -> {
                    Optional<Buyer> buyer = buyerRepository.get(v);
                    Optional<Seller> seller = sellerRepository.get(v);
                    if (buyer.isPresent())
                        return modelMapper.map(buyer.get(), UserDTO.class);
                    else if (seller.isPresent())
                        return modelMapper.map(seller.get(), UserDTO.class);
                    else
                        throw new NotFoundException("No se encontró uno de los IDs");
                })
                .toList();
    }



    @Override
    public FollowerDTO sortFollowers(Integer userId, String order) {
        Optional<Seller> seller = sellerRepository.get(userId);
        Optional<Buyer> buyer = buyerRepository.get(userId);
        String name;
        if (buyer.isPresent())
            throw new NotFoundException("Los compradores no pueden tener seguidores");
        else if (seller.isPresent())
            name = seller.get().getName();
        else
            throw new NotFoundException("No se encontró un vendedor con ese ID");

        List<UserDTO> users = this.getSocialUsersList(userId, "followers");

        if (order == null) {
            return new FollowerDTO(
                    userId,
                    name,
                    users
            );
        }

        Comparator<UserDTO> comparator = switch (order.toLowerCase()) {
            case "name_asc" -> Comparator.comparing(UserDTO::getName);
            case "name_desc" -> Comparator.comparing(UserDTO::getName).reversed();
            default -> throw new BadRequestException("Argumento invalido (order debe ser NAME_ASC o NAME_DESC)");
        };

        return new FollowerDTO(
                userId,
                name,
                users
                        .stream()
                        .sorted(comparator)
                        .toList()
        );
    }

    @Override
    public FollowedDTO sortFollowed(Integer userId, String order) {
        Optional<Buyer> buyer = buyerRepository.get(userId);
        Optional<Seller> seller = sellerRepository.get(userId);
        String name;
        if (buyer.isPresent())
            name = buyer.get().getName();
        else if (seller.isPresent())
            name = seller.get().getName();
        else
            throw new NotFoundException("No se encontró un usuario con ese ID");

        List<UserDTO> users = this.getSocialUsersList(userId, "followed");

        if (order == null) {
            return new FollowedDTO(
                    userId,
                    name,
                    users
            );
        }

        Comparator<UserDTO> comparator = switch (order.toLowerCase()) {
            case "name_asc" -> Comparator.comparing(UserDTO::getName);
            case "name_desc" -> Comparator.comparing(UserDTO::getName).reversed();
            default -> throw new BadRequestException("Argumento invalido (order debe ser NAME_ASC o NAME_DESC)");
        };

        return new FollowedDTO(
                userId,
                name,
                users
                        .stream()
                        .sorted(comparator)
                        .toList()
        );
    }

    private List<UserDTO> getSortedUsers(Set<Integer> usersId, EnumNameOrganizer organizer){
        return usersId.stream()
                .filter(this::isThisIdInSellerOrBuyerRepositories)
                .map(this::mapBuyersAndSeyersToUserDTO)
                .sorted(Comparator.comparing(UserDTO::getName,organizer.getComparator())).toList();
    }

    private UserDTO mapBuyersAndSeyersToUserDTO(Integer sellerId){
        if(this.sellerRepository.get(sellerId).isPresent()){
            Seller lambdaSeller = this.sellerRepository.get(sellerId).get();
            return new UserDTO(lambdaSeller.getId(),lambdaSeller.getName());
        }
        Buyer lambdaBuyer = this.buyerRepository.get(sellerId).get();
        return new UserDTO(lambdaBuyer.getId(),lambdaBuyer.getName());
    }


    private boolean isThisIdInSellerOrBuyerRepositories(Integer userId){
        return  this.buyerRepository.get(userId).isPresent() || this.sellerRepository.get(userId).isPresent();
    }

    @Override
    public boolean isSeller(Integer userId) {
        return false;
    }
    private Object getUser(Integer id) {
        if (buyerRepository.existing(id)) {
            return buyerRepository.get(id).get();
        } else if (sellerRepository.existing(id)) {
            return sellerRepository.get(id).get();
        } else {
            throw new NotFoundException("El usuario con id="+id+" no existe.");
        }
    }


    private List<UserDTO> getSocialUsersList(Integer userId, String type) {
        Optional<Buyer> buyerOptional = buyerRepository.get(userId);
        Optional<Seller> sellerOptional = sellerRepository.get(userId);
        if (buyerOptional.isPresent()) {
            return getSocialListHelper(buyerOptional.get().getFollowed());
        } else if (sellerOptional.isPresent()) {
            return type.equalsIgnoreCase("followers")
                    ? getSocialListHelper(sellerOptional.get().getFollowers())
                    : getSocialListHelper(sellerOptional.get().getFollowed());
        } else {
            throw new NotFoundException("No se encontró un usuario con ese ID");
        }
    }
}
