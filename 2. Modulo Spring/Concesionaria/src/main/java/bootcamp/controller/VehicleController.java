package bootcamp.controller;

import bootcamp.dto.VehicleDto;
import bootcamp.dto.VehicleWithoutServiceDto;
import bootcamp.service.VehicleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/api/vehicles")
public class VehicleController {
    @Autowired private VehicleServiceImpl service;

    /**
     * Agrega un nuevo vehículo.
     *
     * @param vehicle
     * @return
     */
    @PostMapping("")
    public ResponseEntity<Boolean> create(@RequestBody VehicleDto vehicle) {

        return new ResponseEntity<>(service.save(vehicle), HttpStatus.OK);
    }

    /**
     * Retorna un listado de todos los usados seleccionados. No incluye services.
     *
     * @return
     */
    @GetMapping("")
    public ResponseEntity<List<VehicleWithoutServiceDto>> read() {
        return new ResponseEntity<>(service.find(), HttpStatus.OK);
    }

    /**
     *
     * @param since
     * @param to
     * @return
     */
    @GetMapping("/dates")
    public ResponseEntity<List<VehicleDto>> readByDate(
            @RequestParam("since") String since,
            @RequestParam("to") String to) {
        return new ResponseEntity<>(service.find(since,to), HttpStatus.OK);
    }
    /**
     * Muestra el listado de los vehículos según los precios dados.
     * @param since
     * @param to
     * @return
     */
    @GetMapping("/prices")
    public ResponseEntity<List<VehicleDto>> readByPrice(
            @RequestParam("since") Double since,
            @RequestParam("to") Double to) {
        return new ResponseEntity<>(service.find(since,to), HttpStatus.OK);
    }

    /**
     * Muestra toda la información relacionada con el vehículo.
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public ResponseEntity<VehicleDto> readById(@PathVariable("id") Integer id) {
        VehicleDto v = service.find(id);
        if(v == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(v, HttpStatus.OK);
    }

}
