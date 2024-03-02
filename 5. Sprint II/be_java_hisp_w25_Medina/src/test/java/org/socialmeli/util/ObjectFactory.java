package org.socialmeli.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.socialmeli.dto.request.PostReqDto;
import org.socialmeli.dto.response.*;
import org.socialmeli.entity.Client;
import org.socialmeli.entity.Post;
import org.socialmeli.entity.Product;
import org.socialmeli.entity.Vendor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.socialmeli.util.TestDTOMapper.*;

public class ObjectFactory {

    public Integer getValidUserId() {
        return 1;
    }

    public Integer getValidUserId2() {
        return 2;
    }

    public Integer getValidClientId() {
        return 6;
    }

    public Integer getValidVendorId() {
        return 2;
    }

    public Integer getValidVendorId2() {
        return 3;
    }

    public Integer getInvalidUserId() {
        return 99999;
    }

    public String getAscendentNameOrder() {
        return "name_asc";
    }

    public String getDescendentNameOrder() {
        return "name_desc";
    }

    public String getInvalidOrder() {
        return "invalido";
    }

    public String getValidDateOrder() {
        return getAscendentDateOrder();
    }

    public String getAscendentDateOrder() {
        return "date_desc";
    }

    public Client getValidClient() {
        Client res = new Client();
        res.setUserId(getValidUserId());
        res.setUserName("Test Man");
        return res;
    }

    public Client getValidClient2() {
        Client res = new Client();
        res.setUserId(getValidUserId());
        res.setUserName("Martin Colo");
        return res;
    }

    public Vendor getValidVendor() {
        Vendor res = new Vendor();
        res.setUserId(getValidVendorId());
        res.setUserName("Git Man");
        return res;
    }

    public Vendor getValidVendor2() {
        Vendor res = new Vendor();
        res.setUserId(getValidVendorId2());
        res.setUserName("G Man");
        return res;
    }

    public Client getValidClientFollowingVendor() {
        Client res = getValidClient();
        Vendor vendor = getValidVendor();
        res.getFollowing().add(vendor);
        vendor.getFollowers().add(res);
        return res;
    }

    public Vendor getValidVendorFollowingVendor() {
        Vendor follower = getValidVendor();
        Vendor followingVendor = getValidVendor2();
        follower.getFollowing().add(followingVendor);
        followingVendor.getFollowers().add(follower);
        return follower;
    }

    public Vendor getVendorWithTwoFollowers() {
        Vendor vendor = getValidVendor();
        Client follower1 = getValidClient();
        Client follower2 = getValidClient2();
        vendor.getFollowers().add(follower1);
        vendor.getFollowers().add(follower2);
        return vendor;
    }

    public Client getClientFollowingTwoVendors() {
        Client res = getValidClient();
        Vendor vendor = getValidVendor();
        Vendor vendor2 = getValidVendor2();
        res.getFollowing().add(vendor);
        res.getFollowing().add(vendor2);
        vendor.getFollowers().add(res);
        vendor2.getFollowers().add(res);
        return res;
    }

    public Product getValidProduct() {
        return new Product(1, "Camiseta", "Ropa", "Nike", "Blanco", "Con logo");
    }

    public Product getValidProduct2() {
        return new Product(2, "Zapatos", "Calzado", "Adidas", "Negro", "N/A");
    }

    public Post getPostFromToday(Vendor vendor) {
        return new Post(vendor.getUserId(), LocalDate.now(), getValidProduct(), 1, 35.99);
    }

    public List<Post> getListOfSinglePost(Vendor vendor) {
        return List.of(getPostFromToday(vendor));
    }

    public List<Post> getTwoPostsOlderThanTwoWeeks(Vendor vendor) {
        List<Post> postList = new ArrayList<>();
        Post post1 = new Post(vendor.getUserId(), LocalDate.of(2023, 3, 20), getValidProduct(), 1, 35.99);
        Post post2 = new Post(vendor.getUserId(), LocalDate.of(2023, 3, 20), getValidProduct2(), 2, 79.99);
        postList.add(post1);
        postList.add(post2);
        return postList;
    }

    public List<Post> getPostsFromTodayAndTwoDaysAgo(Vendor vendor) {
        List<Post> postList = new ArrayList<>();
        Product product1 = getValidProduct();
        Product product2 = getValidProduct2();
        Post post1 = new Post(vendor.getUserId(), LocalDate.now(), product1, 1, 35.99);
        Post post2 = new Post(vendor.getUserId(), LocalDate.now().minusDays(2), product2, 2, 79.99);
        postList.add(post1);
        postList.add(post2);
        return postList;
    }

    public FollowersListDto getVendorFollowersListDto() {
        Vendor vendor = getValidVendor();
        Client client1 = getValidClient();
        Client client2 = getValidClient2();
        return new FollowersListDto(vendor.getUserId(), vendor.getUserName(), List.of(new UserDto(client1.getUserId(), client1.getUserName()), new UserDto(client2.getUserId(), client2.getUserName())));
    }

    public FollowingListDto getVendorsFollowingListDto() {
        Client client = getValidClient();
        Vendor vendor1 = getValidVendor();
        Vendor vendor2 = getValidVendor2();
        return new FollowingListDto(client.getUserId(), client.getUserName(), List.of(new UserDto(vendor1.getUserId(), vendor1.getUserName()), new UserDto(vendor2.getUserId(), vendor2.getUserName())));
    }


    public FollowedListDto getFollowedListDto(Vendor vendor) {
        List<PostDto> postDto = getValidPostDto(vendor);
        return new FollowedListDto(vendor.getUserId(), postDto);
    }

    public List<PostDto> getValidPostDto(Vendor vendor) {
        return getPostsFromTodayAndTwoDaysAgo(vendor).stream().map(TestDTOMapper::convertToPostDto).toList();
    }

    public FollowerCountDto getFollowerCountDto(Vendor vendor) {
        return new FollowerCountDto(vendor.getUserId(), vendor.getUserName(), 0);
    }

    public PostReqDto getValidPostReqDto() {
        return new PostReqDto(getValidUserId(), LocalDate.now(), getValidProductDto(), 100, 500.0);
    }

    public ProductDto getValidProductDto() {
        return convertToProductDto(getValidProduct());
    }


}
