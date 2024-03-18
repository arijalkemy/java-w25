package com.meli.obras_literarias.controller;

import com.meli.obras_literarias.dto.response.MessageDto;
import com.meli.obras_literarias.dto.request.ReqObraDTO;
import com.meli.obras_literarias.dto.response.ResObraDTO;
import com.meli.obras_literarias.service.IObrasLiterariasService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/obras")
public class ObrasLiterariasController {
    private final IObrasLiterariasService service;

    public ObrasLiterariasController(IObrasLiterariasService iObrasLiterariasService) {
        this.service = iObrasLiterariasService;
    }

    @PostMapping("/new")
    public ResponseEntity<MessageDto> createObra(@RequestBody ReqObraDTO reqObraDTO) {
        return new ResponseEntity<>(service.saveObra(reqObraDTO), HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<List<ResObraDTO>> getAll() {
        return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
    }

    @GetMapping("/autor/{autor}")
    public ResponseEntity<List<ResObraDTO>> getByAutor(@PathVariable String autor) {
        return new ResponseEntity<>(service.getByAutor(autor), HttpStatus.OK);
    }

    @GetMapping("/titulo/like/{palabraClave}")
    public ResponseEntity<List<ResObraDTO>> getByTituloLike(@PathVariable String palabraClave) {
        return new ResponseEntity<>(service.getByTituloLike(palabraClave), HttpStatus.OK);
    }

    @GetMapping("/cantPaginas/top5")
    public ResponseEntity<List<ResObraDTO>> getTop5PagesQuantity() {
        return new ResponseEntity<>(service.getTop5PagesQuantity(), HttpStatus.OK);
    }

    @GetMapping("/year/before/{year}")
    public ResponseEntity<List<ResObraDTO>> getByYearBefore(@PathVariable Integer year) {
        return new ResponseEntity<>(service.getByYearBefore(year), HttpStatus.OK);
    }

    @GetMapping("/editorial/{editorial}")
    public ResponseEntity<List<ResObraDTO>> getByEditorial(@PathVariable String editorial) {
        return new ResponseEntity<>(service.getByEditorial(editorial), HttpStatus.OK);
    }








}
