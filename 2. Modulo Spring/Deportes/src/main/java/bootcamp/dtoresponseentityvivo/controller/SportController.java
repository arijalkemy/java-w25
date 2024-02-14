package bootcamp.dtoresponseentityvivo.controller;

import bootcamp.dtoresponseentityvivo.exception.NotExistingSport;
import bootcamp.dtoresponseentityvivo.model.Sport;
import bootcamp.dtoresponseentityvivo.service.ISportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SportController {

    @Autowired
    private ISportService sportService;

    @GetMapping("/findSports")
    public ResponseEntity<List<Sport>> getSports() {
        return ResponseEntity.ok(sportService.findAll());
    }

    @GetMapping("/findSport/{name}")
    public ResponseEntity<String> getSportByName(@PathVariable String name) {
        try {
            return ResponseEntity.ok(sportService.findByName(name));
        } catch (NotExistingSport e) {
            return ResponseEntity.badRequest().build();
        }
    }

}
