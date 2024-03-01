package com.bootcampW22.EjercicioGlobal.repository;

import com.bootcampW22.EjercicioGlobal.entity.Vehicle;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Repository
public class VehicleRepositoryImpl implements IVehicleRepository{

    private List<Vehicle> listOfVehicles = new ArrayList<>();

    public VehicleRepositoryImpl() throws IOException {
        loadDataBase();
    }
    @Override
    public List<Vehicle> findAll() {
        return listOfVehicles;
    }

    @Override
    public Vehicle save(Vehicle vehicle) {
        listOfVehicles.add(vehicle);
        try {
            Boolean bandera= addVehicleFile(listOfVehicles);
            if(bandera) {
                return vehicle;
            }else{
                return null;
            }
        }catch (Exception e){
            return null;
        }


    }

    @Override
    public Vehicle findById(Long id) {
        if(listOfVehicles.stream().filter(m->m.getId()==id.longValue()).findFirst().isEmpty()){
            return null;
        }else{
            return listOfVehicles.stream().filter(m->m.getId()==id.longValue()).findFirst().get();
        }

    }

    @Override
    public List<Vehicle> findByColorAndYear(String color, Integer year) {
        System.err.println(year);
            return listOfVehicles.stream().filter(m->m.getColor().equalsIgnoreCase(color)&&m.getYear().equals(year)).toList();

    }

    @Override
    public List<Vehicle> findByBrandAndBetweenYears(String brand, Integer startYear, Integer endYear) {
        return listOfVehicles.stream().filter(m->m.getBrand().equalsIgnoreCase(brand)&&m.getYear()>=startYear&&m.getYear()<=endYear).toList();
    }

    @Override
    public List<Vehicle> findByBrand(String brand) {
        return listOfVehicles.stream().filter(m->m.getBrand().equalsIgnoreCase(brand)).toList();
    }

    @Override
    public Boolean save(List<Vehicle> vehicles) {
        listOfVehicles.addAll(vehicles);
        try {
            Boolean bandera= addVehicleFile(listOfVehicles);
            if(bandera) {
                return true;
            }else{
                return null;
            }
        }catch (Exception e){
            return null;
        }
    }

    @Override
    public Boolean updateSpeed(Long id, String speed)  {
        Collections.sort(listOfVehicles,Vehicle.idComparator);
        Integer index=Collections.binarySearch(listOfVehicles,new Vehicle(id),Vehicle.idComparator);
        if(index>=0){
            listOfVehicles.get(index).setMax_speed(speed);
            try {
                addVehicleFile(listOfVehicles);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return true;
        }else{
            return false;
        }

    }

    @Override
    public Boolean deletedById(Long id) {
        Collections.sort(listOfVehicles,Vehicle.idComparator);
        Integer index=Collections.binarySearch(listOfVehicles,new Vehicle(id),Vehicle.idComparator);
        listOfVehicles.remove(index.longValue());
        try {
            addVehicleFile(listOfVehicles);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return true ;
    }

    private void loadDataBase() throws IOException {
        File file;
        ObjectMapper objectMapper = new ObjectMapper();
        List<Vehicle> vehicles ;

        file= ResourceUtils.getFile("classpath:vehicles_100.json");
        vehicles= objectMapper.readValue(file,new TypeReference<List<Vehicle>>(){});

        listOfVehicles = vehicles;
    }
    private Boolean addVehicleFile(List<Vehicle> list)throws IOException{
        File file;
        ObjectMapper objectMapper = new ObjectMapper();
        List<Vehicle> vehicles ;
        file= ResourceUtils.getFile("classpath:vehicles_100.json");
        FileWriter escritor = new FileWriter(file, false);
        escritor.close();
        FileWriter escritor2 = new FileWriter(file, false);
        escritor2.write(objectMapper.writeValueAsString(list));
        escritor2.close();

        loadDataBase();

        return ResourceUtils.getFile("classpath:vehicles_100.json")!=file;
    }
}
