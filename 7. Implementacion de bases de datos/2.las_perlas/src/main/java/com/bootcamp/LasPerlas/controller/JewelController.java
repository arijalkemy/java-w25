package com.bootcamp.LasPerlas.controller;

import com.bootcamp.LasPerlas.dto.JewelRequestDTO;
import com.bootcamp.LasPerlas.dto.JewelResponseDTO;
import com.bootcamp.LasPerlas.model.Jewel;
import com.bootcamp.LasPerlas.service.IJewelService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jewerly")
public class JewelController {

    private final IJewelService jewelService;

    public JewelController(IJewelService jewelService) {
        this.jewelService = jewelService;
    }

    @PostMapping ("/new")
    public String saveJewel (@RequestBody JewelRequestDTO jewel) {
        JewelResponseDTO jewelResponseDTO = jewelService.createJewel(jewel);
        return "Status Code: " + HttpStatus.OK + ", Id: " + jewelResponseDTO.getNumberIdentification();
    }

    @GetMapping
    public List<JewelResponseDTO> getJewerly () {
        return jewelService.getAllJewelry();
    }

    @PutMapping ("/delete/{id}") // porque es un borrado logico es PUT
    public String deleteJoya (@PathVariable Long id) throws Exception {
        jewelService.deleteJewel(id);
        return "Eliminado correctamente";
    }

    @PutMapping ("/update/{id_modificar}")
    public String editJoya (@PathVariable Long id_modificar,
                            @RequestBody JewelRequestDTO jewel) {
        jewelService.updateJewel(id_modificar, jewel);
        return "Joya modificada correctamente";
    }

}
