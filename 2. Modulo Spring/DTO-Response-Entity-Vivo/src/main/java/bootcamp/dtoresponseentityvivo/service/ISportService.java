package bootcamp.dtoresponseentityvivo.service;

import bootcamp.dtoresponseentityvivo.dto.SportsmanDto;
import bootcamp.dtoresponseentityvivo.exception.NotExistingSport;
import bootcamp.dtoresponseentityvivo.model.Sport;

import java.util.List;

public interface ISportService {

    List<Sport> findAll();

    String findByName(String name) throws NotExistingSport;

}
