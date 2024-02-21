package com.breakingbytes.be_java_hisp_w25_g04.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class ListPromoPostsDTO extends ListPostsDTO{
    @JsonProperty("user_name")
    String name;

    public ListPromoPostsDTO(int id, String name, List<ResponsePostDTO> promoPosts) {
        this.userId = id;
        this.name = name;
        this.posts = promoPosts;
    }
}

