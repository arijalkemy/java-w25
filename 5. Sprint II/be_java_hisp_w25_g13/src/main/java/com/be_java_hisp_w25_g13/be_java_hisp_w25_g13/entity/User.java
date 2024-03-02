package com.be_java_hisp_w25_g13.be_java_hisp_w25_g13.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {

    public User(Integer userId, String userName){
        this.userId = userId;
        this.userName = userName;
    }

    private Integer userId;
    private String userName;
    private List<Seller> following  = new ArrayList<>();;
}
