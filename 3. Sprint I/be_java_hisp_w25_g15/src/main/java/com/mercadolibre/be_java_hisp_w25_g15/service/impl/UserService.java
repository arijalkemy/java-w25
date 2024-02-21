package com.mercadolibre.be_java_hisp_w25_g15.service.impl;

import com.mercadolibre.be_java_hisp_w25_g15.dto.request.UnfollowDto;
import com.mercadolibre.be_java_hisp_w25_g15.dto.response.CountFollowersDto;
import com.mercadolibre.be_java_hisp_w25_g15.dto.response.MessageResponseDto;
import com.mercadolibre.be_java_hisp_w25_g15.dto.response.UserDto;
import com.mercadolibre.be_java_hisp_w25_g15.dto.response.UserListDto;
import com.mercadolibre.be_java_hisp_w25_g15.exception.ConflictException;
import com.mercadolibre.be_java_hisp_w25_g15.exception.NotFoundException;
import com.mercadolibre.be_java_hisp_w25_g15.model.Seller;
import com.mercadolibre.be_java_hisp_w25_g15.model.User;
import com.mercadolibre.be_java_hisp_w25_g15.repository.IUserRepository;
import com.mercadolibre.be_java_hisp_w25_g15.service.IUserService;
import com.mercadolibre.be_java_hisp_w25_g15.utils.ObjectMapperBean;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.Optional;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class UserService implements IUserService {
    private final IUserRepository userRepository;

    @Override
    public MessageResponseDto unfollowSeller(UnfollowDto unfollowDto) {
        if (unfollowDto.userId() == unfollowDto.unfollowUserId()){
            throw new ConflictException("Users must be different");
        }
        Optional<User> buyer = userRepository.getUserById(unfollowDto.userId());
        if (buyer.isEmpty()) {
            throw new NotFoundException("User not found");
        }
        Optional<User> seller = userRepository.getUserById(unfollowDto.unfollowUserId());
        if (seller.isEmpty()){
            throw new NotFoundException("Seller not found");
        }
        if (buyer.get().getFollowed().stream().noneMatch(u -> u.getId() == seller.get().getId())) {
            throw new NotFoundException("Seller is not followed");
        }

        buyer.get().getFollowed().removeIf(followed -> followed.getId() == seller.get().getId());
        ((Seller) seller.get()).getFollowers().removeIf(follower -> follower.getId() == buyer.get().getId());
        userRepository.updateFollowedList(buyer.get());
        userRepository.updateFollowerList(seller.get());
        return new MessageResponseDto("User unfollowed successfully");
    }

    @Override
    public MessageResponseDto followSeller(int userId, int userIdToFollow){
        if(userId == userIdToFollow)
            throw new ConflictException("Users must be different");
        Optional<User> user = this.userRepository.getUserById(userId);
        if(user.isEmpty())
            throw new NotFoundException("User not found");
        Optional<User> userToFollow = this.userRepository.getUserById(userIdToFollow);
        if(userToFollow.isEmpty())
            throw new NotFoundException("User to follow not found");
        if(!(userToFollow.get() instanceof Seller))
            throw new ConflictException("User to follow is not a Seller");
        Optional<User> resultSearchUserInFollowersOfSeller = ((Seller) userToFollow.get())
                .getFollowers()
                .stream()
                .filter((v) -> v.getId() == userId)
                .findFirst();
        if(resultSearchUserInFollowersOfSeller.isPresent())
            throw new ConflictException("User already is following");

        user.get().getFollowed().add(userToFollow.get());
        ((Seller) userToFollow.get()).getFollowers().add(user.get());

        this.userRepository.updateFollowerList(userToFollow.get());
        this.userRepository.updateFollowedList(user.get());

        return new MessageResponseDto("Seller followed correctly");
    }

    @Override
    public CountFollowersDto countFollowersByUserId(int userId){
        Optional<User> user = this.userRepository.getUserById(userId);
        if(user.isEmpty())
            throw new NotFoundException("User not found");
        if(!(user.get() instanceof Seller))
            throw new ConflictException("User is not a Seller");
        return new CountFollowersDto(
          user.get().getId(),
          user.get().getUsername(),
          ((Seller) user.get()).getFollowers().size()
        );
    }
    @Override
    public UserDto findAllSellerFollowers(int sellerId, String order){
        Optional<User> optionalUser = this.userRepository.getUserById(sellerId);

        if (optionalUser.isEmpty()) {
            throw new NotFoundException("Seller not found");
        }

        User user = optionalUser.get();

        if (!(user instanceof Seller)) {
            throw new NotFoundException("User is not a seller");
        } else if (((Seller) user).getFollowers().isEmpty()) {
            throw new NotFoundException("Seller has no followers");
        } else {
            List<UserListDto> userListDtos = createUserListDto(((Seller) user).getFollowers());
            return new UserDto( user.getId(), user.getUsername(), sortUserListDto(userListDtos, order) , null);
        }
    }

    @Override
    public UserDto findAllFollowedByUser(int userId, String order) {
        Optional<User> user = userRepository.getUserById(userId);
        // Se valida si el usuario existe
        if(user.isEmpty()){
            throw  new NotFoundException("User not found");
        }
        if(user.get().getFollowed().isEmpty()){
            throw new NotFoundException("User has not followed");
        }else{
            // Se encapsula en un objeto DTO con atributos DTO
            return new UserDto( user.get().getId(), user.get().getUsername(), null, sortUserListDto(createUserListDto(user.get().getFollowed()), order));
        }
    }

    @Override
    public List<UserListDto> findAll() {
        if(userRepository.getAllUsers().isEmpty()){
            throw new NotFoundException("Usuarios no registrados");
        }
       return parseUsersDto(userRepository.getAllUsers());
    }

    // Método para convertir una lista Entidad tipo User a una lista Dto tipo SellerDto
    private List<UserListDto> createUserListDto(List<User> users){
        return users.stream()
                .map(user -> new UserListDto(user.getId(),user.getUsername()))
                .toList();
    }

    private List<UserListDto> sortUserListDto(List<UserListDto> userListDtos, String order){
        if (order != null) {
            if (order.equals("name_asc") && userListDtos.size() > 1) {
                // sort by name asc
                userListDtos = userListDtos.stream().sorted(Comparator.comparing(UserListDto::getUsername)).collect(Collectors.toList());
            } else if (order.equals("name_desc") && userListDtos.size() > 1) {
                // sort by name desc
                userListDtos = userListDtos.stream().sorted(Comparator.comparing(UserListDto::getUsername).reversed()).collect(Collectors.toList());
            }
        }
        return userListDtos;
    }

    // Método para convertir una lista Entidad tipo User a una lista Dto tipo UserDto
    private List<UserListDto> parseUsersDto(List<User> users){
        return users.stream().map(u -> new UserListDto(u.getId(), u.getUsername()))
                .toList();
    }

}
