package linkTracker.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter
public class Link {
    private Integer linkId;
    private String url;
    private String password;
    private Integer count;
    private boolean isActive;
}
