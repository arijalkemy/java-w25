package org.bootcamp.javazoo.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bootcamp.javazoo.dto.PostDto;
import org.bootcamp.javazoo.dto.PostResponseDto;

import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class PostsFollowedUserDto {
    private int user_id;
    private List<PostResponseDto> posts;

}
