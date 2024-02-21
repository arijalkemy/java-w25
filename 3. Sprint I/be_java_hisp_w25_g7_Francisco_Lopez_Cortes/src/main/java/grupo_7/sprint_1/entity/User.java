package grupo_7.sprint_1.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public abstract class User {
    Integer userId;
    String userName;
}
