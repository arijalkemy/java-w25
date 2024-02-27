package com.example.be_java_hisp_w25_g11.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    @JsonProperty("user_id")
    private Integer id;
    @JsonProperty("user_name")
    private String name;
}
