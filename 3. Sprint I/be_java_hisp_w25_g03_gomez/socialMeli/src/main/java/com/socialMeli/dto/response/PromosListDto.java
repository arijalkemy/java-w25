package com.socialMeli.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.socialMeli.dto.request.PromoPostDto;
import com.socialMeli.entity.User;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PromosListDto {
    @JsonProperty("user_id")
    Integer userId;
    @JsonProperty("user_name")
    String userName;
    @JsonProperty("posts")
    List<PromoPostDto> promos;

    public PromosListDto(User user, List<PromoPostDto> promoPosts) {
        this.userId = user.getId();
        this.userName = user.getName();
        this.promos  = promoPosts;
    }
}
