package org.socialmeli.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.socialmeli.dto.request.*;
import org.socialmeli.dto.response.FollowerCountDto;
import org.socialmeli.dto.response.MessageDto;
import org.socialmeli.dto.response.VendorFollowersListDTO;
import org.socialmeli.dto.response.VendorsFollowingListDto;
import org.socialmeli.entity.Client;
import org.socialmeli.entity.User;
import org.socialmeli.entity.Vendor;
import org.socialmeli.exception.BadRequestException;
import org.socialmeli.exception.NotFoundException;
import org.socialmeli.repository.ClientRepositoryImp;
import org.socialmeli.repository.VendorRepositoryImp;
import org.socialmeli.utils.DTOMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static java.util.Comparator.comparing;

@Service
public class UsersServiceImp implements IUsersService {
    @Autowired
    ClientRepositoryImp clientRepositoryImp;

    @Autowired
    VendorRepositoryImp vendorRepositoryImp;

    ObjectMapper mapper = new ObjectMapper();


    private User getUserById(Integer userId) {
        User user  = clientRepositoryImp.findOne(userId);
        if(user == null) {
             user  = vendorRepositoryImp.findOne(userId);
              if (user == null) throw new NotFoundException("El usuario ingresado no existe ");
        }
        return user;
    }

    private Vendor getVendorById(Integer vendorId) {
            Vendor vendor = vendorRepositoryImp.findOne(vendorId);
            if(vendor == null ) throw new NotFoundException("El vendedor no existe");
            return vendor;

    }
    public void userFollowVendor(UserFollowVendorDto req){
        Integer userId = req.getUserFollower();
        Integer vendorId = req.getVendorToFollow();

        if(userId.equals(vendorId))  throw new BadRequestException("Un usuario no se puede seguir a si mismo");
        User user = getUserById(userId);
        Vendor vendor = getVendorById(vendorId);


        boolean alreadyFollowed = vendor.getFollowers().stream().anyMatch(u -> u.getUserId().equals(userId));
        if(alreadyFollowed){
                throw new BadRequestException("Ya se esta siguiendo al vendedor");
        }


        user.getFollowing().add(vendor);
        vendor.getFollowers().add(user);
    }

    @Override
    public FollowerCountDto vendorFollowersCount(UserIdDto userIdDto) {
        Integer userId = userIdDto.getUserId();
        Vendor vendor = vendorRepositoryImp.findOne(userId);

        if(vendor == null) throw new NotFoundException(String.format("No se encontró un usuario con id %d", userId));


        return  new FollowerCountDto(userId,vendor.getUserName(),vendor.getFollowers().size());
    }

    @Override
    public VendorFollowersListDTO getFollowersList(FollowersListReqDto req) {
        Integer userId = req.getUserId();
        String order = req.getOrder();
        Vendor vendor = vendorRepositoryImp.findOne(userId);
        if (vendor == null) {
            throw new NotFoundException(String.format("No se encontró un usuario con id %d", userId));
        }

        List<User> followerUsers = vendor.getFollowers();

        switch (order){
            case "name_asc" -> followerUsers = ordenarListaUsuariosPor(followerUsers, comparing(User::getUserName));
                //break;
            case "name_desc" -> followerUsers = ordenarListaUsuariosPor(followerUsers, comparing(User::getUserName).reversed());
                //break;
            default -> throw new BadRequestException("El ordenamiento pedido es inválido");
        }

        return DTOMapper.toVendorFollowersList(vendor, followerUsers);
    }

    private List<User> ordenarListaUsuariosPor(List<User> followerUsers, Comparator<User> comparing) {
        return followerUsers.stream().sorted(comparing).toList();
    }

    @Override
    public VendorsFollowingListDto getFollowingList(FollowingListReqDto req) {
        Integer userId = req.getUserIdDto();
        String order = req.getOrder();
        Client client = clientRepositoryImp.findOne(userId);
        Vendor vendor = vendorRepositoryImp.findOne(userId);

        VendorsFollowingListDto clientFollowing = getVendorsFollowingListDto(order, client);
        if (clientFollowing != null) return clientFollowing;

        VendorsFollowingListDto vendorFollowing = getVendorsFollowingListDto(order, vendor);
        if (vendorFollowing != null) return vendorFollowing;

        throw new NotFoundException(String.format("No se encontró un usuario con el ID %d.", userId));
    }

    private VendorsFollowingListDto getVendorsFollowingListDto(String order, User user) {
        if (user != null) {
            List<Vendor> following = user.getFollowing();
            switch (order) {
                case "name_asc":
                    following = following.stream().sorted(comparing(User::getUserName)).toList();
                    break;
                case "name_desc":
                    following = following.stream().sorted(comparing(User::getUserName).reversed()).toList();
                    break;
                default:
                    throw new BadRequestException("El ordenamiento pedido es inválido");
            }
            return DTOMapper.toVendorsFollowingList(user.getUserId(), user.getUserName(), following);
        }
        return null;
    }

    @Override
    public MessageDto unfollowVendor(UserUnfollowVendorDTO req) {
        boolean removedFromClient = false;
        boolean removedFromVendor = false;
        Integer userId = req.getUserId();
        Integer vendorId = req.getVendorId();

        if (userId.equals(vendorId))
            throw new BadRequestException("Error: Ambos id son identicos");

        Client userClient = clientRepositoryImp.findOne(userId);
        Vendor userVendor = vendorRepositoryImp.findOne(userId);
        Vendor vendorToUnfollow = vendorRepositoryImp.findOne(vendorId);

        //Check if IDs exist
        if (userClient == null && userVendor == null)
            throw new NotFoundException("Error: No se encontró el usuario con id " + userId);
        if (vendorToUnfollow == null)
            throw new NotFoundException("Error: No se encontró el vendedor con id " + vendorId);

        // El 'userId' ingresado es un cliente
        if (userClient != null) {
            //Usé new ArrayList para que no tire excepcion ya que devuelve UnmodifiableCollection
            removedFromClient = userClient.getFollowing().removeIf(v -> v.getUserId().equals(vendorId));
            vendorToUnfollow.getFollowers().removeIf(u -> u.getUserId().equals(userId));
        } else { // El 'userId' ingresado es un vendedor
            removedFromVendor = userVendor.getFollowing().removeIf(v -> v.getUserId().equals(vendorId));
            userVendor.getFollowers().removeIf(u -> u.getUserId().equals(userId));
        }
        if (removedFromClient || removedFromVendor) {
            return new MessageDto("El usuario con id " + userId + " ha dejado de seguir al vendedor con id " + vendorId);
        } else {
            throw new NotFoundException("Error: El usuario con id " + userId + " no está siguiendo al vendedor con id " + vendorId);
        }
    }
}
