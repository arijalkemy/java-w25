package bootcamp.empresaseguros.controller;

import bootcamp.empresaseguros.dto.request.VehiculoRequestDTO;
import bootcamp.empresaseguros.dto.response.PatenteDTO;
import bootcamp.empresaseguros.dto.response.PatenteMarcaDTO;
import bootcamp.empresaseguros.dto.response.VehiculoResponseDTO;
import bootcamp.empresaseguros.service.IVehiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("vehiculos")
public class VehiculoController {

    @Autowired
    private IVehiculoService vehiculoService;

    @GetMapping
    public ResponseEntity<List<VehiculoResponseDTO>> getAllVehicles() {
        return ResponseEntity.ok(vehiculoService.getAllVehicles());
    }

    @PostMapping
    public ResponseEntity<String> createVehicle(@RequestBody VehiculoRequestDTO request) {
        vehiculoService.createVehicle(request);
        return ResponseEntity.ok("Vehículo creado correctamente");
    }

    @GetMapping("/{id}")
    public ResponseEntity<VehiculoResponseDTO> getVehicleById(@PathVariable Long id) {
        return ResponseEntity.ok(vehiculoService.getVehicleById(id));
    }

    @GetMapping("/patentes")
    public ResponseEntity<List<PatenteDTO>> getAllVehiclesLicensePlate() {
        return ResponseEntity.ok(vehiculoService.getAllVehiclesLicensePlates());
    }

    @GetMapping("ordenados-por-anio-de-fabricacion")
    public ResponseEntity<List<PatenteMarcaDTO>> getAllVehiclesLicensePlateAndBrandOrderedByYearOfManufacturingDesc() {
        return ResponseEntity.ok(vehiculoService.getAllVehiclesLicensePlateAndBrandOrderedByYearOfManufacturingDesc());
    }

    @GetMapping("mas-de-4-ruedas-anio-actual")
    public ResponseEntity<List<PatenteDTO>> getVehiclesLicensePlateWithMoreThan4WheelsAndYearOfManufacturingCurrentYear() {
        return ResponseEntity.ok(vehiculoService.getVehiclesLicensePlateWithMoreThan4WheelsAndYearOfManufacturingCurrentYear());
    }

}
