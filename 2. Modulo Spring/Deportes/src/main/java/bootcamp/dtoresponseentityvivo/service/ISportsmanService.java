package bootcamp.dtoresponseentityvivo.service;

import bootcamp.dtoresponseentityvivo.dto.SportsmanDto;

import java.util.List;

public interface ISportsmanService {

    List<SportsmanDto> findSportsmen();

}
