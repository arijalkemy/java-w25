package com.bootcamp.be_java_hisp_w25_g9.model;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level= AccessLevel.PRIVATE)
public class Client extends User{
    public Client(int userId, String userName){
        super(userId, userName);
    }
}
