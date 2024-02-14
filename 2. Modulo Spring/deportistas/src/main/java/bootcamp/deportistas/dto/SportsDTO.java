package bootcamp.deportistas.dto;

import bootcamp.deportistas.model.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SportsDTO{
    private List<Sport> sportsList;


}
