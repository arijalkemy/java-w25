package bootcamp.arquitecturamulticapap1vivo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CharacterDto {

    private String name;
    private Integer height;
    private Integer mass;
    private String gender;
    private String homeworld;
    private String species;

}
