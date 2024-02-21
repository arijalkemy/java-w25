package link_tracker.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Link {
    Long id;
    String url;
    String password;
    Integer metrics;
    boolean isValid;
}
