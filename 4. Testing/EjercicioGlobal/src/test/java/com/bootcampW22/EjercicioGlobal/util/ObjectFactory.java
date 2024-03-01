package com.bootcampW22.EjercicioGlobal.util;

import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;
import com.bootcampW22.EjercicioGlobal.entity.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class ObjectFactory {

    public static List<Vehicle> getVehicleList(){
        return List.of(new Vehicle(101L,"Oldsmobile","Intrigue","2","Red",1998,"126",5,"diesel","semi-automatic",230.81,259.23,61.13));
    }

    public static List<VehicleDto> getVehicleDtoList(){
        return List.of(new VehicleDto(101L,"Oldsmobile","Intrigue","2","Red",1998,"126",5,"diesel","semi-automatic",230.81,259.23,61.13));
    }


    public static List<VehicleDto> getVehicleDtoListToWeightOk(){
        return List.of(new VehicleDto(302L,"Toyota","Yaris","319","Maroon",2007,"177",4,"gasoline","manual",226.8,171.77,20.51));
    }
}
