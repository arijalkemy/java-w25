package org.socialmeli.dto.request.post;

import org.socialmeli.entity.Post;
import org.socialmeli.entity.Product;
import org.socialmeli.utils.DTOMapper;

import java.time.LocalDate;

//@Data
//@AllArgsConstructor
//@FieldDefaults(level = AccessLevel.PRIVATE)
public class PostReqDto extends BasePostReqDto {
        public PostReqDto(Integer userId, LocalDate date, Product product, Integer category, Double price) {
                super(userId, date, product, category, price);
        }

        @Override
        public Post sendToPostMapper() {
                return DTOMapper.mapPostDTOToPost(this);
        }
}