package main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import main.dto.VehicleDTO;
import main.dto.VehicleWServiceDTO;
import main.service.VehicleService;

@RestController
@RequestMapping("/api")
public class VehicleController {
    @Autowired
    private VehicleService vehicleService;

    // 1
    @PostMapping("/vehicles")
    public ResponseEntity<String> postVehicle(@RequestBody VehicleDTO vehicleDTO) {
        vehicleService.postVehicle(vehicleDTO);
        return new ResponseEntity<>("ok", HttpStatusCode.valueOf(200));
    }

    // 2
    @GetMapping("vehicles")
    @ResponseBody
    public ResponseEntity<List<VehicleWServiceDTO>> getVehicles() {
        return new ResponseEntity<>(vehicleService.getVehicles(), HttpStatusCode.valueOf(200));
    }

    // 4
    @GetMapping("vehicles/{since}/{to}")
    @ResponseBody
    public ResponseEntity<List<VehicleWServiceDTO>> getVehiclesByPrice(@PathVariable Integer since,
            @PathVariable Integer to) {
        return new ResponseEntity<>(vehicleService.getVehiclesByPrice(since, to), HttpStatusCode.valueOf(200));
    }

    // 5
    @GetMapping("vehicles/{id}")
    @ResponseBody
    public ResponseEntity<VehicleDTO> getVehiclesById(@PathVariable Integer id) {
        VehicleDTO vehicleDTO = vehicleService.getVehiclesById(id);
        if (vehicleDTO.getId() != null) {
            return new ResponseEntity<>(vehicleDTO, HttpStatusCode.valueOf(200));
        }
        return new ResponseEntity<>(vehicleDTO, HttpStatusCode.valueOf(404));
    }
}
