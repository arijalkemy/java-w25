package bootcamp.recapitulandospringp2vivo.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class InvalidateLinkResponseDto {

    private Integer linkId;
    @Builder.Default
    private boolean invalidated = true;

}
