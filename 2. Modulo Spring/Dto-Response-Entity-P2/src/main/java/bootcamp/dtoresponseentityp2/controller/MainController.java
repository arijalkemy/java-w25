package bootcamp.dtoresponseentityp2.controller;

import bootcamp.dtoresponseentityp2.dto.RiskPersonDto;
import bootcamp.dtoresponseentityp2.exception.NoSymptomException;
import bootcamp.dtoresponseentityp2.model.Symptom;
import bootcamp.dtoresponseentityp2.service.ISymptomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MainController {

    @Autowired
    private ISymptomService symptomService;

    @GetMapping("/findSymptom")
    public ResponseEntity<List<Symptom>> getSymptoms() {
        return new ResponseEntity<>(symptomService.getSymptoms(), HttpStatus.OK);
    }

    @GetMapping("/findSymptom/{name}")
    public ResponseEntity<String> getSymptoms(@PathVariable String name) {
        try {
            return ResponseEntity.ok(symptomService.getSymptomByName(name));
        } catch (NoSymptomException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/findRiskPerson")
    public ResponseEntity<List<RiskPersonDto>> getRiskPerson() {
        return ResponseEntity.ok(symptomService.getRiskPeople());
    }

}
