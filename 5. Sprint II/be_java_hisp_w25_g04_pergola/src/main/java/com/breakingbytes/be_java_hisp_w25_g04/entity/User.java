package com.breakingbytes.be_java_hisp_w25_g04.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class User {
    Integer id;
    String name;
    @JsonManagedReference
    List<Seller> following;
    public User(){
        this.following = new ArrayList<>();
    }

    public void addFollowing(Seller seller){
        this.following.add(seller);
    }

}
