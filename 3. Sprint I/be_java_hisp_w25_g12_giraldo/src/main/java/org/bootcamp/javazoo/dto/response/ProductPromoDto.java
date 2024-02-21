package org.bootcamp.javazoo.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.bootcamp.javazoo.dto.PostResponseDto;
import org.bootcamp.javazoo.entity.Post;

import java.util.List;

@AllArgsConstructor
@Data
public class ProductPromoDto {

    private int user_id;
    private String user_name;
    private List<PostResponseDto> posts;

}
