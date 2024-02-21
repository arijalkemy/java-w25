package com.example.be_java_hisp_w25_g10.entities;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Follower {
    private int idFollower;
    private int idFollowed;
}