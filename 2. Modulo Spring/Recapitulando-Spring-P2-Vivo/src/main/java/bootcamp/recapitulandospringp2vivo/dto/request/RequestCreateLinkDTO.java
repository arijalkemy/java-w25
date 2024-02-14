package bootcamp.recapitulandospringp2vivo.dto.request;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RequestCreateLinkDTO {
    private String url;
    private String password;
}
