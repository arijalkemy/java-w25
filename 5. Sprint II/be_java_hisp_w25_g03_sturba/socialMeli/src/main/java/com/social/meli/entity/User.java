package com.social.meli.entity;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
public class User {
    Integer id;
    String name;
    List<Integer> followersId;
    List<Integer> followedId;
    UserType type;
}
