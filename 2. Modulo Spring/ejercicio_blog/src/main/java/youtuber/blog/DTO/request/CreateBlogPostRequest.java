package youtuber.blog.DTO.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CreateBlogPostRequest {
    @JsonProperty("id")
    Long id;
    @JsonProperty("titulo")
    String titulo;
    @JsonProperty("author_name")
    String autor;
    @JsonProperty("publication_date")
    String fechaPublicacion;
}
