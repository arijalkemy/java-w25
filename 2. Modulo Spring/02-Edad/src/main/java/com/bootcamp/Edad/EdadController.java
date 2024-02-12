package com.bootcamp.Edad;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class EdadController {

    @GetMapping("/{dia}/{mes}/{año}")
    public int calcularEdad(@PathVariable int dia, @PathVariable int mes, @PathVariable int año){
        LocalDateTime fechaActual = LocalDateTime.now();

        if(año > fechaActual.getYear()){
            return -1;
        }else {
            if(año == fechaActual.getYear()){
                if(mes > fechaActual.getMonthValue()){
                    return -1;
                }else {
                    if(mes == fechaActual.getMonthValue()){
                        if( dia > fechaActual.getDayOfMonth()){
                            return -1;
                        }
                    }
                }
            }
        }
        int edad = fechaActual.getYear() - año;
        if(mes > fechaActual.getMonthValue()){
            edad -= 1;
        }else {
            if(mes == fechaActual.getMonthValue()){
                if(dia < fechaActual.getDayOfMonth()){
                    edad -=1;
                }
            }
        }
        return edad;
    }
}
