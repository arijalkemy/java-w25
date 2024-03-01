package com.bootcampW22.EjercicioGlobal.exampleTests;

import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;
import com.bootcampW22.EjercicioGlobal.entity.Vehicle;
import com.bootcampW22.EjercicioGlobal.exception.NotFoundException;
import com.bootcampW22.EjercicioGlobal.repository.IVehicleRepository;
import com.bootcampW22.EjercicioGlobal.repository.VehicleRepositoryImpl;
import com.bootcampW22.EjercicioGlobal.service.VehicleServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.DynamicPropertySource;

import java.util.ArrayList;
import java.util.List;

import static com.bootcampW22.EjercicioGlobal.util.ObjectFactory.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class VehicleServiceTest {
    @Mock
    VehicleRepositoryImpl vehicleRepository;

    @InjectMocks
    VehicleServiceImpl vehicleService;

    @Test
    void searchVehiclesByYearAndColorOKTest(){
        //ARRANGE
        String color = "red";
        int year = 1998;
        List<Vehicle> returnMockRepo = getVehicleList();
        List<VehicleDto> expected = getVehicleDtoList();

        when(vehicleRepository.findVehiclesByYearAndColor(anyString(),anyInt())).thenReturn(returnMockRepo);
        //ACT
        List<VehicleDto> actual = vehicleService.searchVehiclesByYearAndColor(color,year);
        //ASSERT
        assertEquals(expected,actual);



    }


    @Test
    @DisplayName("US0001-searchVehiclesByYearAndColor-Throw NotFoundException")
    void ThrowNotFoundTest(){
        //ARRANGE
        String color = "red";
        int year = 1998;

        when(vehicleRepository.findVehiclesByYearAndColor(any(),anyInt())).thenReturn(List.of());

        //ACT & ASSERT
        assertThrows(NotFoundException.class, ()->vehicleService.searchVehiclesByYearAndColor(color,year));
    }

}
