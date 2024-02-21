package org.bootcamp.javazoo.dto.response;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bootcamp.javazoo.dto.PostResponseDto;
import org.bootcamp.javazoo.dto.ProductDto;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PostPromoListDto {

    private int user_id;
    private String user_name;
    private List<PostPromoResponseDto> posts;

}
