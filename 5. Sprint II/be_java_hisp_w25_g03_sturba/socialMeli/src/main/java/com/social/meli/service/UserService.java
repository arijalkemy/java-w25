package com.social.meli.service;

import com.social.meli.dto.response.FollowedListDto;
import com.social.meli.dto.response.MessageDto;
import com.social.meli.dto.response.UserVendorDto;
import com.social.meli.dto.response.VendorFollowCountDto;
import com.social.meli.entity.User;
import com.social.meli.entity.UserType;
import com.social.meli.exception.InvalidDataException;
import com.social.meli.exception.NotFoundException;
import com.social.meli.exception.UserFollowException;
import com.social.meli.exception.UserIsNotVendorException;
import com.social.meli.repository.IUserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
@AllArgsConstructor
public class UserService implements IUserService {
    private final IUserRepository userRepository;

    @Override
    public MessageDto newFollow(Integer userId, Integer userIdToFollow) {
        User user = getUserByIdOrThrow(userId);
        User userFollow = getVendorUserByIdOrThrow(userIdToFollow);
        boolean userIsMatch = user.getFollowedId().contains(userIdToFollow);
        if (!userIsMatch) {
            userRepository.followUser(user, userFollow);
            return new MessageDto("Comenzaste a seguir al usuario " + userFollow.getName());
        }
        throw new UserFollowException("Ya sigues a este usuario");
    }

    @Override
    public FollowedListDto getVendorFollowers(Integer userId, String order) {
        User userFound = getVendorUserByIdOrThrow(userId);
        List<UserVendorDto> followersListDTO = userRepository.getAllFollowers(userFound.getFollowersId())
                .stream()
                .map(UserVendorDto::new)
                .toList();
        if (order == null) return new FollowedListDto(userId, userFound.getName(), followersListDTO);
        return new FollowedListDto(userId, userFound.getName(), sortFollowedListByName(followersListDTO, order));
    }

    @Override
    public FollowedListDto getFollowedList(Integer userId, String order) {
        User user = getUserByIdOrThrow(userId);
        List<UserVendorDto> followedVendors = user.getFollowedId().stream()
                .map(id -> userRepository.findUserByUserId(id).orElseThrow(() -> new NotFoundException("No se encontró al seguido")))
                .filter(user1 -> UserType.VENDOR.equals(user1.getType()))
                .map(u -> new UserVendorDto(u.getId(), u.getName()))
                .toList();
        if (order == null) return new FollowedListDto(userId, user.getName(), followedVendors);
        return new FollowedListDto(userId, user.getName(), sortFollowedListByName(followedVendors, order));
    }

    @Override
    public VendorFollowCountDto getFollowerCount(Integer userId) {
        User user = getVendorUserByIdOrThrow(userId);
        return new VendorFollowCountDto(user);
    }

    @Override
    public MessageDto unfollowUser(Integer userId, Integer userIdToUnfollow) {
        User user = getUserByIdOrThrow(userId);
        User userToUnfollow = getUserByIdOrThrow(userIdToUnfollow);
        if (user.getFollowedId().contains(userIdToUnfollow)) {
            userRepository.unfollowUser(user, userToUnfollow);
            return new MessageDto("Dejaste de seguir a "+userToUnfollow.getName());
        }
        throw new UserFollowException("El usuario no esta en tu lista de followed");
    }

    private User getVendorUserByIdOrThrow(Integer userId) {
        User user = getUserByIdOrThrow(userId);
        if (!UserType.VENDOR.equals(user.getType())) throw new UserIsNotVendorException("El usuario no es un vendedor");
        return user;
    }

    private User getUserByIdOrThrow(Integer userId) {
        return userRepository
                .findUserByUserId(userId)
                .orElseThrow(() -> new NotFoundException("No se encontro al usuario"));
    }


    private List<UserVendorDto> sortFollowedListByName(List<UserVendorDto> vendorDtos, String order) {
        if (order.equalsIgnoreCase("name_asc")) {
            return vendorDtos.stream()
                    .sorted(Comparator.comparing(UserVendorDto::getUserName))
                    .toList();
        } else if (order.equalsIgnoreCase("name_desc")) {
            return vendorDtos.stream()
                    .sorted(Comparator.comparing(UserVendorDto::getUserName).reversed())
                    .toList();
        }
        throw new InvalidDataException("Los datos de ordenamiento solicitados son incorrectos.");
    }
}
