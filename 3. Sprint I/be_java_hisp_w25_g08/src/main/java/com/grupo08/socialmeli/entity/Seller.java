package com.grupo08.socialmeli.entity;

import com.grupo08.socialmeli.exception.BadRequestException;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Optional;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
public class Seller extends User{
    private List<Post> posts;
    private List<User> followers;

    public Seller(int id, String name, List<Post> posts, List<User> followers) {
        super(id, name);
        this.posts = posts;
        this.followers = followers;
    }

    public Seller(List<Post> posts, List<User> followers) {
        this.posts = posts;
        this.followers = followers;
    }

    public boolean checkBuyer(Buyer seller) {
        Optional<User> sellerToRemove = followers.stream()
                .filter(s -> s.getId() == seller.getId())
                .findFirst();

        return sellerToRemove.isPresent();
    }

    public void addFollower(Buyer buyer) {
        if(this.checkBuyer(buyer))
            throw new BadRequestException("No puedes seguir un vendedor que ya sigues.");

        followers.add(buyer);

    }

    public void removeFollower(Buyer buyer) {
        if (!this.checkBuyer(buyer))
            throw new BadRequestException("No puedes dejar de seguir a alguien que no sigues.");

        followers.remove(buyer);
    }


}
