package org.socialmeli.service.implementation;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.socialmeli.dto.request.*;
import org.socialmeli.dto.response.FollowerCountDto;
import org.socialmeli.dto.response.FollowersListDto;
import org.socialmeli.dto.response.FollowingListDto;
import org.socialmeli.dto.response.MessageDto;
import org.socialmeli.entity.Client;
import org.socialmeli.entity.User;
import org.socialmeli.entity.Vendor;
import org.socialmeli.exception.BadRequestException;
import org.socialmeli.exception.NotFoundException;
import org.socialmeli.repository.implementation.ClientRepositoryImp;
import org.socialmeli.repository.implementation.VendorRepositoryImp;
import org.socialmeli.service.IUsersService;
import org.socialmeli.util.DTOMapper;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

import static java.util.Comparator.comparing;

@Service
public class UsersServiceImp implements IUsersService {
    ClientRepositoryImp clientRepositoryImp;
    VendorRepositoryImp vendorRepositoryImp;

    private final String ASCENDANT_NAME_ORDER = "name_asc";
    private final String DESCENDENT_NAME_ORDER = "name_desc";

    ObjectMapper mapper = new ObjectMapper();

    public UsersServiceImp(ClientRepositoryImp clientRepo, VendorRepositoryImp vendorRepo) {
        this.clientRepositoryImp = clientRepo;
        this.vendorRepositoryImp = vendorRepo;
    }

    public void userFollowVendor(UserFollowVendorDto req) {
        Integer userId = req.getUserFollower();
        Integer vendorId = req.getVendorToFollow();

        if (userId.equals(vendorId)) {
            throw new BadRequestException("Un usuario no se puede seguir a si mismo");
        }

        User user = getUserById(userId);
        Vendor vendor = getVendorById(vendorId);

        boolean alreadyFollowed = vendor.getFollowers().stream().anyMatch(u -> u.getUserId().equals(userId));
        if (alreadyFollowed) {
            throw new BadRequestException("Ya se esta siguiendo al vendedor");
        }

        user.getFollowing().add(vendor);
        vendor.getFollowers().add(user);
    }

    @Override
    public FollowerCountDto vendorFollowersCount(UserIdDto userIdDto) {
        Integer userId = userIdDto.getUserId();
        Vendor vendor = getVendorById(userId);

        return new FollowerCountDto(userId, vendor.getUserName(), vendor.getFollowers().size());
    }

    @Override
    public FollowersListDto getFollowersList(FollowersListReqDto req) {
        String order = req.getOrder();

        verifyOrder(order);

        Integer userId = req.getUserId();
        Vendor vendor = getVendorById(userId);

        List<User> followerUsers = vendor.getFollowers();

        if (order.equals(ASCENDANT_NAME_ORDER)) {
            followerUsers = ordenarListaUsuariosPor(followerUsers, comparing(User::getUserName));
        } else {
            followerUsers = ordenarListaUsuariosPor(followerUsers, comparing(User::getUserName).reversed());
        }

        return DTOMapper.toVendorFollowersList(vendor, followerUsers);
    }

    private List<User> ordenarListaUsuariosPor(List<User> followerUsers, Comparator<User> comparing) {
        return followerUsers.stream().sorted(comparing).toList();
    }

    @Override
    public FollowingListDto getFollowingList(FollowingListReqDto req) {
        String order = req.getOrder();
        verifyOrder(order);
        Integer userId = req.getUserId();

        User user = getUserById(userId);

        return getVendorsFollowingListDto(order, user);
    }

    private void verifyOrder(String order) {
        if (!order.equals(ASCENDANT_NAME_ORDER) && !order.equals(DESCENDENT_NAME_ORDER) ) {
            throw new BadRequestException("El ordenamiento pedido es inválido");
        }
    }

    private FollowingListDto getVendorsFollowingListDto(String order, User user) {
        List<Vendor> following = user.getFollowing();
        if (order.equals(ASCENDANT_NAME_ORDER)){
            following = following.stream().sorted(comparing(User::getUserName)).toList();
        } else {
            following = following.stream().sorted(comparing(User::getUserName).reversed()).toList();
        }
        return DTOMapper.toVendorsFollowingList(user.getUserId(), user.getUserName(), following);
    }

    @Override
    public MessageDto unfollowVendor(UserUnfollowVendorDto req) {
        boolean removed;
        Integer userId = req.getUserId();
        Integer vendorId = req.getVendorId();

        if (userId.equals(vendorId))
            throw new BadRequestException("Error: Ambos id son identicos");

        User user = getUserById(userId);
        Vendor vendorToUnfollow = getVendorById(vendorId);

        removed = user.getFollowing().removeIf(v -> v.getUserId().equals(vendorId));
        vendorToUnfollow.getFollowers().removeIf(u -> u.getUserId().equals(userId));

        if (removed) {
            return new MessageDto("El usuario con id " + userId + " ha dejado de seguir al vendedor con id " + vendorId);
        } else {
            throw new BadRequestException("Error: El usuario con id " + userId + " no está siguiendo al vendedor con id " + vendorId);
        }
    }

    private User getUserById(Integer userId) {
        User user = clientRepositoryImp.findOne(userId);
        if (user == null) {
            user = vendorRepositoryImp.findOne(userId);
            if (user == null) throw new NotFoundException("El usuario no existe");
        }
        return user;
    }

    private Client getClientById(Integer clientId) {
        Client client = clientRepositoryImp.findOne(clientId);
        if (client == null) throw new NotFoundException("El cliente no existe");
        return client;
    }

    private Vendor getVendorById(Integer vendorId) {
        Vendor vendor = vendorRepositoryImp.findOne(vendorId);
        if (vendor == null) throw new NotFoundException("El vendedor no existe");
        return vendor;
    }
}
