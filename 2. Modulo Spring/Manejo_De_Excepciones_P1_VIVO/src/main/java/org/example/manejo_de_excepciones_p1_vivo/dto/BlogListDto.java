package org.example.manejo_de_excepciones_p1_vivo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BlogListDto {
    @JsonProperty("blog_list")
    private List<BlogDto> blogLis;
}
