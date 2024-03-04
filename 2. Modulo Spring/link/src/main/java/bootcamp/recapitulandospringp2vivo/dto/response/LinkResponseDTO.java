package bootcamp.recapitulandospringp2vivo.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class LinkResponseDTO {
    private String url;
    private String password;
    private Integer linkId;
    private Integer timesVisited = 0;
}
