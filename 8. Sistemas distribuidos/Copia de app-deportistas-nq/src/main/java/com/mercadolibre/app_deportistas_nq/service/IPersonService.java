package com.mercadolibre.app_deportistas_nq.service;

import com.mercadolibre.app_deportistas_nq.dtos.PersonDTO;
import com.mercadolibre.app_deportistas_nq.dtos.PersonSportsDTO;

import java.util.List;

public interface IPersonService {
    List<PersonDTO> findPersons();

    List<PersonSportsDTO> findPersonSports();
}
