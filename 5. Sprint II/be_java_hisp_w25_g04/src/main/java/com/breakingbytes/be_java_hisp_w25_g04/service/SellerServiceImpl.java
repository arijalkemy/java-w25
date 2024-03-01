package com.breakingbytes.be_java_hisp_w25_g04.service;

import com.breakingbytes.be_java_hisp_w25_g04.dto.request.RequestPostDTO;
import com.breakingbytes.be_java_hisp_w25_g04.dto.response.FollowersCountDTO;
import com.breakingbytes.be_java_hisp_w25_g04.dto.response.LastPostsDTO;
import com.breakingbytes.be_java_hisp_w25_g04.dto.response.ResponsePostDTO;
import com.breakingbytes.be_java_hisp_w25_g04.entity.Post;
import com.breakingbytes.be_java_hisp_w25_g04.entity.Product;
import com.breakingbytes.be_java_hisp_w25_g04.entity.Seller;
import com.breakingbytes.be_java_hisp_w25_g04.entity.User;
import com.breakingbytes.be_java_hisp_w25_g04.exception.BadRequestException;
import com.breakingbytes.be_java_hisp_w25_g04.exception.NotFoundException;
import com.breakingbytes.be_java_hisp_w25_g04.repository.IPostRepository;
import com.breakingbytes.be_java_hisp_w25_g04.repository.IProductRepository;
import com.breakingbytes.be_java_hisp_w25_g04.repository.ISellerRepository;
import com.breakingbytes.be_java_hisp_w25_g04.repository.IUserRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.NamingConventions;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;

@Service
public class SellerServiceImpl implements ISellerService{
    ISellerRepository sellerRepository;
    ModelMapper mapper = new ModelMapper();
    IPostRepository postRepository;
    IProductRepository productRepository;
    IUserRepository userRepository;

    public SellerServiceImpl(ISellerRepository sellerRepository, IPostRepository postRepository, IProductRepository productRepository, IUserRepository iUserRepository) {
        this.sellerRepository = sellerRepository;
        this.postRepository = postRepository;
        this.productRepository = productRepository;
        this.userRepository = iUserRepository;

        //Configuracion del mapper
        this.mapper.getConfiguration()
                .setFieldMatchingEnabled(true)
                .setFieldAccessLevel(org.modelmapper.config.Configuration.AccessLevel.PRIVATE)
                .setSourceNamingConvention(NamingConventions.JAVABEANS_MUTATOR);
    }
    /**
     * @apiNote Método utilizado para agregar una publicación.
     * @param requestPostDTO Objeto RequestPostDTO que contiene los datos de la publicación a agregar.
     * @throws NotFoundException Si no se encuentra un vendedor con el ID proporcionado.
     * @throws BadRequestException Si ya existe un producto con el ID proporcionado.
     */
    @Override
    public void addPost(RequestPostDTO requestPostDTO) {
        Post post = mapper.map(requestPostDTO, Post.class);
        Optional<Seller> seller = sellerRepository.findById(requestPostDTO.getUserId());
        if (seller.isEmpty()) throw new NotFoundException("No se ha encontrado un vendedor con ese ID");
        Optional<Product> product = productRepository.findAll().stream()
                .filter(p -> Objects.equals(p.getId(), requestPostDTO.getProduct().getId()))
                .findFirst();
        if (product.isPresent()) throw new BadRequestException("Ya existe un producto con ese ID");
        sellerRepository.addPost(post, seller.get());
    }

    /**
     *
     * @apiNote Metodo Extra
     * @return Devuelve una lista de todos los posts
     *
     * */
    @Override
    public List<RequestPostDTO> findAllPosts() {
        return postRepository.findAll()
                .stream().map(p -> mapper.map(p, RequestPostDTO.class)).toList();
    }

