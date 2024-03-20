package bootcamp.siniestrosapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;
@Entity
@Getter
@Setter

public class Siniestro {
        @Id
        @GeneratedValue (strategy = GenerationType.AUTO)
        private Long id;
        private LocalDate fecha;
        private Double perdida_econ;

}
