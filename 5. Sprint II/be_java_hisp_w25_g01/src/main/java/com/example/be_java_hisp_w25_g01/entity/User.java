package com.example.be_java_hisp_w25_g01.entity;

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
    Integer userId;
    String userName;
    List<Integer> followed;
    List<Integer> followers;
    List<Integer> posts;

}
