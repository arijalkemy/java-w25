package grupo_7.sprint_1.controller;

import grupo_7.sprint_1.dto.*;
import grupo_7.sprint_1.exception.NotFoundException;
import grupo_7.sprint_1.service.SellerServiceImp;
import grupo_7.sprint_1.service.inter.ISellerService;
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
    @GetMapping("/users/{sellerId}/followers/count")
    public ResponseEntity<?> getFollowersCount(@PathVariable Integer sellerId) {
        try {
            SellerDto sellerDTO = sellerService.cantidadSeguidores(sellerId);
            return new ResponseEntity<>(sellerDTO, HttpStatus.OK);
        } catch (NotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // US 0003: Obtener un listado de todos los usuarios que siguen a un determinado vendedor (¿Quién me sigue?)
    // US 0008: Ordenamiento alfabético ascendente y descendente
    @GetMapping("/users/{sellerId}/followers/list")
    public ResponseEntity<?> getFollowersList(@PathVariable Integer sellerId, @RequestParam String order) {
        return ResponseEntity.ok(sellerService.getListOrderedAlphabetically(sellerId, order));
    }

    // US 0005: Dar de alta una nueva publicación
    // US 0010: Llevar a cabo la publicación de un nuevo producto en promoción
    @PostMapping("/products/post")
    public ResponseEntity<?> addPost(@RequestBody AddPostDto newPost) {
        return new ResponseEntity<>(sellerService.addPost(newPost.userId(), newPost), HttpStatus.OK);
    }

    // US 0006: Obtener un listado de las publicaciones realizadas por los vendedores que un usuario sigue en las
    // últimas dos semanas (para esto tener en cuenta ordenamiento por fecha, publicaciones más recientes primero).
    // US 0009: Ordenamiento por fecha ascendente y descendente
    @GetMapping("/products/followed/{sellerId}/list")
    public ResponseEntity<?> getRecentPostsFromFollowedSellers(@PathVariable Integer sellerId, @RequestParam String order) {
        List<PostDto> posts = sellerService.getRecentPostsFromFollowedSellers(sellerId, order);
        return new ResponseEntity<>(posts, HttpStatus.OK);
    }

    // US 0011: Obtener la cantidad de productos en promoción de un determinado vendedor
    @GetMapping("/products/promo-post/count")
    public ResponseEntity<?> countSellerPromos(@RequestParam(name = "seller_id") Integer sellerId) {
        try {
            SellerPromosListDto sellerDTO = sellerService.getSellerPromosCount(sellerId);
            return new ResponseEntity<>(sellerDTO, HttpStatus.OK);
        } catch (NotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // US 0012: Obtener un listado de todos los productos en promoción de un determinado vendedor
    @GetMapping("/products/promo-post/list")
    public ResponseEntity<?> getPromoPostsBySeller(@RequestParam(name = "seller_id") Integer sellerId) {
        SellerPromosDto seller = sellerService.getPromoPostsBySeller(sellerId);
        return new ResponseEntity<>(seller, HttpStatus.OK);
    }

    /*@GetMapping("/users/allsellers")
    public ResponseEntity<?> getAllSellers() {
        return ResponseEntity.ok(sellerService.getAllSellers());
    }*/

}
