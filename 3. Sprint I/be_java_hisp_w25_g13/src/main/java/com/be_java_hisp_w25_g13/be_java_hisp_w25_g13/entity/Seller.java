package com.be_java_hisp_w25_g13.be_java_hisp_w25_g13.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Seller extends User{

    public Seller(Integer userId, String userName){
        super(userId, userName);
    }

    public Seller(Integer userId, String userName, List<User> followers) {
        super(userId, userName);
        Followers = followers;
    }
    private List<User> Followers = new ArrayList<>();
}
