package com.bootcampW22.EjercicioGlobal;

import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;
import com.bootcampW22.EjercicioGlobal.exception.NotFoundException;
import com.bootcampW22.EjercicioGlobal.service.IVehicleService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static com.bootcampW22.EjercicioGlobal.util.ObjectFactory.getVehicleDtoListToWeightOk;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class ClaseTest {

    @Autowired
    IVehicleService vehicleService;

    @Test
    @DisplayName("US001- ")
    void calculateTotalOKTest(){
        //arrange
        int a = 4;
        int b = 6;
        int expected = 15;
        //act
        int actual =  vehicleService.calculateTotal(a,b);
        //assert

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Caso en que retorna el primero como min")
    void calculateMinValueAMinValueTest(){
        //arrange
        int a = 3;
        int b = 4;
        int expected = 3;
        //act
        int actual = vehicleService.calculateMinValue(a,b);
        //assert
        assertEquals(expected,actual);
    }

    @Test
    @DisplayName("Caso en que retorna el segundo como min")
    void calculateMinValueBMinValueTest(){
        //arrange
        int a = 6;
        int b = 4;
        int expected = 4;
        //act
        int actual = vehicleService.calculateMinValue(a,b);
        //assert
        assertEquals(expected,actual);
    }

    @Test
    @DisplayName("Caso en que retorna el segundo como min")
    void calculateMinValueBMinValueTest1(){
        //arrange
        int a = 6;
        int b = 4;
        int expected = 4;
        //act and Assert
        assertThrows(Exception.class,()->vehicleService.calculateTotal(a,b));
    }

    @Test
    void VehiclesByRangeOfWeightOK(){
        //arrange
        List<VehicleDto> expectedVehicles = getVehicleDtoListToWeightOk();
        double weight_min = 15;
        double weight_max = 20.52;

        //act
        List<VehicleDto> actual= vehicleService.searchVehiclesByRangeOfWeight(weight_min,weight_max);

        //assert
        assertEquals(expectedVehicles,actual);
    }
}
