package com.grupo08.socialmeli.dto.response;

import com.grupo08.socialmeli.entity.Post;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PromoPostListDTO {
    private int user_id;
    private String user_name;
    private List<Post> posts;
}
