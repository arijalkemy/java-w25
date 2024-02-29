package com.mercadolibre.be_java_hisp_w25_g15.service.impl;

import com.mercadolibre.be_java_hisp_w25_g15.dto.request.FollowDto;
import com.mercadolibre.be_java_hisp_w25_g15.dto.request.UnfollowDto;
import com.mercadolibre.be_java_hisp_w25_g15.dto.response.CountFollowersDto;
import com.mercadolibre.be_java_hisp_w25_g15.dto.response.MessageResponseDto;
import com.mercadolibre.be_java_hisp_w25_g15.dto.response.UserDto;
import com.mercadolibre.be_java_hisp_w25_g15.dto.response.UserListDto;
import com.mercadolibre.be_java_hisp_w25_g15.exception.ConflictException;
import com.mercadolibre.be_java_hisp_w25_g15.exception.NotFoundException;
import com.mercadolibre.be_java_hisp_w25_g15.exception.OrderNotValidException;
import com.mercadolibre.be_java_hisp_w25_g15.model.Seller;
import com.mercadolibre.be_java_hisp_w25_g15.model.User;
import com.mercadolibre.be_java_hisp_w25_g15.repository.IUserRepository;
import com.mercadolibre.be_java_hisp_w25_g15.service.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.Objects;
import java.util.Optional;
import java.util.List;
import java.util.stream.Collectors;

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

        userRepository.removeFollowed(buyer.get(), (Seller) seller.get());
        userRepository.removeFollower((Seller) seller.get(), buyer.get());

        return new MessageResponseDto("User unfollowed successfully");
    }

    @Override
    public MessageResponseDto followSeller(FollowDto followDto){
        if(Objects.equals(followDto.userId(), followDto.userIdToFollow()))
            throw new ConflictException("Users must be different");
        Optional<User> user = this.userRepository.getUserById(followDto.userId());
        if(user.isEmpty())
            throw new NotFoundException("User not found");
        Optional<User> userToFollow = this.userRepository.getUserById(followDto.userIdToFollow());
        if(userToFollow.isEmpty())
            throw new NotFoundException("User to follow not found");
        if(!(userToFollow.get() instanceof Seller))
            throw new ConflictException("User to follow is not a Seller");
        Optional<User> resultSearchUserInFollowersOfSeller = ((Seller) userToFollow.get())
                .getFollowers()
                .stream()
                .filter((v) -> Objects.equals(v.getId(), followDto.userId()))
                .findFirst();
        if(resultSearchUserInFollowersOfSeller.isPresent())
            throw new ConflictException("User already is following");

        this.userRepository.addFollowed(user.get(), (Seller) userToFollow.get());
        this.userRepository.addFollower((Seller) userToFollow.get(),user.get());

        return new MessageResponseDto("Seller followed correctly");
    }

    @Override
    public CountFollowersDto countFollowersByUserId(Integer userId){
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
    public UserDto findAllSellerFollowers(Integer sellerId, String order){

        if(!orderIsValid(order)){
            throw new OrderNotValidException("The given order filter is not valid");
        }
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
    public UserDto findAllFollowedByUser(Integer userId, String order) {

        if (!orderIsValid(order)){
            throw new OrderNotValidException("The given order filter is not valid");
        }

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
        List<User> userList = userRepository.getAllUsers();
        if(userList.isEmpty()){
            throw new NotFoundException("User list is empty");
        }
       return parseUsersDto(userList);
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

    private boolean orderIsValid(String order){
       return (order.equals("name_asc")||order.equals("name_desc"));
    }

    // Método para convertir una lista Entidad tipo User a una lista Dto tipo UserDto
    private List<UserListDto> parseUsersDto(List<User> users){
        return users.stream().map(u -> new UserListDto(u.getId(), u.getUsername()))
                .toList();
    }

}
