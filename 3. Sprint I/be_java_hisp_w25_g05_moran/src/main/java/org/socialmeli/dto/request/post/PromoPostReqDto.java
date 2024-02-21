package org.socialmeli.dto.request.post;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.socialmeli.entity.Post;
import org.socialmeli.entity.Product;
import org.socialmeli.utils.DTOMapper;

import java.time.LocalDate;

//@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
public class PromoPostReqDto extends BasePostReqDto {
    Boolean hasPromo;
    Double discount;

    public PromoPostReqDto(Integer userId, LocalDate date, Product product, Integer category, Double price, Boolean hasPromo, Double discount) {
        super(userId, date, product, category, price);
        this.hasPromo = hasPromo;
        this.discount = discount;
    }

    @Override
    public Post sendToPostMapper() {
        return DTOMapper.mapPostDTOToPost(this);
    }
}
