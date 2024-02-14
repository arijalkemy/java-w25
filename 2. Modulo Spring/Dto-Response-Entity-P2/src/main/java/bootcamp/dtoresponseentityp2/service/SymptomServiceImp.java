package bootcamp.dtoresponseentityp2.service;

import bootcamp.dtoresponseentityp2.dto.RiskPersonDto;
import bootcamp.dtoresponseentityp2.exception.NoSymptomException;
import bootcamp.dtoresponseentityp2.model.Person;
import bootcamp.dtoresponseentityp2.model.Severity;
import bootcamp.dtoresponseentityp2.model.Symptom;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class SymptomServiceImp implements ISymptomService {

    private final Symptom resfrio = new Symptom("1H79", "Resfrio", Severity.LOW.toString());
    private final Symptom fiebre = new Symptom("1H82", "Fiebre", Severity.MEDIUM.toString());
    private final Symptom hemorragia = new Symptom("K7US", "Hemorragia", Severity.HIGH.toString());
    private final Symptom manchas = new Symptom("DF8S", "Manchas en la piel", Severity.CRITICAL.toString());

    private final List<Person> people = Arrays.asList(
            new Person(1, "Renzo", "Jacinto", 25, Collections.singletonList(resfrio)),
            new Person(1, "Rogelio", "Gómez", 71, Arrays.asList(resfrio, fiebre)),
            new Person(1, "Suplicio", "Sócrates", 65, Arrays.asList(hemorragia, manchas))
    );

    private final List<Symptom> symptoms = Arrays.asList(resfrio, fiebre, hemorragia, manchas);

    @Override
    public List<Symptom> getSymptoms() {
        return symptoms;
    }

    @Override
    public String getSymptomByName(String name) throws NoSymptomException {
        Optional<Symptom> symptom = symptoms.stream().filter(s -> s.getName().equalsIgnoreCase(name)).findFirst();
        if (symptom.isPresent()) return symptom.get().getSeverity();
        throw new NoSymptomException(name);
    }

    @Override
    public List<RiskPersonDto> getRiskPeople() {
        List<Person> listOfRiskPeople = people.stream().filter(p -> p.getAge() >= 60 && !p.getSymptoms().isEmpty()).toList();
        List<RiskPersonDto> riskPersonDtos = new ArrayList<>();
        for (Person person : listOfRiskPeople) {
            riskPersonDtos.add(new RiskPersonDto(person.getFirstName() + " " + person.getLastName()));
        }
        return riskPersonDtos;
    }
}
