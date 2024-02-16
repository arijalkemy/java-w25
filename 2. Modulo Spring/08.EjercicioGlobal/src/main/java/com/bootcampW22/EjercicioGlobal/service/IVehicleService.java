package com.bootcampW22.EjercicioGlobal.service;

import com.bootcampW22.EjercicioGlobal.dto.ResponseDto;
import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;
import org.apache.coyote.Response;

import java.util.List;

public interface IVehicleService {
    List<VehicleDto> searchAllVehicles();
    ResponseDto saveVehicle(VehicleDto dto);

}
