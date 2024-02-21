package org.socialmeli.service;

import org.socialmeli.dto.request.FollowedListReqDto;
import org.socialmeli.dto.request.PostPromoReqDto;
import org.socialmeli.dto.request.PostReqDto;
import org.socialmeli.dto.response.FollowedListDto;
import org.socialmeli.dto.response.PostIdDto;
import org.socialmeli.dto.response.PromoCountDto;

public interface IPostsService {
    public FollowedListDto getFollowedList(FollowedListReqDto req);
    public PostIdDto savePost(PostReqDto postDto);

    public PostIdDto savePromo(PostPromoReqDto promoDto);

    PromoCountDto vendorPromoProductsCount(PromoCountDto promoCountDto);


}
