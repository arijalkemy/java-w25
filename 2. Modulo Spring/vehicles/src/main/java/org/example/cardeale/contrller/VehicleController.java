package org.example.cardeale.contrller;

import org.example.cardeale.dto.vehicle.VehicleDTO;
import org.example.cardeale.dto.vehicle.common.DateRangeDTO;
import org.example.cardeale.dto.vehicle.common.PriceRangeDTO;
import org.example.cardeale.service.common.IVehicleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/api/vehicles")
public class VehicleController {

    private IVehicleService vehicleService;

    public VehicleController(IVehicleService vehicleService){
        this.vehicleService = vehicleService;
    }
    @GetMapping
    public ResponseEntity<List<VehicleDTO>> getAll(){
        return ResponseEntity.ok(this.vehicleService.getAll());
    }
    @GetMapping("/dates")
    public ResponseEntity<List<VehicleDTO>> getByRangeDate(DateRangeDTO dateRangeDTO){
        return ResponseEntity.ok(this.vehicleService.getByRangeDate(dateRangeDTO));
    }
    @GetMapping("/prices")
    public ResponseEntity<List<VehicleDTO>> getByRangePrice(PriceRangeDTO rangeDTO){
        return ResponseEntity.ok(this.vehicleService.getByRangePrice(rangeDTO));
    }
    @GetMapping("/{id}")
    public ResponseEntity<VehicleDTO> getById(@PathVariable int id){
        return ResponseEntity.ok(this.vehicleService.getById (id));
    }
    @PostMapping
    public ResponseEntity<VehicleDTO> create(@RequestBody VehicleDTO vehicleDTO){
        return ResponseEntity.ok(this.vehicleService.create(vehicleDTO));
    }
}
