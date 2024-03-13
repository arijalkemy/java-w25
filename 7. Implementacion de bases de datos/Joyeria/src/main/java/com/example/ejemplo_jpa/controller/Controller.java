package com.example.ejemplo_jpa.controller;

import com.example.ejemplo_jpa.dto.request.JewelDTO;
import com.example.ejemplo_jpa.dto.response.JewelCreatedDTO;
import com.example.ejemplo_jpa.service.IJewelryService;
import com.example.ejemplo_jpa.service.JewelryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jewelry")
public class Controller {

    //implemento la interface
    private final IJewelryService jewelryServ;

    public Controller(JewelryService jewelryService) {
        this.jewelryServ = jewelryService;
    }

    @GetMapping ("/jewels")
    public ResponseEntity<List<JewelDTO>> getJewels () {

        List<JewelDTO> jewelList = jewelryServ.getJewels();
        return ResponseEntity.ok(jewelList);

    }

    @PostMapping ("/new")
      public ResponseEntity<JewelCreatedDTO> createJewel(
              @RequestBody
              JewelDTO jewel
    ) {
        jewelryServ.saveJewel(jewel);
        return ResponseEntity.ok(
                new JewelCreatedDTO("Joya creada exitosamente")
        );
    }

    //acá también puedo poner un objeto y lo relaciona a la id
    // (si se llaman igual ambos parámetros)
    @PostMapping("delete/{id}")
    public String deleteJewel (@PathVariable long id) {
        jewelryServ.deleteJewel(id);
        return "El estudiante fue borrado correctamente";
    }

    @PostMapping ("update/{id}")
    public JewelDTO editJewel (
            @PathVariable long id,
            @RequestBody JewelDTO jewelDTO) {
        JewelDTO jewelToModify = jewelryServ.findJewel(id);
        //esto puede ir en el service
        /*jewelToModify.setNombre(newName);
        jewelToModify.setMaterial(newLastname);*/
        jewelToModify.setNombre(jewelDTO.getNombre());
        jewelToModify.setMaterial(jewelDTO.getMaterial());
        jewelToModify.setPeso(jewelDTO.getPeso());
        jewelToModify.setParticularidad(jewelDTO.getParticularidad());
        jewelToModify.setPoseePiedra(jewelDTO.getPoseePiedra());
        jewelToModify.setVentaONo(jewelDTO.getVentaONo());
        jewelryServ.saveJewel(jewelToModify);
        jewelDTO.setId(id);
        return jewelDTO;
    }
}
