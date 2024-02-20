package linkTracker.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class InvalidatedDTO {
    private int linkId;
    private boolean isInvalidated;
    private String url;
}
