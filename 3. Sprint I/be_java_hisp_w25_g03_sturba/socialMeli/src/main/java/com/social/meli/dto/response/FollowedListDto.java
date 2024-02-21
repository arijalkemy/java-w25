package com.social.meli.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;


public record FollowedListDto(@JsonProperty("user_id")
                              Integer userId,
                              @JsonProperty("user_name")
                              String userName,
                              @JsonProperty("followed")
                              List<VendorDto> followed) {


}
