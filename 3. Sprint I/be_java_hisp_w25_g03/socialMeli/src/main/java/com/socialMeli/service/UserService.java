package com.socialMeli.service;

import com.socialMeli.dto.response.FollowedListDto;
import com.socialMeli.dto.response.VendorDto;
import com.socialMeli.dto.response.VendorFollowCountDto;
import com.socialMeli.dto.response.*;
import com.socialMeli.entity.User;
import com.socialMeli.exception.InvalidDataException;
import com.socialMeli.exception.NotFoundException;
import com.socialMeli.exception.UserFollowException;
import com.socialMeli.exception.UserIsNotVendorException;
import com.socialMeli.repository.IUserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;


import static com.socialMeli.entity.UserType.VENDOR;

@Service
@AllArgsConstructor
public class UserService implements IUserService {

    private final IUserRepository userRepository;

    @Override
    public MessageDTO newFollow(Integer userId, Integer userIdToFollow) {
        User user = getUserByIdOrThrow(userId, "No se encontro al usuario");
        User userFollow = getUserByIdOrThrow(userIdToFollow, "No se encontro el vendedor a seguir");
        if (!VENDOR.equals(userFollow.getType()))
            throw new UserIsNotVendorException("El usuario " + userFollow.getName() + " a seguir no es un vendedor");
        boolean userIsMatch = user.getFollowedId().contains(userIdToFollow);
        if (!userIsMatch) {
            userRepository.followUser(user, userFollow);
            return new MessageDTO("Comenzaste a seguir al usuario " + userFollow.getName());
        }
        throw new UserFollowException("Ya sigues a este usuario");
    }

    @Override
    public VendorFollowerListDTO getVendorFollowers(Integer userId, String order) {
        User userFound = getUserByIdOrThrow(userId, "Vendedor no encontrado");
        if (!VENDOR.equals(userFound.getType())) throw new UserIsNotVendorException("El usuario no es un vendedor");

        List<UserVendorDTO> followersListDTO = userRepository.getAllFollowers(userFound.getFollowersId())
                .stream()
                .map(UserVendorDTO::new)
                .toList();
        if ("name_asc".equals(order)) {
            followersListDTO =
                    followersListDTO.stream()
                            .sorted(Comparator.comparing(UserVendorDTO::getUserName))
                            .toList();
        }else if ("name_desc".equals(order)){
            followersListDTO =
                    followersListDTO.stream()
                            .sorted(Comparator.comparing(UserVendorDTO::getUserName, Comparator.reverseOrder()))
                            .toList();
        }else if (order!=null){
            throw new InvalidDataException("Se envió un dato de ordenamiento inválido");
        }
        return new VendorFollowerListDTO(userId, userFound.getName(), followersListDTO);
    }


    public VendorFollowCountDto getFollowerCount(Integer userId) {
        User user = getUserByIdOrThrow(userId, "El usuario no fue encontrado");
        if (!VENDOR.equals(user.getType())) throw new UserIsNotVendorException("El usuario no es un vendedor");
        return new VendorFollowCountDto(user);
    }

    @Override
    public UserUnfollowedDto unfollowUser(Integer userId, Integer userIdToUnfollow) {
        User user = getUserByIdOrThrow(userId, "No se encontro al usuario");
        User userToUnfollow = getUserByIdOrThrow(userIdToUnfollow, "No existe el usuario que se quieres dejar de seguir ");
        if (user.getFollowedId().contains(userIdToUnfollow)) {
            userRepository.unfollowUser(user, userToUnfollow);
            return new UserUnfollowedDto(userId, userIdToUnfollow);
        }
        throw new UserFollowException("El usuario no esta en tu lista de followed");
    }

    private User getUserByIdOrThrow(Integer userId, String errorMessage) {
        return userRepository
                .findUserByUserId(userId)
                .orElseThrow(() -> new NotFoundException(errorMessage));
    }

    @Override
    public FollowedListDto getFollowedList(Integer userId, String order) {
        User user = getUserByIdOrThrow(userId, "No se encontró al usuario");
        List<VendorDto> followedVendors = user.getFollowedId().stream()
                .map(id -> userRepository.findUserByUserId(id).orElseThrow(() -> new NotFoundException("No se encontró al seguido")))
                .filter(user1 -> VENDOR.equals(user1.getType()))
                .map(u -> new VendorDto(u.getId(), u.getName()))
                .toList();
        if (order == null) return new FollowedListDto(userId, user.getName(), followedVendors);
        return new FollowedListDto( userId, user.getName(), sortFollowedListByName(followedVendors, order));
    }
    private List<VendorDto> sortFollowedListByName (List<VendorDto> vendorDtos, String order) {
        if (order.equalsIgnoreCase("name_asc")) {
            return vendorDtos.stream()
                    .sorted(Comparator.comparing(VendorDto::getUserName))
                    .toList();
        } else if (order.equalsIgnoreCase("name_desc")) {
            return vendorDtos.stream()
                    .sorted(Comparator.comparing(VendorDto::getUserName).reversed())
                    .toList();
        }
        throw new InvalidDataException("Los datos de ordenamiento solicitados son incorrectos.");
    }
}
