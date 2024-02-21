package com.social.meli.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.social.meli.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VendorDto {
    @JsonProperty("user_id")
    private Integer userId;
    @JsonProperty("user_name")
    private String userName;
    public VendorDto(User user){
        this.userId = user.getId();
        this.userName = user.getName();
    }
}
