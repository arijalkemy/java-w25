package bootcamp.clavescompuestas.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name = "personas")
@IdClass(PersonKey.class)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Person {

    @Id
    Integer dni;

    @Id
    Integer numTramite;

}
