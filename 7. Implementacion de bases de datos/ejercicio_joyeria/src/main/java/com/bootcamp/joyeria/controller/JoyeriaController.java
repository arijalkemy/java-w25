package com.bootcamp.joyeria.controller;

import com.bootcamp.joyeria.dto.GenericResponseDTO;
import com.bootcamp.joyeria.dto.JoyaDTO;
import com.bootcamp.joyeria.services.IJoyeriaService;
import com.bootcamp.joyeria.services.JoyeriaServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/jewerly")
public class JoyeriaController {
    //rear una nueva joya y devolver el correspondiente status
    // code con un mensaje informando su “nro identificatorio”. (URI: /jewerly/new).
    IJoyeriaService joyeriaService;
    public JoyeriaController(JoyeriaServiceImpl joyeriaService){
        this.joyeriaService = joyeriaService;
    }
    @PostMapping("/new")
    public ResponseEntity<?> saveJoya(@RequestBody JoyaDTO joyaDTO){
        return new ResponseEntity<>(joyeriaService.save(joyaDTO), HttpStatus.OK);
    }
    //Devolver el listado de todas las joyas registradas. (URI: /jewerly).
    @GetMapping()
    public ResponseEntity<?> getAll(){
        return new ResponseEntity<>(joyeriaService.findAll(), HttpStatus.OK);
    }
    //Eliminar “lógicamente” una joya.
    // Para ello, se deberá contemplar un campo que se llama “ventaONo”,
    // el cual debe ser verdadero al crear una nueva joya,
    // y falso cuando se solicite el eliminado.
    // En caso de estar eliminado lógicamente,
    // no deberá ser devuelto en el listado de joyas registradas.
    // (URI: /jewerly/delete/{id})
    @PatchMapping("delete/{id}")
    public ResponseEntity<?> deleteJewelry(@PathVariable Integer id){
        return new ResponseEntity<>(this.joyeriaService.delete(id), HttpStatus.OK);
    }
    //Actualizar los datos de una joya.
    // Una vez actualizados, devolver un mensaje con el correspondiente status code
    // y los datos de la joya modificada. (URI: /jewerly/update/{id_modificar}).
    // Envía el objeto completo para editar (sin cambiar la id).

    @PutMapping("/update/{id_modificar}")
    public ResponseEntity<?> updateJewelry(@PathVariable Integer id_modificar, @RequestBody JoyaDTO joyaDTO){
        return new ResponseEntity<>(this.joyeriaService.update(id_modificar, joyaDTO), HttpStatus.OK);

    }
}
