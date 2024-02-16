package com.linktracker.linktracker.entity;

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
    int id;
    String uri;
    boolean valido;
    int visitas; //ver si lo dejamos aca o no
    String password;

}
