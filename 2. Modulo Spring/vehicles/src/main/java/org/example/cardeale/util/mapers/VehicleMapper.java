package org.example.cardeale.util.mapers;

import org.example.cardeale.dto.vehicle.VehicleDTO;
import org.example.cardeale.entity.vehicle.Vehicle;
import com.fasterxml.jackson.databind.ObjectMapper;

public class VehicleMapper {
    public static VehicleDTO toVehicleDTO(Vehicle vehicle){
        var mapper = new ObjectMapper();
        return mapper.convertValue(vehicle,VehicleDTO.class);
    }
    public static Vehicle toVehicle(VehicleDTO vehicleDTO){
        return new ObjectMapper().convertValue(vehicleDTO,Vehicle.class);
    }
}
