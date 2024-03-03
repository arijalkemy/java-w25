package AutosConsesionario.entity;

import lombok.*;

import java.sql.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter
@Setter
public class Service {
    private String date;
    private String kilometers;
    private String descriptions;
}
