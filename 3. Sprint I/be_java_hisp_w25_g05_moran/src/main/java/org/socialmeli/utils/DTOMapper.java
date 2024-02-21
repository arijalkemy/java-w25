package org.socialmeli.utils;

import org.socialmeli.dto.request.post.BasePostReqDto;
import org.socialmeli.dto.request.post.PostReqDto;
import org.socialmeli.dto.request.post.PromoPostReqDto;
import org.socialmeli.dto.response.UserDTO;
import org.socialmeli.dto.response.VendorFollowersListDTO;
import org.socialmeli.dto.response.VendorsFollowingListDto;
import org.socialmeli.entity.Post;
import org.socialmeli.entity.User;
import org.socialmeli.entity.Vendor;

import java.util.List;

public final class DTOMapper {
    public static VendorsFollowingListDto toVendorsFollowingList(Integer userId, String userName, List<Vendor> vendors) {
        List<UserDTO> vendorsNew = vendors
                .stream()
                .map(u -> new UserDTO(u.getUserId(), u.getUserName()))
                .toList();
        return new VendorsFollowingListDto(userId, userName, vendorsNew);
    }

    public static VendorFollowersListDTO toVendorFollowersList(Vendor vendor) {
        Integer userId = vendor.getUserId();
        String userName = vendor.getUserName();
        List<UserDTO> followers = vendor.getFollowers()
                .stream()
                .map(u -> new UserDTO(u.getUserId(), u.getUserName()))
                .toList();
        return new VendorFollowersListDTO(userId, userName, followers);
    }

    public static VendorFollowersListDTO toVendorFollowersList(Vendor vendor, List<User> followersList) {
        Integer userId = vendor.getUserId();
        String userName = vendor.getUserName();
        List<UserDTO> followers = followersList
                .stream()
                .map(u -> new UserDTO(u.getUserId(), u.getUserName()))
                .toList();
        return new VendorFollowersListDTO(userId, userName, followers);
    }

    public static Post toPostFromPostReqDTO(BasePostReqDto postReqDto) {

        if (postReqDto instanceof PromoPostReqDto postDto) {
            return new Post(
                    postDto.getUserId(),
                    postDto.getDate(),
                    postDto.getProduct(),
                    postDto.getCategory(),
                    postDto.getPrice(),
                    postDto.getHasPromo(),
                    postDto.getDiscount()
            );
        } else if (postReqDto instanceof PostReqDto postDto) {
            return new Post(
                    postDto.getUserId(),
                    postDto.getDate(),
                    postDto.getProduct(),
                    postDto.getCategory(),
                    postDto.getPrice());
        } else {
            throw new RuntimeException("No se reconoce el DTO como un argumento válido");
        }
    }

    public static Post mapPostDTOToPost(PostReqDto postReqDto) {
        return new Post(
                postReqDto.getUserId(),
                postReqDto.getDate(),
                postReqDto.getProduct(),
                postReqDto.getCategory(),
                postReqDto.getPrice()
        );
    }

    public static Post mapPostDTOToPost(PromoPostReqDto promoPostReqDto) {
        return new Post(
                promoPostReqDto.getUserId(),
                promoPostReqDto.getDate(),
                promoPostReqDto.getProduct(),
                promoPostReqDto.getCategory(),
                promoPostReqDto.getPrice(),
                promoPostReqDto.getHasPromo(),
                promoPostReqDto.getDiscount()
        );
    }
}
