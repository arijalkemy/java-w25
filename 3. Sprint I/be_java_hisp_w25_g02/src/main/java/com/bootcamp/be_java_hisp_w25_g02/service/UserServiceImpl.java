package com.bootcamp.be_java_hisp_w25_g02.service;

import com.bootcamp.be_java_hisp_w25_g02.dto.response.FollowerListDTO;
import com.bootcamp.be_java_hisp_w25_g02.dto.response.UserDTO;
import com.bootcamp.be_java_hisp_w25_g02.dto.response.UserFollowingDTO;
import com.bootcamp.be_java_hisp_w25_g02.entity.User;
import com.bootcamp.be_java_hisp_w25_g02.exception.BadRequestException;
import com.bootcamp.be_java_hisp_w25_g02.exception.NotFoundException;

import com.bootcamp.be_java_hisp_w25_g02.repository.IUserRepository;
import com.bootcamp.be_java_hisp_w25_g02.repository.UserRepositoryImpl;
import org.springframework.stereotype.Service;
import com.bootcamp.be_java_hisp_w25_g02.dto.response.FollowerCountDTO;

import java.util.Comparator;
import java.util.List;

import java.util.Objects;
import java.util.Optional;

@Service
public class UserServiceImpl implements IUserService{
    private IUserRepository userRepository;

    public UserServiceImpl(UserRepositoryImpl userRepository){
        this.userRepository = userRepository;
    }
    @Override
    public boolean existUser(Integer id) {
        Optional<User> user= userRepository.findById(id);
        return user.isPresent();
    }
    @Override
    public FollowerCountDTO getUserTotalFollowers(Integer id) {
        Optional<User> user = userRepository.findById(id);
        if(user.isPresent()){
            return new FollowerCountDTO(user.get().getUser_id(),
                    user.get().getUser_name(),
                    user.get().getFollowing().stream().count());
        } else {
            throw new BadRequestException("No encontrado el user con ese ID");
        }
    }

    @Override
    public boolean isSeller(Integer id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent() && user.get().getSeller()) {
            return true;
        } else {
            return false;
        }
    }
    @Override
    public List<Integer> getFollowedUsersId(Integer userId) {
        Optional<User> user = this.userRepository.findById(userId);
        if (user.isEmpty()) {
            throw new NotFoundException("El usuario no existe");
        }
        return user.get().getFollowing();
    }

    @Override
    public UserFollowingDTO getFollowedSellers(Integer userId, String order) {
        Optional<User> user = userRepository.findById(userId);
        List<UserDTO> followingUserIdList;

        if (user.isPresent() && !user.get().getSeller()) {
            followingUserIdList = user.get().getFollowing().stream()
                    .map(userRepository::findById)
                        .map(usr -> new UserDTO(usr.get().getUser_id(), usr.get().getUser_name())).toList();
            if (order != null && order.equalsIgnoreCase("name_asc")) {
                followingUserIdList = followingUserIdList.stream().sorted(Comparator.comparing(UserDTO::user_name)).toList();
            }
            if (order != null && order.equalsIgnoreCase("name_desc")) {
                followingUserIdList = followingUserIdList.stream().sorted(Comparator.comparing(UserDTO::user_name).reversed()).toList();
            }
            return new UserFollowingDTO(user.get().getUser_id(), user.get().getUser_name(), followingUserIdList);
        } else {
            throw new NotFoundException("El usuario solicitado no fue encontrado.");
        }
    }

    @Override
    public void followUser(Integer userId, Integer userIdToFollow) {
        Optional<User> optionalUser = this.userRepository.findById(userId);
        Optional<User> optionalUserToFollow = this.userRepository.findById(userIdToFollow);

        if (optionalUser.isPresent() && optionalUserToFollow.isPresent()) {
            User user = optionalUser.get();
            User userToFollow = optionalUserToFollow.get();

            if (!userToFollow.getSeller()) {
                throw new BadRequestException("No puede seguir al usuario porque no es vendedor");
            } else {
                user.getFollowing().add(userIdToFollow);
            }

        } else {
            throw new BadRequestException("El id ingresado es inválido");
        }
    }

    @Override
    public void unfollowUser(Integer userId, Integer userIdToUnfollow) {

        Optional<User> optionalUser = this.userRepository.findById(userId);
        Optional<User> userToUnfollow = this.userRepository.findById(userIdToUnfollow);

        if (optionalUser.isPresent() && userToUnfollow.isPresent()) {
            User user = optionalUser.get();
            user.getFollowing().remove(userIdToUnfollow);
        } else {
            throw new BadRequestException("El id ingresado es inválido");
        }
    }

    @Override
    public FollowerListDTO getFollowersList(Integer userId, String order) {
        Optional<User> user = userRepository.findById(userId);
        if (user.isEmpty()) throw new NotFoundException("No hay usuario asociado a esa ID");
        if (!user.get().getSeller()) throw new BadRequestException("Este usuario no es vendedor, no puede poseer seguidores.");
        List<Integer> followersIdList = user.get().getFollowedBy();
        if (followersIdList.isEmpty()) throw new NotFoundException("El usuario no posee seguidores");
        List<UserDTO> followersList = followersIdList.stream().map(userRepository::findById)
                .map(userA -> new UserDTO(userA.get().getUser_id(), userA.get().getUser_name())).toList();
        // Aquí lógica de ordenamiento si hay orden
        if (order != null && order.equalsIgnoreCase("name_asc")){
            followersList = followersList.stream().sorted(Comparator.comparing(UserDTO::user_name)).toList();
        }
        if (order != null && order.equalsIgnoreCase("name_desc")){
            followersList = followersList.stream().sorted(Comparator.comparing(UserDTO::user_name).reversed()).toList();
        }
        FollowerListDTO ansDTO = new FollowerListDTO(userId, user.get().getUser_name(), followersList);
        return ansDTO;
    }

    public UserDTO userToUserDto(User user) {
        return new UserDTO(user.getUser_id(), user.getUser_name());
    }
}
