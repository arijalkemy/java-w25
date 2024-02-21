package grupo_7.sprint_1.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
@Data
@AllArgsConstructor
public class AddPromoPostDto{
     Integer userId;
     String date;
     ProductDto product;
     Integer category;
     Double price;
     Boolean hasPromo;
     Double discount;

    // Getters and setters
}
