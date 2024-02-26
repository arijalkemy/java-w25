package deportistaDTO;

import deportistaDTO.dto.DeporteDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class DeportLi{

    //Devolver los nombres de los deportes
    @GetMapping ("/findsports")
    // Como es un metodo de tipo Lista debe devolver una lista
    public ResponseEntity<List<String>> deportista(){

        DeporteDTO depor1 = new DeporteDTO("Futbol");
        DeporteDTO depor2 = new DeporteDTO("Basket");
        DeporteDTO depor3 = new DeporteDTO("Soccer");
        DeporteDTO depor4 = new DeporteDTO("Fenis");

        List<DeporteDTO> deportes = List.of(depor1, depor2, depor3, depor4);

        List<String> deportesDTO = deportes.stream().map(deporte -> deporte.getNombre()).collect(Collectors.toList());

        return new ResponseEntity<>(deportesDTO, HttpStatus.OK);
    }

    @GetMapping ("/findSport/{name}")
    public ResponseEntity<String> findSport(@PathVariable String name){



        return  ;
    }
}
