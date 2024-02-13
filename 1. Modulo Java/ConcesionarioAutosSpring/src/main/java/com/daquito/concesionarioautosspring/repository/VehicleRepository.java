package com.daquito.concesionarioautosspring.repository;

import com.daquito.concesionarioautosspring.entity.Vehicle;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class VehicleRepository {

    private List<Vehicle> vehicleList = new ArrayList<>();

    public List<Vehicle> getAll(){
        return vehicleList;
    }

    public void add(Vehicle vehicle){
        vehicleList.add(vehicle);
    }

    public Vehicle get(int id){
        return vehicleList.get(id);
    }



}
