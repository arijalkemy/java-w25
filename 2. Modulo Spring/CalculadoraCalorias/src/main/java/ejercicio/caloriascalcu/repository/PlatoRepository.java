package ejercicio.caloriascalcu.repository;


import ejercicio.caloriascalcu.entity.Ingrediente;
import ejercicio.caloriascalcu.entity.Plato;
import lombok.Data;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Data
public class PlatoRepository {

    List<Plato> platos = List.of(
            new Plato("Pizza", List.of(
                    new Ingrediente("Harina de maíz", 150),
                    new Ingrediente("Salsa de tomate en conserva", 300))),
            new Plato("Empanadas", List.of(
                    new Ingrediente("Harina de maíz", 150),
                    new Ingrediente("Salsa de tomate en conserva", 300)))
    );

    public List<Plato> getAllPlatos() {
        return this.platos;
    }

}
