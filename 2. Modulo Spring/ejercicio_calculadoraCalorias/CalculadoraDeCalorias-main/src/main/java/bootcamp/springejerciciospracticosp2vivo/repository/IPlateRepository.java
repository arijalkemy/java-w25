package bootcamp.springejerciciospracticosp2vivo.repository;

import bootcamp.springejerciciospracticosp2vivo.entity.Plate;
import bootcamp.springejerciciospracticosp2vivo.exception.PlateNotFoundException;

public interface IPlateRepository {

    Plate findByName(String name) throws PlateNotFoundException;

}
