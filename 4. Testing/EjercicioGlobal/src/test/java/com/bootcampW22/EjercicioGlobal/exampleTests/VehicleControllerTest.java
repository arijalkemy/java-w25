package com.bootcampW22.EjercicioGlobal.exampleTests;

import com.bootcampW22.EjercicioGlobal.controller.VehicleController;
import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;
import com.bootcampW22.EjercicioGlobal.service.IVehicleService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class VehicleControllerTest {
    @Mock
    IVehicleService vehicleService;

    @InjectMocks
    VehicleController vehicleController;

    @Test
    void getVehiclesByColorAndYearOKTest(){
        //ARRANGE
        String color = "red";
        int year = 1998;
        List<VehicleDto> returnMock = new ArrayList<>();
        returnMock.add(new VehicleDto(101L,"Oldsmobile","Intrigue","2","Red",1998,"126",5,"diesel","semi-automatic",230.81,259.23,61.13));
        ResponseEntity<?> expected = new ResponseEntity<>(returnMock, HttpStatus.OK);

        when(vehicleService.searchVehiclesByYearAndColor(anyString(),anyInt())).thenReturn(returnMock);
        //ACT
        ResponseEntity<?> actual = vehicleController.getVehiclesByColorAndYear(color,year);
        //ASSERT
        assertEquals(expected,actual);

    }
}
