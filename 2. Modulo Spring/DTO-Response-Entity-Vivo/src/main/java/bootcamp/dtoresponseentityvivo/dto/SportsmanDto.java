package bootcamp.dtoresponseentityvivo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SportsmanDto {

    private String fullName;
    private List<String> sports;

}
