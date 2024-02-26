package linkTracker.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class LinkDTO {
    private String url;
    private String password;
}
