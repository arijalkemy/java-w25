package grupo_7.sprint_1.controller;

import grupo_7.sprint_1.dtos.AddPostDto;
import grupo_7.sprint_1.dtos.PostDto;
import grupo_7.sprint_1.dtos.SellerDTO;
import grupo_7.sprint_1.dtos.SellerFollowersListDto;
import grupo_7.sprint_1.exception.NotFoundException;
import grupo_7.sprint_1.service.ISellerService;
import grupo_7.sprint_1.service.SellerServiceImp;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sellers")
public class SellerController {
    ISellerService sellerService;

    public SellerController(SellerServiceImp sellerService) {
        this.sellerService = sellerService;
    }

    // US 0002: Obtener el resultado de la cantidad de usuarios que siguen a un determinado vendedor
    @GetMapping("/users/{userId}/followers/count")
    public ResponseEntity<SellerDTO> getFollowersCount(@PathVariable int userId) {
        try {
            SellerDTO sellerDTO = sellerService.cantidadSeguidores(userId);
            return new ResponseEntity<>(sellerDTO, HttpStatus.OK);
        } catch (NotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // US 0003: Obtener un listado de todos los usuarios que siguen a un determinado vendedor (¿Quién me sigue?)
    // US 0008: Ordenamiento alfabético ascendente y descendente
    @GetMapping("/users/{userId}/followers/list")
    public ResponseEntity<SellerFollowersListDto> getFollowersList(@PathVariable Integer userId, @RequestParam String order) {

        return ResponseEntity.ok(sellerService.getListOrderedAlphabetically(userId, order));
    }

    // US 0005: Dar de alta una nueva publicación
    @PostMapping("/products/post")
    public ResponseEntity<?> addPost(@RequestBody AddPostDto newPost) {
        return new ResponseEntity<>(sellerService.addPost(newPost.userId(), newPost), HttpStatus.OK);
    }

    @GetMapping("/products/promo-post/count")
    public ResponseEntity<?> getPromoPost(@RequestParam int userId){
        return new ResponseEntity<>(sellerService.cantidadProductosPromocion(userId),HttpStatus.OK);
    }
    // US 0006: Obtener un listado de las publicaciones realizadas por los vendedores que un usuario sigue en las
    // últimas dos semanas (para esto tener en cuenta ordenamiento por fecha, publicaciones más recientes primero).
    // US 0009: Ordenamiento por fecha ascendente y descendente
    @GetMapping("/products/followed/{userId}/list")
    public ResponseEntity<List<PostDto>> getRecentPostsFromFollowedSellers(@PathVariable Integer userId, @RequestParam String order) {
        List<PostDto> posts = sellerService.getRecentPostsFromFollowedSellers(userId, order);
        return new ResponseEntity<>(posts, HttpStatus.OK);
    }

    @GetMapping("/users/allsellers")
    public ResponseEntity<?> getAllSellers() {
        return ResponseEntity.ok(sellerService.getAllSellers());
    }


    @GetMapping("/products/promo-post/list")
    public ResponseEntity<?> getPromoPostList(@RequestParam int userId){
        return new ResponseEntity<>(sellerService.listaPostsPromocion(userId),HttpStatus.OK);
    }
}
