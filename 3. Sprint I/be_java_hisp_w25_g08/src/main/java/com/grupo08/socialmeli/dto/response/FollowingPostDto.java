package com.grupo08.socialmeli.dto.response;

import com.grupo08.socialmeli.dto.PostDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FollowingPostDto {
    Long User_id;
    List<PostDto> post;
}
