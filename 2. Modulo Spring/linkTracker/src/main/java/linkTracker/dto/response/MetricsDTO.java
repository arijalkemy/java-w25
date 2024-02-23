package linkTracker.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class MetricsDTO {
    private int linkId;
    private int redirectCounter;
}
