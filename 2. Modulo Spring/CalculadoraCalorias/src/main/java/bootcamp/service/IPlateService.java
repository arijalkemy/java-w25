package bootcamp.service;

import bootcamp.dto.PlateDTO;
import bootcamp.entity.Plate;

import java.util.List;

public interface IPlateService {

     Plate findPlateByName(String name);
    public PlateDTO cookPlate(Plate plate);
}
