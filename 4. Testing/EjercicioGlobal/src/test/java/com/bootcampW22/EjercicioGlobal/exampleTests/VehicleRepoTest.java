package com.bootcampW22.EjercicioGlobal.exampleTests;

import com.bootcampW22.EjercicioGlobal.entity.Vehicle;
import com.bootcampW22.EjercicioGlobal.repository.IVehicleRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class VehicleRepoTest {

    @Autowired
    IVehicleRepository vehicleRepository;

    @Test
    void findVehiclesByYearAndColorOkTest(){

        //ARRANGE
        String color = "red";
        int year = 1998;
        List<Vehicle> expected = new ArrayList<>();
        expected.add(new Vehicle(101L,"Oldsmobile","Intrigue","2","Red",1998,"126",5,"diesel","semi-automatic",230.81,259.23,61.13));
        //ACT
        List<Vehicle> actual = vehicleRepository.findVehiclesByYearAndColor(color,year);
        //ASSERT
        assertEquals(expected,actual);
    }
}
