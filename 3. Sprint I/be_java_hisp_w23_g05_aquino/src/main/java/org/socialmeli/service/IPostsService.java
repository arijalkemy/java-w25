package org.socialmeli.service;

import org.socialmeli.dto.request.FollowedListReqDto;
import org.socialmeli.dto.request.PostReqDto;
import org.socialmeli.dto.request.PromoPostReqDto;
import org.socialmeli.dto.request.UserIdDto;
import org.socialmeli.dto.response.FollowedListDto;
import org.socialmeli.dto.response.PostIdDto;
import org.socialmeli.dto.response.PromoProductsCount;

public interface IPostsService {
    FollowedListDto getFollowedList(FollowedListReqDto req);
    PostIdDto savePost(PostReqDto postDto);
    PostIdDto savePromoPost(PromoPostReqDto postDto);
    PromoProductsCount countPromoProductsFromVendor(UserIdDto userIdDto);
}
