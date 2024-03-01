package com.bootcamp.be_java_hisp_w25_g14.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDataDto {

    private Integer user_id;
    private String user_name;
}
