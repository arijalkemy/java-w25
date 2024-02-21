package com.bootcamp.be_java_hisp_w25_g14.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserFollowersCountDto {
    Integer user_id;
    String user_name;
    Integer followers_count;
}
