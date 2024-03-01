package com.example.be_java_hisp_w25_g10.entities;

import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

@Data
@AllArgsConstructor
@Validated
public class Follower {

    @Positive
    private int idFollower;
    @Positive
    private int idFollowed;
}