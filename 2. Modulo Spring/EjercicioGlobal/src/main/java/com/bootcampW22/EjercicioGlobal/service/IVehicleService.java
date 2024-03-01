package com.bootcampW22.EjercicioGlobal.service;

import com.bootcampW22.EjercicioGlobal.dto.AverageSpeedDto;
import com.bootcampW22.EjercicioGlobal.dto.ResponseDto;
import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;

import java.io.IOException;
import java.util.List;

public interface IVehicleService {
    List<VehicleDto> searchAllVehicles();
    VehicleDto addVehicle(VehicleDto vehicle);
    List<VehicleDto> filterYearAndColor(Integer year, String color);
    List<VehicleDto> filterBrandAndBetweenYears(String brand,Integer startYear,Integer endYear);
    AverageSpeedDto averageSpeedToBrand(String Brand);
    ResponseDto addVehicle(List<VehicleDto> vehicle) throws IllegalAccessException;
    ResponseDto updateSpeed(Long id,String speed) throws IOException;
    ResponseDto deletedVehicleId(Long id);

}
