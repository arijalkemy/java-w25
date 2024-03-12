package com.bootcamp.ejercicio_empleados_elastic.controller;

import com.bootcamp.ejercicio_empleados_elastic.domain.Direccion;
import com.bootcamp.ejercicio_empleados_elastic.domain.Empleado;
import com.bootcamp.ejercicio_empleados_elastic.repository.IEmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    @Autowired
    IEmpleadoRepository empleadoRepository;

    @GetMapping("/setup")
    public void setup(){
        Empleado e = new Empleado(
                null,
                "nombre",
                23,
                new Direccion(
                        "1",
                        "2",
                        "3"
                )
        );
        this.empleadoRepository.save(e);
    }
}
