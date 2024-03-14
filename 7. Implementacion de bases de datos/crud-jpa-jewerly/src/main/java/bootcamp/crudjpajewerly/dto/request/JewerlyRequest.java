package bootcamp.crudjpajewerly.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class JewerlyRequest {

    String nombre;

    String material;

    Double peso;

    String particularidad;

    @JsonProperty("posee_piedra")
    Boolean poseePiedra;

    Boolean ventaONo;

}
