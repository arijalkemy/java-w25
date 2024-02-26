package org.example.linktracker.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Link {
    private long id;
    private String password;
    private String link;
    private int redirectTimes;
    private boolean validate;

    public void redirect(){
        this.redirectTimes += 1;
    }

    public boolean invalidate(){
        this.validate = !this.validate;
        return this.validate;
    }

}
