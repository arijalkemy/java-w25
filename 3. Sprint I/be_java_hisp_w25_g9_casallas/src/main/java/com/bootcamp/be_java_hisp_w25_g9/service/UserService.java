package com.bootcamp.be_java_hisp_w25_g9.service;

import com.bootcamp.be_java_hisp_w25_g9.dto.UserDto;
import com.bootcamp.be_java_hisp_w25_g9.dto.response.FollowedDto;
import com.bootcamp.be_java_hisp_w25_g9.dto.response.FollowersDto;
import com.bootcamp.be_java_hisp_w25_g9.dto.response.FolowersCountDto;
import com.bootcamp.be_java_hisp_w25_g9.dto.response.MessageDto;
import com.bootcamp.be_java_hisp_w25_g9.exceptions.NoUsersFoundException;
import com.bootcamp.be_java_hisp_w25_g9.model.Seller;
import com.bootcamp.be_java_hisp_w25_g9.model.User;
import com.bootcamp.be_java_hisp_w25_g9.exceptions.BadRequestException;
import com.bootcamp.be_java_hisp_w25_g9.exceptions.*;
import com.bootcamp.be_java_hisp_w25_g9.model.Seller;
import com.bootcamp.be_java_hisp_w25_g9.repository.interfaces.IUserRepository;
import com.bootcamp.be_java_hisp_w25_g9.service.interfaces.IUserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import com.bootcamp.be_java_hisp_w25_g9.model.Client;
import com.bootcamp.be_java_hisp_w25_g9.dto.UserDtoMixIn;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IUserService {
    private final IUserRepository userRepository;
    ObjectMapper mapper = new ObjectMapper();

    public UserService(IUserRepository userRepository) {
        this.userRepository = userRepository;
        mapper.addMixIn(Client.class, UserDtoMixIn.class);
        mapper.addMixIn(Seller.class, UserDtoMixIn.class);
    }

    @Override
    public MessageDto follow(int userId, int userIdToFollow) {
        if(userId == userIdToFollow)
            throw new BadRequestException("El usuario no puede seguirse a sí mismo");

        if(!userRepository.userExists(userId))
            throw new BadRequestException("El cliente no existe");
        if(!userRepository.userExists(userIdToFollow))
            throw new BadRequestException("El vendedor no existe");
        if(userRepository.getUserById(userIdToFollow).getClass() == Client.class)
            throw new BadRequestException("Solo puede seguir vendedores");

        Client client = (Client) userRepository.getUserById(userId);
        Seller seller = (Seller) userRepository.getUserById(userIdToFollow);

        List<Seller> followedList = client.getFollowed();
        Optional<Seller> sellerFollowed = followedList.stream().filter(u -> u.getUserId()==userIdToFollow).findFirst();
        if(sellerFollowed.isPresent())
            throw new BadRequestException("No se puede seguir a un vendedor que ya se esta siguiendo");
        followedList.add(seller);

        userRepository.save(client);

        return new MessageDto("Vendedor seguido con exito");
    }

    @Override
    public MessageDto unfollow(int userId, int userIdToUnfollow) {
        if (userId == userIdToUnfollow)
            throw new BadRequestException("El usuario no puede dejar de seguirse a sí mismo");
        if(!userRepository.userExists(userId))
            throw new BadRequestException("El cliente no existe");
        if(!userRepository.userExists(userIdToUnfollow))
            throw new BadRequestException("El vendedor no existe");

        Client client = (Client) userRepository.getUserById(userId);
        Seller seller = (Seller) userRepository.getUserById(userIdToUnfollow);

        List<Seller> followedList = client.getFollowed();
        Optional<Seller> sellerFollowed = followedList.stream().filter(u -> u.getUserId() == userIdToUnfollow).findFirst();

        if(!sellerFollowed.isPresent())
            throw new BadRequestException("El vendedor no estaba en la lista de seguidos del cliente");

        followedList.remove(seller);

        return new MessageDto("El vendedor ha sido quitado de la lista de seguidos del cliente");
    }

    @Override
    public FolowersCountDto getFollowersCount(int userId) {

        List<Seller> sellerList = userRepository.findAll().stream()
                .flatMap(u -> u.getFollowed().stream()
                        .filter(s -> s.getUserId() == userId)
                )
                .toList();

        if (sellerList.isEmpty()) throw new NotFoundException("Vendedor no encontrado");
        int count = sellerList.size();

        return new FolowersCountDto(userId, sellerList.get(0).getUserName(), count);
    }

    @Override
    public FollowersDto getFollowers(int userId) {

        User sellerReceived = userRepository.getUserById(userId);
        if (sellerReceived == null) throw new NoUsersFoundException("El vendedor no fue encontrado");
        if (sellerReceived.getClass() != Seller.class) throw new BadRequestException("El usuario no es un vendedor");

        List<UserDto> followers = userRepository.findAll().stream()
                .filter(user -> user.getFollowed().stream().anyMatch(seller -> seller.getUserId() == userId))
                .map(user -> new UserDto(user.getUserId(), user.getUserName()))
                .toList();

        if (followers.isEmpty()) throw new NoUsersFoundException("El vendedor no tiene seguidores");

        return new FollowersDto(
                userId,
                sellerReceived.getUserName(),
                followers
        );
    }

    @Override
    public FollowersDto getFollowers(int userId, String order) {
        this.validateOrderInput(order);

        FollowersDto followers = this.getFollowers(userId);

        if(order.equalsIgnoreCase("name_desc")) return new FollowersDto(
                followers.user_id(),
                followers.user_name(),
                followers.followed().stream().sorted(Comparator.comparing(UserDto::user_name).reversed()).toList()
        );
        return new FollowersDto(
                followers.user_id(),
                followers.user_name(),
                followers.followed().stream().sorted(Comparator.comparing(UserDto::user_name)).toList()
        );
    }

    @Override
    public FollowedDto getFollowed(int userId) {
        User user = userRepository.getUserById(userId);
        if (user == null) throw new NotFoundException("Usuario no encontrado");
        if (user.getFollowed().isEmpty()) throw new NoUsersFoundException("El usuario no esta siguiendo a ningún vendedor");
        return new FollowedDto(
                userId,
                user.getUserName(),
                user.getFollowed().stream().map(seller -> new UserDto(seller.getUserId(), seller.getUserName())).toList()
        );
    }

    @Override
    public FollowedDto getFollowed(int userId, String order) {
        this.validateOrderInput(order);

        FollowedDto followedDto = getFollowed(userId);

        if (order.equalsIgnoreCase("name_desc")) return new FollowedDto(
                followedDto.user_id(),
                followedDto.user_name(),
                followedDto.followed().stream().sorted(Comparator.comparing(UserDto::user_name).reversed()).toList());

        return new FollowedDto(
                followedDto.user_id(),
                followedDto.user_name(),
                followedDto.followed().stream().sorted(Comparator.comparing(UserDto::user_name)).toList());
    }

    private void validateOrderInput(String order){
        boolean isValidOrder = !order.equalsIgnoreCase("name_desc") && !order.equalsIgnoreCase("name_asc");
        if (isValidOrder) throw new BadRequestException("El orden ingresado " + order + " no es válido");
    }
}
