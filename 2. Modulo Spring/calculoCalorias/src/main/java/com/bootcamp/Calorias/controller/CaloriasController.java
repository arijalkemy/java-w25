package com.bootcamp.Calorias.controller;

import com.bootcamp.Calorias.dto.request.RequestCaloriasDTO;
import com.bootcamp.Calorias.dto.response.ResponseCaloriasDTO;
import com.bootcamp.Calorias.service.CaloriasService;
import com.bootcamp.Calorias.service.ICaloriasService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CaloriasController {
    private ICaloriasService caloriasService;
    public CaloriasController(CaloriasService caloriasService){
        this.caloriasService = caloriasService;
    }

    //Cantidad total de calorías del plato
    //Lista de ingredientes que lo conforman y cantidad de calorías de cada uno de ellos
    //El ingrediente con mayor cantidad de calorías
    @PostMapping("/obtenerDetallePlato")
    public ResponseEntity<ResponseCaloriasDTO> obtenerDetallePlato(@RequestBody RequestCaloriasDTO requestCaloriasDTO){
      ResponseCaloriasDTO responseCaloriasDTO =  caloriasService.getCalorias(requestCaloriasDTO);
        if ( responseCaloriasDTO != null){
            return new ResponseEntity<>(responseCaloriasDTO, HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    //Bonus

    @PostMapping("/obtenerDetallePlatoxPlato")
    public ResponseEntity<List<ResponseCaloriasDTO>> obtenerDetallePlatoxPlato(@RequestBody List<RequestCaloriasDTO> requestCaloriasDTO){
        List<ResponseCaloriasDTO> responseCaloriasDTO =  caloriasService.getCaloriasVarias(requestCaloriasDTO);
        if ( responseCaloriasDTO != null){
            return new ResponseEntity<>(responseCaloriasDTO, HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }




}
