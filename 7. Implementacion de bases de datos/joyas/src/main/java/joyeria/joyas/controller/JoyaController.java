package joyeria.joyas.controller;

import joyeria.joyas.DTO.Response.JoyaDTO;
import joyeria.joyas.entity.Joya;
import joyeria.joyas.service.IJoyaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/jewelry")
public class JoyaController {

    private final IJoyaService joyaService;

    public JoyaController(IJoyaService joyaService) {
        this.joyaService = joyaService;
    }

    // 1. Crear una nueva joya y devolver el correspondiente status code con un mensaje informando su “nro identificatorio”. (URI: /jewerly/new).
    @PostMapping("/new")
    public ResponseEntity<?> createJewel(@RequestBody JoyaDTO joya){
        return new ResponseEntity<> (joyaService.create(joya), HttpStatus.OK);
    }
    //2. Devolver el listado de todas las joyas registradas. (URI: /jewerly).
    @GetMapping
    public ResponseEntity<?> getAllJewels(){
        return new ResponseEntity<>(joyaService.findAll(), HttpStatus.OK);
    }

    //3. Eliminar “lógicamente” una joya. Para ello, se deberá contemplar un campo que se llama “ventaONo”, el cual debe ser verdadero al crear una nueva joya, y falso cuando se solicite el eliminado. En caso de estar eliminado lógicamente, no deberá ser devuelto en el listado de joyas registradas. (URI: /jewerly/delete/{id})
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> removeJewel(@PathVariable Long id){
        return new ResponseEntity<>(joyaService.delete(id), HttpStatus.OK);
    }

    //4. Actualizar los datos de una joya. Una vez actualizados, devolver un mensaje con el correspondiente status code y los datos de la joya modificada. (URI: /jewerly/update/{id_modificar}). Envía el objeto completo para editar (sin cambiar la id).
    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateJewel(@PathVariable Long id, @RequestBody JoyaDTO joyaDTO){
        return new ResponseEntity<>(joyaService.update(joyaDTO, id), HttpStatus.OK);
    }

}
