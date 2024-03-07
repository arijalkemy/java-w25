package bootcamp.springejerciciospracticosp2vivo.repository;

import bootcamp.springejerciciospracticosp2vivo.entity.Plate;
import bootcamp.springejerciciospracticosp2vivo.exception.PlateNotFoundException;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
public class PlateRepositoryImpl implements IPlateRepository {

    private final List<Plate> plates = Arrays.asList(
            new Plate("Pizza", Arrays.asList("Aceitunas verdes", "Cebolla", "Queso mozzarella")),
            new Plate("Hamburguesa", Arrays.asList("Hamburguesa", "Queso cheddar"))
    );

    @Override
    public Plate findByName(String name) throws PlateNotFoundException {
        return plates.stream().filter(p -> p.getName().equals(name)).findFirst().orElseThrow(() -> new PlateNotFoundException(name));
    }

}
