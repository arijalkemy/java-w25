package org.socialmeli.service;

import org.socialmeli.dto.request.FollowedListReqDto;
import org.socialmeli.dto.request.PostDiscountReqDto;
import org.socialmeli.dto.request.PostReqDto;
import org.socialmeli.dto.request.UserIdDto;
import org.socialmeli.dto.response.DiscountCountDto;
import org.socialmeli.dto.response.FollowedListDto;
import org.socialmeli.dto.response.PostIdDto;
import org.socialmeli.dto.response.PromoListResDto;

public interface IPostsService {
    public FollowedListDto getFollowedList(FollowedListReqDto req);

    public PostIdDto savePost(PostReqDto postDto);

    // US_0010
    public PostIdDto savePostDiscount(PostDiscountReqDto postDiscountReqDto);

    // US_0011
    public DiscountCountDto vendorProductsDiscountCount(UserIdDto userId);

    // US_0012
    public PromoListResDto vendorProductsDiscountList(UserIdDto userId);

}
