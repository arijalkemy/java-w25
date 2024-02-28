package grupo_7.sprint_1.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.List;

@NoArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class Buyer extends User {
    List<Seller> followed;

    public Buyer(List<Seller> followed) {
        this.followed = followed;
    }

    public Buyer(Integer userId, String userName, List<Seller> followed) {
        super(userId, userName);
        this.followed = followed;
    }
}
