package com.bootcamp.be_java_hisp_w25_g02.entity;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class User {
    Integer user_id;
    String user_name;
    Boolean seller;
    List<Integer> following;
    List<Integer> followedBy;
}