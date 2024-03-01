package org.example.recapitulandospringp2vivo.models;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Link {
    private String link;
    private String pass;
    private int redirections;
    private boolean valid;

    public boolean getValid(){
        return this.valid;
    }
}
