package com.breakingbytes.be_java_hisp_w25_g04.dto.response;

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
public class ListPostsDTO {
    int userId; //Id of User
    List<ResponsePostDTO> posts; //Posts of Sellers that user follows
}

