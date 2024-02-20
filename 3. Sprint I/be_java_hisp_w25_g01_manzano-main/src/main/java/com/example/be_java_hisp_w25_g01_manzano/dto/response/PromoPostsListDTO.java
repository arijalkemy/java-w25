package com.example.be_java_hisp_w25_g01_manzano.dto.response;


import com.example.be_java_hisp_w25_g01_manzano.dto.request.PromoPostDTO;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PromoPostsListDTO
{
    int user_id;
    List<PromoPostDTO> postsList;
}
