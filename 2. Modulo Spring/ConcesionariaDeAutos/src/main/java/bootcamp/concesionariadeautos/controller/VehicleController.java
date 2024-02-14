package bootcamp.concesionariadeautos.controller;

import bootcamp.concesionariadeautos.dto.VehicleCreationDto;
import bootcamp.concesionariadeautos.dto.VehicleDto;
import bootcamp.concesionariadeautos.entity.Vehicle;
import bootcamp.concesionariadeautos.service.IVehicleService;
import bootcamp.concesionariadeautos.service.VehicleServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/v1/api/vehicles")
public class VehicleController {

    IVehicleService vehicleService;

    public VehicleController(VehicleServiceImpl vehicleServiceImpl){
        this.vehicleService =vehicleServiceImpl;
    }

    @GetMapping()
    public ResponseEntity<List<VehicleDto>> getAllVehicles(){
        return ResponseEntity.ok(vehicleService.getAll());
    }

    @PostMapping()
    public ResponseEntity<Vehicle> createVehicle(@RequestBody VehicleCreationDto vehicle){
        return ResponseEntity.ok(vehicleService.createVehicle(vehicle));
    }

    @GetMapping("/dates")
    public ResponseEntity<List<VehicleDto>> getByBetweenDates(@RequestParam String since, @RequestParam String to){
        return ResponseEntity.ok(vehicleService.getBetweenDates(since,to));
    }

    @GetMapping("/prices")
    public ResponseEntity<List<VehicleDto>> getByBetweenPrices(@RequestParam String since, @RequestParam String to){
        return ResponseEntity.ok(vehicleService.getBetweenPrices(since, to));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Vehicle> getVehicleInformationById(@PathVariable Long id){
        return ResponseEntity.ok(vehicleService.getById(id));
    }
}
