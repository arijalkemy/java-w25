package Calorias.service;

import Calorias.dto.DtoPlato;
import Calorias.entity.Ingredientes;
import Calorias.entity.Plato;

import java.util.List;

public interface IPlatoService {
    Plato exitsPlato(String plato);
    DtoPlato addDtoPlato(String plato);
}
