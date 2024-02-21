package org.socialmeli.service;

import org.socialmeli.dto.request.FollowedListReqDto;
import org.socialmeli.dto.request.post.BasePostReqDto;
import org.socialmeli.dto.request.post.PostReqDto;
import org.socialmeli.dto.request.post.PromoPostReqDto;
import org.socialmeli.dto.response.FollowedListDto;
import org.socialmeli.dto.response.post.PostIdDto;
import org.socialmeli.dto.response.post.PromoPostCountDto;

public interface IPostsService {
    public FollowedListDto getFollowedList(FollowedListReqDto req);

    PostIdDto savePost(BasePostReqDto postReqDto);

    PromoPostCountDto countPromoPosts(Integer user_id);
}
