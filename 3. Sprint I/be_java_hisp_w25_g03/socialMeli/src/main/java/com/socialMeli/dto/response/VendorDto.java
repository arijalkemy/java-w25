package com.socialMeli.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
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
}
