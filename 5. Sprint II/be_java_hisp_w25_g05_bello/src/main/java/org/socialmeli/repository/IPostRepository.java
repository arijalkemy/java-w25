package org.socialmeli.repository;

import org.socialmeli.entity.Post;
import org.socialmeli.entity.User;
import org.socialmeli.entity.Vendor;

import java.util.List;

public interface IPostRepository extends IRepository<Post> {
    List<Vendor> getFollowedList(User client, List<Vendor> vendorList);
    List<Post> getPostsByUserId(Integer vendorId);
}
