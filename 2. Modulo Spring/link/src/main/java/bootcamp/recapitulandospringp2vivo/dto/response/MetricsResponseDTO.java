package bootcamp.recapitulandospringp2vivo.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class MetricsResponseDTO {

    private Integer timesRedirected;

}
