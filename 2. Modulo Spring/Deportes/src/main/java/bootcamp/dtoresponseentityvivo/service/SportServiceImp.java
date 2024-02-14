package bootcamp.dtoresponseentityvivo.service;

import bootcamp.dtoresponseentityvivo.exception.NotExistingSport;
import bootcamp.dtoresponseentityvivo.model.Sport;
import bootcamp.dtoresponseentityvivo.repository.SportsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SportServiceImp implements ISportService {

    @Autowired
    private SportsRepository sportsRepository;

    @Override
    public List<Sport> findAll() {
        return sportsRepository.getSports();
    }

    @Override
    public String findByName(String name) throws NotExistingSport {
        Optional<Sport> sport =  sportsRepository.getSports().stream().filter(s -> s.getName().equalsIgnoreCase(name)).findFirst();
        if (sport.isPresent()) return sport.get().getLevel();
        throw new NotExistingSport(name);
    }

}
