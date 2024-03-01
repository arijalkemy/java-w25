package com.breakingbytes.be_java_hisp_w25_g04.service;

import com.breakingbytes.be_java_hisp_w25_g04.dto.request.UserDTO;
import com.breakingbytes.be_java_hisp_w25_g04.dto.response.ResponseDTO;
import com.breakingbytes.be_java_hisp_w25_g04.dto.response.UserFollowedDTO;
import com.breakingbytes.be_java_hisp_w25_g04.dto.response.UserFollowersDTO;
import com.breakingbytes.be_java_hisp_w25_g04.entity.Seller;
import com.breakingbytes.be_java_hisp_w25_g04.entity.User;
import com.breakingbytes.be_java_hisp_w25_g04.exception.BadRequestException;
import com.breakingbytes.be_java_hisp_w25_g04.exception.NotFoundException;
import com.breakingbytes.be_java_hisp_w25_g04.repository.ISellerRepository;
import com.breakingbytes.be_java_hisp_w25_g04.repository.IUserRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.NamingConventions;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements IUserService {
    IUserRepository userRepository;
    ISellerRepository sellerRepository;
    ModelMapper mapper = new ModelMapper();

    public UserServiceImpl(IUserRepository userRepository, ISellerRepository sellerRepository) {
        this.userRepository = userRepository;
        this.sellerRepository = sellerRepository;
        this.mapper.getConfiguration()
                .setFieldMatchingEnabled(true)
                .setFieldAccessLevel(org.modelmapper.config.Configuration.AccessLevel.PRIVATE)
                .setSourceNamingConvention(NamingConventions.JAVABEANS_MUTATOR);
    }

    /**
     * @apiNote Método utilizado para que un usuario deje de seguir a un vendedor.
     * @param userId: ID del vendedor a dejar de seguir.
     * @param userIdToUnfollow: ID del usuario que va a dejar de seguir al vendedor.
     * @return Devuelve un ResponseDTO que indica que un usuario dejó de seguir a un vendedor.
     */
    @Override
    public ResponseDTO unfollowUser(Integer userId, Integer userIdToUnfollow) {

        Optional<User> userOpt = userRepository.findById(userId);
        if(userOpt.isEmpty()) {
            throw new NotFoundException("Usuario no encontrado.");
        }

        User user = userOpt.get();
        List<Seller> userFollowings = user.getFollowing();
        Optional<Seller> userToUnfollowOpt = userFollowings
                                                    .stream()
                                                    .filter(us -> Objects.equals(us.getId(), userIdToUnfollow))
                                                    .findFirst();

        if(userToUnfollowOpt.isEmpty()) {
            throw new NotFoundException("El usuario que se quiere dejar de seguir no fue encontrado en los seguidos.");
        }

        Seller sellerToUnfollow = userToUnfollowOpt.get();
        userFollowings.remove(sellerToUnfollow);
        userRepository.setUserFollowings(userId, userFollowings);

        return new ResponseDTO("El usuario " + user.getName() + " ha dejado de seguir a: " + sellerToUnfollow.getName());
    }

    /**
     * @apiNote Metodo utilizado para devolver una lista de los seguidores que tiene un vendedor
     * @param userId: Id del usuario vendedor
     * @param order: Tipo de orden para ver los usuarios que siguen al vendedor. Puede ser name_asc, name_desc o sin orden
     * @return Retorna la informacion del vendedor con la lista de usuarios que lo siguen.
     */
    @Override
    public UserFollowersDTO getUsersFollowersOf(Integer userId, String order) {
        // Busco si existe el id del vendedor
        Optional<Seller> user = this.sellerRepository.findById(userId);
        if(user.isEmpty()) throw new NotFoundException("El ID del vendedor es invalido");
        // Obtengo los usuarios que lo siguen
        List<User> userFollowes = user.get().getFollowers();
        if(userFollowes.isEmpty()) throw new NotFoundException("El usuario con id: " + user.get().getId() + " no tiene seguidores");
        List<UserDTO> followers = userFollowes.stream().map(u -> mapper.map(u, UserDTO.class)).toList();
        // Ordeno la lista y devuelvo la informacion necesaria
        return new UserFollowersDTO(user.get().getId(), user.get().getName(), ordenarUsuariosPorNombre(followers, order));
    }
    /**
     * @apiNote Metodo utilizado para devolver una lista de los usuarios que sigue un usuario
     * @param userId: Id del usuario, puede ser vendedor o un usuario normal
     * @param order: Tipo de orden para ver los usuarios a los que sigue un usuario. Puede ser name_asc, name_desc o sin orden
     * @return Retorna la informacion del usurio con la lista de usuarios a los que sigue.
     */
    @Override
    public UserFollowedDTO getUsersFollowed(Integer userId, String order) {
        // Busco por id tanto en usuarios como en vendedores, ya que ambos pueden seguir a otros usuarios
        Optional<User> me = this.userRepository.findById(userId);
        Optional<Seller> seller = this.sellerRepository.findById(userId);
        User user;
        // Me fijo si esta presente y lo guardo en la variable user
        if(seller.isPresent()) user = seller.get();
        else if(me.isPresent()) user = me.get();
        else throw new NotFoundException("ID de usuario invalido");
        // Traigo los usuarios a los que sigue
        List<Seller> userFolloweds = user.getFollowing();
        if(userFolloweds.isEmpty()) throw new NotFoundException("El usuario con id: " + user.getId() + " no sigue a vendedores");
        List<UserDTO> followed = userFolloweds.stream().map(u -> mapper.map(u, UserDTO.class)).toList();
        // Los ordeno y devuelvo la informacion necesaria
        return new UserFollowedDTO(user.getId(), user.getName(), ordenarUsuariosPorNombre(followed, order));
    }

    // Metodo para ordenar los usuarios por nombre
    private List<UserDTO> ordenarUsuariosPorNombre (List<UserDTO> users, String order) {
        if (order.equals("name_asc")){
            users = users.stream()
                    .sorted(Comparator.comparing(UserDTO::getName))
                    .collect(Collectors.toList());
        }else if(order.equals("name_desc")){
            users = users.stream()
                    .sorted(Comparator.comparing(UserDTO::getName, Comparator.reverseOrder()))
                    .collect(Collectors.toList());
        } // En caso de que no se mande un orden, se manda la lista desordenada
        // En caso de que venga un orden invalido, se lanza una excepcion
        else if(!order.isEmpty()) throw new BadRequestException("El tipo de ordenamiento alfabetico es incorrecto");
        return users;
    }

    /**
     * @apiNote Metodo para que un usuario siga a un vendedor
     * @param userId: Id del usuario
     * @param userIdToFollow: Id del vendedor
     * @return Retorna un 202 sin body
     */
    @Override
    public void follow(Integer userId, Integer userIdToFollow) {
        Optional<User> me = this.userRepository.findById(userId);
        Optional<Seller> userToFollow = this.sellerRepository.findById(userIdToFollow);

        if (me.isEmpty()) throw new NotFoundException("Ususario no encontrado");
        if (userToFollow.isEmpty()) throw new NotFoundException("Vendedor no encontrado");

        if (userToFollow.get().getFollowers().contains(me.get()))
            throw new BadRequestException("Ya estas siguiendo a ese usuario");

        this.sellerRepository.addFollower(userToFollow.get(), me.get());
        this.userRepository.addFollowing(me.get(), userToFollow.get());
    }
}
