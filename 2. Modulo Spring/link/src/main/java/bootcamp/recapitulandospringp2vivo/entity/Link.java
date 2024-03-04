package bootcamp.recapitulandospringp2vivo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Link {

    private String url;
    private String password;
    private Integer linkId;
    @Builder.Default
    private Integer timesVisited = 0;
    @Builder.Default
    private boolean valid = true;

}
