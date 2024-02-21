package com.breakingbytes.be_java_hisp_w25_g04.dto.response;

import com.breakingbytes.be_java_hisp_w25_g04.entity.Post;
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
public class PromoPostDTO {
    int userId;
    String userName;
    List<Post> posts;


}
