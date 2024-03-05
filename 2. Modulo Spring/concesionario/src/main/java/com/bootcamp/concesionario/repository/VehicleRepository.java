package com.bootcamp.concesionario.repository;

import com.bootcamp.concesionario.dto.MessageDto;
import com.bootcamp.concesionario.model.Vehicle;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class VehicleRepository implements IVehicleRepository{
    private List<Vehicle> vehicleList;
    public VehicleRepository(){
        loadData();
    }
    @Override
    public MessageDto saveVehicle(Vehicle vehicle) {
        vehicleList.add(vehicle);
        return new MessageDto("Vehicle saved successfully");
    }

    @Override
    public List<Vehicle> getAllVehicles() {
        return vehicleList;
    }

    @Override
    public Vehicle getByIdVehicle(int idVehicle) {
        return vehicleList.stream().filter(v->v.getIdVehicle()==idVehicle).findFirst().orElse(null);
    }

    private void loadData(){
        vehicleList = new ArrayList<>(
                Arrays.asList(
                        new Vehicle(1,"Ford","M1", LocalDate.of(2013,1,1),700.0),
                        new Vehicle(2,"Renault","Vani", LocalDate.of(2008,1,1),400.0),
                        new Vehicle(3,"Mazda","S3", LocalDate.of(2021,1,1),1250.0),
                        new Vehicle(4,"Toyota","Prado", LocalDate.of(2002,1,1),1100.0)
                )
        );
    }
}
