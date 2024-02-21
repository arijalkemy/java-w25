package com.example.be_java_hisp_w25_g10.dtos;

import java.util.List;

public record PostsDto (int userId,List<PostDto> posts) { }
