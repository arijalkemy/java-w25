package com.example.bootcampsprint1g6.service.implementation;

import com.example.bootcampsprint1g6.dto.FollowedDTO;
import com.example.bootcampsprint1g6.dto.FollowersDTO;
import com.example.bootcampsprint1g6.dto.FollowersCountDTO;
import com.example.bootcampsprint1g6.dto.GenericResponseDTO;
import com.example.bootcampsprint1g6.dto.UserDTO;
import com.example.bootcampsprint1g6.entity.Seller;
import com.example.bootcampsprint1g6.entity.User;
import com.example.bootcampsprint1g6.exception.BadRequestException;
import com.example.bootcampsprint1g6.exception.NotFoundException;
import com.example.bootcampsprint1g6.repository.IUserRepository;
import com.example.bootcampsprint1g6.repository.implementation.UserRepositoryImpl;
import com.example.bootcampsprint1g6.service.IUserService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class UserServiceImpl implements IUserService {

    private IUserRepository userRepository;

    public UserServiceImpl(UserRepositoryImpl userRepository){
        this.userRepository = userRepository;
    }

    private final String NAME_ASC = "name_asc";
    private final String NAME_DESC = "name_desc";

    /**
     * Used to follow a seller
     * @param userId Unique user identifier.
     * @param userIdToFollow Unique seller user identifier.
     * @return GenericResponseDTO
     */
    @Override
    public GenericResponseDTO follow(Integer userId, Integer userIdToFollow){
        if (userId.equals(userIdToFollow)) {
            throw new BadRequestException("El usuario no se puede seguir así mismo ID: " + userIdToFollow);
        }

        User seller = this.getUserById(userIdToFollow);

        if (!seller.getClass().equals(Seller.class))
            throw new BadRequestException("El usuario no se puede seguir porque no es un vendedor ID: " + userIdToFollow);

        User user =  this.getUserById(userId);

        this.validateFollow(user, seller);
        user.follow((Seller) seller);

        return new GenericResponseDTO(HttpStatus.OK.value(), "Ok");
    }

    /**
     * Get a followers list
     * @param userId Unique user identifier.
     * @param order type allowed: name_asc | name_desc
     * @return FollowersDTO
     */
    @Override
    public FollowersDTO getFollowersList(Integer userId, String order) {
        if (order != null && !order.equals(NAME_ASC) && !order.equals(NAME_DESC))
            throw new IllegalArgumentException("La variable 'order' enviada es inválida (" + order + ").");

        User user = getUserById(userId);
        if (user.getClass() != Seller.class) {
            throw new BadRequestException("El ID ingresado no corresponde a un vendedor, por favor verificarlo.");
        }
        List<User> followersList = userRepository.getFollowersList(userId);

        if (order != null) {
            switch (order) {
                case NAME_ASC:
                    followersList.sort(Comparator.comparing(User::getUserName));
                    break;
                case NAME_DESC:
                    followersList.sort(Comparator.comparing(User::getUserName).reversed());
                    break;
            }
        }

        List<UserDTO> followerDTOList = followersList.stream().map(u -> new UserDTO(u.getUserId(), u.getUserName())).toList();

        return new FollowersDTO(user.getUserId(), user.getUserName(), followerDTOList);
    }

    /**
     * Get a user by id
     * @param id Unique user identifier.
     * @return User
     */
    private User getUserById (Integer id){
        return userRepository.findById(id).orElseThrow(() -> new NotFoundException("No existe el usuario con id: " + id));
    }

    /**
     * Valid if user is already following the seller
     * @param buyer
     * @param seller
     */
    private void validateFollow(User buyer, User seller) {
        if (!buyer.getFollowed().stream().noneMatch(f -> f.getUserId().equals(seller.getUserId()))) {
            throw new BadRequestException("El usuario ya está siguiendo al vendedor con ID: " + seller.getUserId());
        }
    }


    /**
     * Used to unfollow a seller
     * @param userId Unique user identifier.
     * @param userIdToFollow Unique user identifier.
     * @return GenericResponseDTO
     */
    public GenericResponseDTO unfollow(Integer userId, Integer userIdToFollow) {
        if (userId.equals(userIdToFollow)) {
            throw new BadRequestException("El usuario no se puede dejar de seguir así mismo ID: " + userIdToFollow);
        }

        User seller = this.getUserById(userIdToFollow);

        User user = this.getUserById(userId);

        if (!user.getFollowed().contains(seller)) {
            throw new BadRequestException("El usuario no está siguiendo al usuario con ID: " + seller.getUserId());
        }
        user.unfollow((Seller) seller);

        return new GenericResponseDTO(HttpStatus.OK.value(), "Ok");
    }

    /**
     * Get followers count from a seller
     * @param userId Unique user identifier.
     * @return FollowersCountDTO
     */
    @Override
    public FollowersCountDTO getFollowersCount(Integer userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new NotFoundException("No existe el usuario con id: " + userId));
        if(!user.getClass().equals(Seller.class)){
            throw new BadRequestException("Los usuarios del tipo 'buyer' no tienen seguidores.");
        }
        return new FollowersCountDTO(user.getUserId(), user.getUserName(), ((Seller) user).getFollowers().size());
    }

    /**
     * Get a followers list
     * @param userId Unique user identifier.
     * @param order type allowed: name_asc | name_desc
     * @return FollowedDTO
     */
    @Override
    public FollowedDTO getFollowedList(Integer userId, String order) {
        if (order != null && !order.equals(NAME_ASC) && !order.equals(NAME_DESC))
            throw new IllegalArgumentException("La variable 'order' enviada es inválida (" + order + ").");

        User user = getUserById(userId);

        List<Seller> followedUsers = userRepository.getFollowedList(userId);
        if (order != null) {
            switch (order) {
                case NAME_ASC:
                    followedUsers.sort(Comparator.comparing(User::getUserName));
                    break;
                case NAME_DESC:
                    followedUsers.sort(Comparator.comparing(User::getUserName).reversed());
                    break;
            }
        }

        List<UserDTO> followedUserDTOList = followedUsers.stream()
                .map(u -> new UserDTO(u.getUserId(), u.getUserName()))
                .collect(Collectors.toList());

        return new FollowedDTO(userId, user.getUserName(), followedUserDTOList);
    }

}
