package grupo_7.sprint_1.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SellerDTO{
   private   int userId;
    private String userName;
    private  int followerCount;

}
