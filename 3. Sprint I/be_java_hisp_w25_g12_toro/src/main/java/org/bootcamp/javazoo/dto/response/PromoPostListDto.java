package org.bootcamp.javazoo.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bootcamp.javazoo.dto.PostResponseDto;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PromoPostListDto {
    private Integer user_id;
    private String user_name;
    private List<PostResponseDto> posts;
}
