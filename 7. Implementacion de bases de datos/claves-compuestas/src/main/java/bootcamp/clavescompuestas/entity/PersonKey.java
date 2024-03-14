package bootcamp.clavescompuestas.entity;

import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;

@EqualsAndHashCode
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PersonKey implements Serializable {

    Integer dni;

    Integer numTramite;

}
