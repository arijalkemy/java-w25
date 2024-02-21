package com.example.bootcampsprint1g6.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDTO {

    @JsonProperty("user_id")
    private Integer id;
    @JsonProperty("user_name")
    private String userName;
}
