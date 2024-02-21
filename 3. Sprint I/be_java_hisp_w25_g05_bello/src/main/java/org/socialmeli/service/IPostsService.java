package org.socialmeli.service;

import org.socialmeli.dto.request.FollowedListReqDto;
import org.socialmeli.dto.request.PostReqDto;
import org.socialmeli.dto.request.UserIdDto;
import org.socialmeli.dto.response.FollowedListDto;
import org.socialmeli.dto.response.PostIdDto;
import org.socialmeli.dto.response.VendorPromoPostCounterDto;
import org.socialmeli.dto.response.VendorPromoPostsDto;

public interface IPostsService {
    public FollowedListDto getFollowedList(FollowedListReqDto req);
    public PostIdDto savePost(PostReqDto postDto);
    public VendorPromoPostsDto getVendorPromoPosts(UserIdDto userIdDto);
    public VendorPromoPostCounterDto getVendorPromoPostCounter(UserIdDto userIdDto);
}
