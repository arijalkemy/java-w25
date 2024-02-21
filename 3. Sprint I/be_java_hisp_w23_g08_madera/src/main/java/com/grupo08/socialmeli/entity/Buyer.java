package com.grupo08.socialmeli.entity;

import com.grupo08.socialmeli.exception.BadRequestException;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Optional;

@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Buyer extends User {
    private List<Seller> following;

    public Buyer(int id, String name, List<Seller> following) {
        super(id, name);
        this.following = following;
    }

    public boolean checkSeller(Seller seller) {
        Optional<Seller> sellerToRemove = following.stream()
                .filter(s -> s.getId() == seller.getId())
                .findFirst();

        return sellerToRemove.isPresent();
    }

    public void addFollowingSeller(Seller seller) {
        if(this.checkSeller(seller))
            throw new BadRequestException("No puedes seguir un vendedor que ya sigues.");

        following.add(seller);

    }

    public void unFollowSeller(Seller seller) {
        if (!this.checkSeller(seller))
            throw new BadRequestException("No puedes dejar de seguir a alguien que no sigues.");

        following.remove(seller);
    }

}
