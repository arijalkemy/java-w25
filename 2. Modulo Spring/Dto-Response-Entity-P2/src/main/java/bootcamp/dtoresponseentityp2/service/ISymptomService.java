package bootcamp.dtoresponseentityp2.service;

import bootcamp.dtoresponseentityp2.dto.RiskPersonDto;
import bootcamp.dtoresponseentityp2.exception.NoSymptomException;
import bootcamp.dtoresponseentityp2.model.Severity;
import bootcamp.dtoresponseentityp2.model.Symptom;

import java.util.List;

public interface ISymptomService {

    List<Symptom> getSymptoms();

    String getSymptomByName(String name) throws NoSymptomException;

    List<RiskPersonDto> getRiskPeople();

}
