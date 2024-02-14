package bootcamp.dtoresponseentityvivo.controller;

import bootcamp.dtoresponseentityvivo.dto.SportsmanDto;
import bootcamp.dtoresponseentityvivo.service.ISportService;
import bootcamp.dtoresponseentityvivo.service.ISportsmanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping()
public class SportsmanController {

    @Autowired
    private ISportsmanService sportsmanService;

    @GetMapping("/findSportsPersons")
    public ResponseEntity<List<SportsmanDto>> getSportsPersons() {
        return ResponseEntity.ok(sportsmanService.findSportsmen());
    }

}
