package grupo_7.sprint_1.controller;

import grupo_7.sprint_1.service.BuyerServiceImp;
import grupo_7.sprint_1.service.IBuyerService;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/buyers")
public class BuyerController {
    IBuyerService buyerService;

    public BuyerController(BuyerServiceImp buyerService) {
        this.buyerService = buyerService;
    }

    // US 0001: Poder realizar la acción de “Follow” (seguir) a un determinado vendedor
    @PostMapping("/users/{buyerId}/follow/{sellerId}")
    public ResponseEntity<?> followSeller(@PathVariable Integer buyerId, @PathVariable Integer sellerId) {
        return new ResponseEntity<>(buyerService.followSeller(buyerId, sellerId), HttpStatus.OK);
    }

    // US 0004: Obtener  un listado de todos los vendedores a los cuales sigue un determinado usuario (¿A quién sigo?)
    // US 0008: Ordenamiento alfabético ascendente y descendente
    @GetMapping("/users/{userid}/followed/list")
    public ResponseEntity<?> getfollowedlist(@PathVariable @NotNull Integer userid, @RequestParam @NotNull String order) {
        return new ResponseEntity<>(buyerService.getBuyerfollow(userid, order), HttpStatus.OK);
    }

    // US 0007: Poder realizar la acción de “Unfollow” (dejar de seguir) a un determinado vendedor.
    @PostMapping("/users/{userId}/unfollow/{userIdToUnfollow}")
    public ResponseEntity<?> unfollowSeller(@PathVariable int userId, @PathVariable int userIdToUnfollow) {
        return new ResponseEntity<>(buyerService.unfollowSeller(userId, userIdToUnfollow), HttpStatus.OK);
    }
}
