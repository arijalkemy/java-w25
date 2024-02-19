package com.mercadolibre.linktracker.entity;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Link {
    String link;
    Integer counter;
    Boolean active;
    String password;

    public void increseCounter(){
        this.counter++;
    }
}
