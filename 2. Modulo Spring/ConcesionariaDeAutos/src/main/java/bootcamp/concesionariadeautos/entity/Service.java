package bootcamp.concesionariadeautos.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Service {

    private String date;
    private String kilometers;
    private String descriptions;

}