    /**
     * @apiNote Método utilizado para que un vendedor quite de sus seguidores a un usuario.
     * @param sellerId: ID del vendedor.
     * @param userId: ID del usuario.
     * @return Devuelve un booleano que indica si se ejecutó el metodo.
     */
    public Boolean quitFollower(Integer sellerId, Integer userId) {

        Optional<Seller> sellerOpt = sellerRepository.findById(sellerId);
        if(sellerOpt.isEmpty()) {
            throw new NotFoundException("No se ha encontrado vendedor con id: " + sellerId);
        }

        Seller seller = sellerOpt.get();
        List<User> sellerFollowers = seller.getFollowers();
        Optional<User> userUnfollowedOpt = sellerFollowers
                                                .stream()
                                                .filter(u -> Objects.equals(u.getId(), userId))
                                                .findFirst();
        if(userUnfollowedOpt.isEmpty()) {
            throw new NotFoundException("El usuario no se encuentra entre los seguidores.");
        }

        User user = userUnfollowedOpt.get();
        sellerFollowers.remove(user);
        sellerRepository.setSellerFollowers(sellerId, sellerFollowers);

        return true;
    }

    /**
     * @apiNote Metodo utilizado para filtrar los Posts de los vendedores que sigue el usuario
     * que se hayan realizado hace menos de 2 semanas
     * @param id Identificador del Usuario a consultar
     * @param order Ordenamiento de Fechas, valores posibles: date_asc, date_desc y ""
     * @return Devuelve LastPostsDTO que contine al usuario y al listado de los post de los vendedores filtrados por fecha
     */
    @Override
    public LastPostsDTO getPostOfVendorsFollowedByUser(Integer id, String order) {
        //Se busca el usuario en la DB
        Optional<User> opt = this.userRepository.findById(id);
        //De no se encontrado se lanza excepcion
        if (opt.isEmpty()) throw new NotFoundException("No se encuentra el id buscado");
        User user = opt.get();
        List<ResponsePostDTO> posts = new ArrayList<>();;
        //Se recorre a los vendedore que sigue el usuario
        for (Seller s : user.getFollowing()) {
            //Se recorren las publicaciones de cada vendedor
            for (Post p : s.getPosts()) {
                //Se seleccionan aquellas que tienen menos de 2 semanas de antiguedad
                if (!p.getDate().isBefore(LocalDate.now().minusWeeks(2))) {
                    //Se crea respuesta en caso de cumplir el requisito
                    ResponsePostDTO responsePostDTO = mapper.map(p, ResponsePostDTO.class);
                    responsePostDTO.setUserId(s.getId());
                    posts.add(responsePostDTO);
                }
            }
        }
        //En caso de que no existan publicaciones que tengan menor antiguedad a 2 semanas
        //Se lanza una excepcion para indicarlo
        if (posts.isEmpty()) throw new NotFoundException("No hay publicaciones que cumplan con el requisito");
        ordenarPostsPorFecha(posts, order); //Se ordena la lista de acuerdo el parametro de ordenamiento
        return new LastPostsDTO(user.getId(), posts);
    }

    /**
     * Ordena la lista de acuerdo al parámetro de ordenamiento pasado
     * @param posts = "Lista de posts DTO"
     * @param order = "Ordenamiento de posts", pueden ser de tipo date_asc, "date_desc" y ""
     */
    private void ordenarPostsPorFecha (List<ResponsePostDTO> posts, String order) {
        switch (order) {
            case "date_asc" -> posts.sort(Comparator.comparing(ResponsePostDTO::getDate));
            case "date_desc" -> posts.sort(Comparator.comparing(ResponsePostDTO::getDate).reversed());
            default -> {
                if (!order.isEmpty()) throw new BadRequestException("El tipo de ordenamiento por fecha es incorrecto");
            }
        }
    }

    /**
     *
     * @apiNote Metodo que recibe el id del vendedor y devuelve la cantidad de seguidores que tiene
     * @param id ID del vendedor para calcular la cantidad de seguidores
     * @return Devuelve la cantidad de seguidores del vendedor ingresado
     *
     * */
    @Override
    public FollowersCountDTO getCountFollowersOfSeller(Integer id){
        Optional<Seller> seller = sellerRepository.findById(id);
        if(seller.isEmpty()) throw new NotFoundException("ID de usuario invalido");
        return new FollowersCountDTO(seller.get().getId(), seller.get().getName(), seller.get().getFollowers().size());
    }
}
