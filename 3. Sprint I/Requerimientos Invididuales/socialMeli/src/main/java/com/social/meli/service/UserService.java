package com.social.meli.service;

import com.social.meli.dto.response.*;
import com.social.meli.exception.UserFollowException;
import com.social.meli.exception.UserIsNotVendorException;
import com.social.meli.repository.IUserRepository;
import com.social.meli.entity.User;
import com.social.meli.exception.InvalidDataException;
import com.social.meli.exception.NotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


import static com.social.meli.entity.UserType.VENDOR;
import static java.util.Collections.reverseOrder;
import static java.util.Comparator.comparing;

@Service
@AllArgsConstructor
public class UserService implements IUserService {

    public static final String NO_SE_ENCONTRO_AL_USUARIO = "No se encontro al usuario";
    private final IUserRepository userRepository;

    @Override
    public MessageDTO newFollow(Integer userId, Integer userIdToFollow) {
        User user = getUserByIdOrThrow(userId, NO_SE_ENCONTRO_AL_USUARIO);
        User userFollow = getVendorUserByIdOrThrow(userIdToFollow);
        if (!user.getFollowedId().contains(userIdToFollow)) {
            userRepository.followUser(user, userFollow);
            return new MessageDTO("Comenzaste a seguir al usuario " + userFollow.getName());
        }
        throw new UserFollowException("Ya sigues a este usuario");
    }

    @Override
    public FollowedListDto getVendorFollowers(Integer userId, String order) {
        User userFound = getVendorUserByIdOrThrow(userId);
        List<VendorDto> followersListDTO =
                userRepository.getAllFollowers(userFound.getFollowersId())
                        .stream()
                        .map(VendorDto::new)
                        .toList();
        if (order == null) return new FollowedListDto(userId, userFound.getName(),followersListDTO);
        return new FollowedListDto(userId, userFound.getName(), sortVendorDtoListByName(followersListDTO, order));
    }


    public VendorFollowCountDto getFollowerCount(Integer userId) {
        User user = getVendorUserByIdOrThrow(userId);
        return new VendorFollowCountDto(user);
    }

    @Override
    public MessageDTO unfollowUser(Integer userId, Integer userIdToUnfollow) {
        User user = getUserByIdOrThrow(userId, NO_SE_ENCONTRO_AL_USUARIO);
        User userToUnfollow = getUserByIdOrThrow(userIdToUnfollow, "No existe el usuario que se quieres dejar de seguir ");
        if (user.getFollowedId().contains(userIdToUnfollow)) {
            userRepository.unfollowUser(user, userToUnfollow);
            return new MessageDTO("Dejaste de seguir al usuario con exito");
        }
        throw new UserFollowException("El usuario no esta en tu lista de followed");
    }

    private User getUserByIdOrThrow(Integer userId, String errorMessage) {
        return userRepository
                .findUserByUserId(userId)
                .orElseThrow(() -> new NotFoundException(errorMessage));
    }

    private User getVendorUserByIdOrThrow(Integer userId) {
        User user = getUserByIdOrThrow(userId, NO_SE_ENCONTRO_AL_USUARIO);
        if (!VENDOR.equals(user.getType()))
            throw new UserIsNotVendorException("El usuario " + user.getName() + " no es un vendedor");
        return user;
    }

    @Override
    public FollowedListDto getFollowedList(Integer userId, String order) {
        User user = getUserByIdOrThrow(userId, NO_SE_ENCONTRO_AL_USUARIO);
        List<VendorDto> followedVendors = user.getFollowedId().stream()
                .map(id -> userRepository.findUserByUserId(id).orElseThrow(() -> new NotFoundException("No se encontró al seguido")))
                .filter(user1 -> VENDOR.equals(user1.getType()))
                .map(u -> new VendorDto(u.getId(), u.getName()))
                .toList();
        if (order == null) return new FollowedListDto(userId, user.getName(), followedVendors);
        return new FollowedListDto(userId, user.getName(), sortVendorDtoListByName(followedVendors, order));
    }

    private List<VendorDto> sortVendorDtoListByName(List<VendorDto> vendorDtos, String order) {
        if (order.equalsIgnoreCase("name_asc")) {
            return vendorDtos.stream()
                    .sorted(comparing(VendorDto::getUserName))
                    .toList();
        } else if (order.equalsIgnoreCase("name_desc")) {
            return vendorDtos.stream()
                    .sorted(comparing(VendorDto::getUserName).reversed())
                    .toList();
        }
        throw new InvalidDataException("Los datos de ordenamiento solicitados son incorrectos.");
    }
}
