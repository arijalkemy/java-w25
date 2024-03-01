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
            return new FollowerCountDTO(user.get().getUserId(),
                    user.get().getUserName(),
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
    public UserDTO makeSeller(Integer id) {
        Optional<User> user = this.userRepository.findById(id);
        user.ifPresent(value -> value.setSeller(true));
        return userToUserDto(user.get());
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
                    .map(usr -> new UserDTO(usr.get().getUserId(), usr.get().getUserName())).toList();
            if (order != null && order.equalsIgnoreCase("name_asc")) {
                followingUserIdList = followingUserIdList.stream().sorted(Comparator.comparing(UserDTO::userName)).toList();
            }
            if (order != null && order.equalsIgnoreCase("name_desc")) {
                followingUserIdList = followingUserIdList.stream().sorted(Comparator.comparing(UserDTO::userName).reversed()).toList();
            }
            if (order != null && !order.equalsIgnoreCase("name_asc") && !order.equalsIgnoreCase("name_desc")) {
                throw new BadRequestException("El valor de ordenamiento '" + order + "' no es válido. Los valores permitidos son: 'name_asc' y 'name_desc'.");
            }
            return new UserFollowingDTO(user.get().getUserId(), user.get().getUserName(), followingUserIdList);
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

        // Excepciones en caso de que el parámetro no coincida (ignorecase) con "name_asc" o "name_desc"
        if (order != null && !order.equalsIgnoreCase("name_asc") && !order.equalsIgnoreCase("name_desc")){
            throw new BadRequestException("El valor de ordenamiento '" + order + "' no es válido. Los valores permitidos son: 'name_asc' y 'name_desc'.");
        }
        Optional<User> user = userRepository.findById(userId);
        if (user.isEmpty()) throw new NotFoundException("No hay usuario asociado a esa ID");
        if (!user.get().getSeller()) throw new BadRequestException("Este usuario no es vendedor, no puede poseer seguidores.");
        List<Integer> followersIdList = user.get().getFollowedBy();
        if (followersIdList.isEmpty()) throw new NotFoundException("El usuario no posee seguidores");
        List<UserDTO> followersList = followersIdList.stream().map(userRepository::findById)
                .map(userA -> new UserDTO(userA.get().getUserId(), userA.get().getUserName())).toList();

        // Aquí lógica de ordenamiento
        // Lógica de ordenamiento asc y desc.
        if (order != null) {
            if (order.equalsIgnoreCase("name_asc")){
                followersList = followersList.stream().sorted(Comparator.comparing(UserDTO::userName)).toList();
            }
            if (order.equalsIgnoreCase("name_desc")){
                followersList = followersList.stream().sorted(Comparator.comparing(UserDTO::userName).reversed()).toList();
            }
        }
        FollowerListDTO ansDTO = new FollowerListDTO(userId, user.get().getUserName(), followersList);
        return ansDTO;
    }

    public UserDTO userToUserDto(User user) {
        return new UserDTO(user.getUserId(), user.getUserName());
    }
}
