package link_tracker.entities;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Link {

    private String linkURL;
    private int linkId;
    private boolean isActive;
    private int amountOfRedirects;

    public Link(String linkURL, int linkId) {
        this.linkURL = linkURL;
        this.linkId = linkId;
        this.isActive = true;
        this.amountOfRedirects = 0;
    }
}
