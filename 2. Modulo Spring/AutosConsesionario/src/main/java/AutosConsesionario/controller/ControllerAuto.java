package AutosConsesionario.controller;

import AutosConsesionario.dto.DtoAuto;
import AutosConsesionario.entity.Auto;
import AutosConsesionario.service.IServiceAutos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/v1/api/vehicles")
public class ControllerAuto {

    @Autowired
    IServiceAutos servicioAutos;
    @GetMapping
    public ResponseEntity<List<DtoAuto>> viewAll(){
        List<DtoAuto> listAuto = servicioAutos.viewAllAutos();
        return new ResponseEntity<List<DtoAuto>>(listAuto, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> addAuto(@RequestBody Auto auto){
        if (auto == null){
            return ResponseEntity.badRequest().body("Datos del vehículo mal formados o incompletos.");
        }
        boolean existAuto = servicioAutos.exitsAuto(auto.getId());
        if (existAuto){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Identificador del vehículo ya existente.");
        }
        return ResponseEntity.status(HttpStatus.CREATED).body("Vehículo creado exitosamente.");
    }

    @GetMapping("/dates")
    public List<DtoAuto> filterByDate(@RequestParam String fechaInicio,
                                      @RequestParam String fechaFinal){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate inicio = LocalDate.parse(fechaInicio, formatter);
        LocalDate fin = LocalDate.parse(fechaFinal, formatter);

        return servicioAutos.viewAllAutos().stream()
                .filter(auto -> {LocalDate fecha = LocalDate.parse(auto.getManufacturingDate(), formatter);
                                    return !fecha.isBefore(inicio) && !fecha.isAfter(fin); })
                                    .collect(Collectors.toList());
    }

}
