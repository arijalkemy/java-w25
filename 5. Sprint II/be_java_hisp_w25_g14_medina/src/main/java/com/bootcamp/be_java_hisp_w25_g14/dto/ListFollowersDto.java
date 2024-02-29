package com.bootcamp.be_java_hisp_w25_g14.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ListFollowersDto {

    Integer user_Id;
    String user_Name;
    List<UserDto> followers;

}
