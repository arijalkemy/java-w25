package grupo_7.sprint_1.entity;


import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class Seller extends User {
    List<Buyer> followers;
    List<Post> posts;
}
