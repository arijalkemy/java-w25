package com.example.be_java_hisp_w25_g11.dto.response;

import com.example.be_java_hisp_w25_g11.dto.UserDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FollowedDTO {
    private Integer id;
    private String name;
    private List<UserDTO> followed;
}